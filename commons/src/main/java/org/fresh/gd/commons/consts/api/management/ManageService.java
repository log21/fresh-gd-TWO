package org.fresh.gd.commons.consts.api.management;

import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.management.GdStoreDTO;
import org.fresh.gd.commons.consts.pojo.dto.management.ManageStoreDTO;

import org.fresh.gd.commons.consts.pojo.dto.oauth.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @DATA 2019-04-17 14:36
 * @Author 张国伟  WeChat:17630376104
 * @Description TODO  门店服务接口
 */
@RequestMapping("/manageService")
public interface ManageService {

    /**
     * 功能描述
     * 添加门店信息
     *
     * @param
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.lang.Integer>
     * @author zgw
     */
    @RequestMapping(value = "/inserStore", method = RequestMethod.POST)
    ResponseData<Integer> inserStore(GdStoreDTO manageStoreDTO);

    /**
     * 功能描述
     * 查询门店信息
     *
     * @param
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.util.List < org.fresh.gd.commons.consts.pojo.dto.management.ManageStoreDTO>>
     * @author zgw
     */
    @RequestMapping(value = "/selStroreByName", method = RequestMethod.POST)
    ResponseData<List<GdStoreDTO>> selStroreByName(GdStoreDTO manageStoreDTO);

    /**
     * 功能描述
     * 删除门店
     *
     * @param storeid
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.lang.Integer>
     * @author zgw
     */
    @RequestMapping(value = "/delByIdStro", method = RequestMethod.POST)
    ResponseData<Integer> delByIdStro(Integer storeid);


    @RequestMapping(value = "/selByYg",method = RequestMethod.POST)
    ResponseData<List<GdStoreDTO>> selByYg(RequestData<List<UserDTO>> requestData);


}