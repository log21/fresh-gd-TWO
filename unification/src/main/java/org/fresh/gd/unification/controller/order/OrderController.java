package org.fresh.gd.unification.controller.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.fresh.gd.commons.consts.pojo.RequestData;
import org.fresh.gd.commons.consts.pojo.ResponseData;
import org.fresh.gd.commons.consts.pojo.dto.order.GdOrderDTO;
import org.fresh.gd.commons.consts.pojo.dto.order.OrderCountDTO;
import org.fresh.gd.commons.consts.pojo.dto.order.OrderPageDTO;
import org.fresh.gd.commons.consts.utils.CloudMdSms;
import org.fresh.gd.commons.consts.utils.PageBean;
import org.fresh.gd.unification.fegin.order.OrderFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @DATA 2019/4/24 14:58
 * @Author 郭家恒
 * @Description TODO
 */
@RestController
@Slf4j
@RequestMapping("/unification")
@Api(description = "订单服务")
public class OrderController {
    @Autowired
    OrderFeginService orderFeginService;

    @ApiOperation(value ="添加订单")
    @PostMapping("/insertOrder")
    public ResponseData<List> insertOrder(@RequestBody RequestData<GdOrderDTO> requestData) {
        ResponseData<List> responseData = orderFeginService.insertOrder(requestData);
        return responseData;
    }

    @ApiOperation(value = "订单分页")
    @PostMapping("/selOrderPage")
    public ResponseData<PageBean<GdOrderDTO>> selOrderPage(@RequestBody RequestData<OrderPageDTO> orderPageDTO){
        return orderFeginService.selOrderPage(orderPageDTO);
    }

}
