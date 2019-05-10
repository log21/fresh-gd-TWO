package org.fresh.gd.commons.consts.api.shoping;

import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdReplenishAndPurchaseDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdReplenishDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdShopAllDTO;
import org.fresh.gd.commons.consts.pojo.dto.shoping.ReplenishInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @DATA 2019-04-22 11:03
 * @Author 张国伟  WeChat:17630376104
 * @Description TODO 进货管控
 */
@RequestMapping("/GdReplenishService")
public interface GdReplenishService {


    /**
     * 功能描述
     * 添加一条进货信息
     *
     * @param replenishDTORequestData
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.lang.Integer>
     * @author zgw
     */
    @PostMapping("/saveGdReplenish")
    ResponseData<Integer> saveGdReplenish(RequestData<GdReplenishDTO> replenishDTORequestData);


    /**
     * 功能描述
     * 查询入库前综合信息
     *
     * @param replenishInDTORequestData
     * @return org.fresh.gd.commons.consts.pojo.ResponseData<java.util.List   <   org.fresh.gd.commons.consts.pojo.dto.shoping.GdShopAllDTO>>
     * @author zgw
     */
    @PostMapping("/selGdShopAll")
    ResponseData<List<GdReplenishDTO>> selGdShopAll(RequestData<ReplenishInDTO> replenishInDTORequestData);


    @PostMapping("/delReplenishById")
    ResponseData<Integer> delReplenishById(@RequestBody RequestData<Integer> requestData);

}
