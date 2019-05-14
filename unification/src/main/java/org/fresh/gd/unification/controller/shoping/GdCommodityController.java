package org.fresh.gd.unification.controller.shoping;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.fresh.gd.commons.consts.exceptions.BizException;
import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.shoping.ComdityQueryDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdComditynameDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdCommodityDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdinventoryallDTO;
import org.fresh.gd.unification.fegin.shoping.GdCommodityFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @DATA 2019-04-21 11:30
 * @Author 张国伟  WeChat:17630376104
 * @Description 商品服务
 */
@Api(description = "商品信息")
@Slf4j
@RestController
@RequestMapping("/unification")
public class GdCommodityController {

    @Autowired
    GdCommodityFeignService gdCommodityFeignService;


    @GetMapping("/selShopAll")
    public ResponseData<List<GdCommodityDTO>> selShopAll() {

        ResponseData<List<GdCommodityDTO>> responseData = gdCommodityFeignService.selShopingAll();

        return responseData;
    }

    @PostMapping("/selByPage")
    public ResponseData<Page<GdCommodityDTO>> selByPage(@RequestBody RequestData<GdCommodityDTO> gdCommodityDTORequestData) {
        if (gdCommodityDTORequestData.getData() == null) {
            throw new BizException("请求错误");
        }
        return gdCommodityFeignService.selPageShop(gdCommodityDTORequestData);
    }

    @PostMapping("/nventoryall")
    public ResponseData<List<GdinventoryallDTO>> nventoryall(@RequestBody RequestData<GdComditynameDTO> requestData) {
        return gdCommodityFeignService.nventoryall(requestData);
    }

    /**
     * 功能描述:
     * 根据分类查询商品
     *
     * @param: [requestData]
     * @return: org.fresh.gd.commons.consts.pojo.ResponseData<java.util.List       <       org.fresh.gd.commons.consts.pojo.dto.shoping.GdCommodityDTO>>
     * @auther: 郭家恒
     * @date: 2019/4/28 15:25
     */
    @PostMapping("/QueryByType")
    public ResponseData<List<GdCommodityDTO>> QueryByType(@RequestBody RequestData<Integer> requestData) {
        return gdCommodityFeignService.QueryComByType(requestData);
    }

    /**
     * 功能描述:
     * 查询所有商品根据条件
     *
     * @param: [queryData]
     * @auther: 郭家恒
     * @date: 2019/5/14 18:14
     */
    @PostMapping("/QueryShopByWh")
    public ResponseData<List<GdCommodityDTO>> QueryShopByWh(@RequestBody RequestData<ComdityQueryDTO> queryData) {
        ResponseData<List<GdCommodityDTO>> listResponseData = gdCommodityFeignService.QueryShopbyWh(queryData);
        return listResponseData;
    }
}
