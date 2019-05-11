package org.gw.shoping.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang.StringUtils;
import org.fresh.gd.commons.consts.api.shoping.GdReplenishService;
import org.fresh.gd.commons.consts.consts.Consts;
import org.fresh.gd.commons.consts.exceptions.BizException;
import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.management.GdStoreDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.*;
import org.fresh.gd.commons.consts.utils.VeDate;
import org.gw.shoping.entity.GdReplenish;
import org.gw.shoping.fegin.ManageFeginService;
import org.gw.shoping.mapper.GdPurchaseMapper;
import org.gw.shoping.mapper.GdReplenishMapper;
import org.gw.shoping.mapper.GdStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @DATA 2019-04-22 11:11
 * @Author 张国伟  WeChat:17630376104
 * @Description
 */
@RestController
public class GdReplenishServiceImpl implements GdReplenishService {

    @Autowired
    GdReplenishMapper gdReplenishMapper;

    @Autowired
    GdPurchaseMapper gdPurchaseMapper;

    @Autowired
    GdStorageMapper gdStorageMapper;

    @Autowired
    GdPurchaseServiceImpl gdPurchaseService;

    @Autowired
    ManageFeginService manageFeginService;

    /**
     * 功能描述
     * 添加一条进货信息
     *
     * @param replenishDTORequestData
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.lang.Integer>
     * @author zgw
     */
    @Override
    public ResponseData<Integer> saveGdReplenish(@RequestBody RequestData<GdReplenishDTO> replenishDTORequestData) {
        ResponseData<Integer> responseData = new ResponseData<>();
        GdReplenishDTO gdReplenishDTO = replenishDTORequestData.getData();
        if (StringUtils.isEmpty(gdReplenishDTO.getUsername())
        ) {
            throw new BizException("制单人员不能为空");
        }
        if (gdReplenishDTO.getStoreid() == 0 || gdReplenishDTO.getStoreid() == null)
        {
            throw new BizException("店铺ID不能为空");
        }
        if (gdReplenishDTO.getSupplierID() == 0 || gdReplenishDTO.getSupplierID() == null)
        {
            throw new BizException("供应商ID不能为空");
        }
        gdReplenishDTO.setReceiptNo(Consts.getStringRandom(6).toUpperCase());
        gdReplenishDTO.setReplenishTime("" + VeDate.getStringDate());
        Integer saveGdReplen = gdReplenishMapper.saveGdReplen(gdReplenishDTO);

        for (GdPurchaseDTO gdPurchaseDTO : replenishDTORequestData.getData().getList())
        {
            gdPurchaseDTO.setReplenishId(gdReplenishDTO.getReplenishId());
        }

        if (saveGdReplen > 0)
        {
            gdPurchaseService.saveGdPurchase(replenishDTORequestData);
            return responseData;
        }
        responseData.setCode(Consts.Result.ERROR_PARAM.getCode());

        return responseData;
    }



    /**
     * 功能描述
     * 入库前的查询  查询所有进货信息
     *
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.util.List   <   sts.pojo.dto.shoping.GdShopAllDTO>>
     * @author zgw
     */
    @Override
    public ResponseData<List<GdReplenishDTO>> selGdShopAll(@RequestBody RequestData<ReplenishInDTO> replenishInDTORequestData) {
        ResponseData<List<GdReplenishDTO>> responseData = new ResponseData<>();
        ReplenishInDTO replenishInDTO = replenishInDTORequestData.getData();
        List<Integer> mdid = new ArrayList<>();
        List<GdReplenishDTO> gdShopAllDTOS = gdReplenishMapper.selGdShopAllByBh(replenishInDTO);
        for (GdReplenishDTO allDTO : gdShopAllDTOS)
        {
            List<GdPurchaseDTO> list = gdReplenishMapper.QueryPurByreId(allDTO.getReplenishId());
            allDTO.setList(list);
            mdid.add(allDTO.getStoreid());
        }
        RequestData<List<Integer>> mdids = new RequestData<>();
        mdids.setData(mdid);
        ResponseData<List<GdStoreDTO>> responseData1 = manageFeginService.QueryByid(mdids);
        for (GdReplenishDTO purdto : gdShopAllDTOS)
        {
            for (GdStoreDTO dto : responseData1.getData())
            {
                if (purdto.getStoreid().equals(dto.getStoreid()))
                {
                    purdto.setStorename(dto.getStorename());
                    break;
                }
            }
        }
        responseData.setData(gdShopAllDTOS);
        return responseData;
    }

    /**
     * 功能描述:
     * 根据进货ID删除进货记录
     *
     * @param requestData
     * @param: [requestData]
     * @return: org.fresh.gd.commons.consts.pojo.ResponseData<java.util.List < fresh.gd.commons.consts.pojo.dto.shoping.GdReplenishDTO>>
     * @auther: 郭家恒
     * @date: 2019/5/6 15:47
     */
    @Transactional
    @Override
    public ResponseData<Integer> delReplenishById(@RequestBody RequestData<Integer> requestData) {
        ResponseData responseData = new ResponseData();
        Wrapper<GdReplenish> wrapper = new QueryWrapper<>();
        ((QueryWrapper<GdReplenish>) wrapper).eq("replenishId", requestData.getData());
        GdReplenish gdReplenish = gdReplenishMapper.selectOne(wrapper);
        if (gdReplenish.getIsnostorage() == 1) {
            //删除入库表
            gdStorageMapper.delStorageByRid(requestData.getData());
        }
        //删除入库表中的信息
        int save = gdReplenishMapper.deleteById(requestData.getData());
        //删除入库详细表
        save = gdPurchaseMapper.deletePurById(requestData.getData());
        return responseData;
    }

}
