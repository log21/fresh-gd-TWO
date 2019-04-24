package org.fresh.gd.commons.consts.api.order;

import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.order.GdOrderDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @DATA 2019/4/24 13:44
 * @Author 郭家恒
 * @Description TODO
 */
@RequestMapping("/OrderService")
public interface GDOrderService {

    /** 功能描述:
    *
    * @param: [gdOrderDTO]
    * @return: org.fresh.gd.commons.consts.pojo.ResponseData<java.lang.Integer>
    * @auther: 郭家恒
    * @date: 2019/4/24 13:53
    */
    @PostMapping("/insertOrder")
    public ResponseData<List> insertOrder(RequestData<GdOrderDTO> gdOrderDTORequestData);

}
