package org.fresh.gd.commons.consts.pojo.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import org.fresh.gd.commons.consts.pojo.dto.shoping.GdComdityparticularDTO;

import java.util.List;

/**
 * @DATA 2019-04-22 09:07
 * @Author 张国伟  WeChat:17630376104
 * @Description
 */
@ApiModel("订单数据模型")
@Data
public class GdOrderDTO {
    /**
     * 订单ID
     */
    @ApiModelProperty("订单ID")
    private String orderid;

    /**
     * 会员手机号(0-普通用户 1=会员)
     */
    @ApiModelProperty("会员编号(0-普通用户)")
    private String vipId;

    /**
     * 交易场景(2-线上 1-线下)
     */
    @ApiModelProperty("交易场景(2-线上 1-线下)")
    private Integer orderscene;

    /**
     * 交易手段(1-会员余额，2-支付宝，3-微信，4-现金)
     */
    @ApiModelProperty("交易手段(1-会员余额，2-支付宝，3-微信，4-现金))")
    private Integer ordermeans;

    /**
     * 交易类型(0-消费 1-退款)
     */
    @ApiModelProperty("交易类型(0-消费 1-退款)")
    private Integer ordertype;

    /**
     * 交易金额
     */
    @ApiModelProperty("交易金额")
    private String ordermoney;

    /**
     * 交易时间
     */
    @ApiModelProperty("交易时间")
    private String orderTime;

    /**
     * 收款方(店铺ID)
     */
    @ApiModelProperty("收款方(店铺ID)")
    private Integer storeid;

    /**
     * 订单状态
     */
    @ApiModelProperty("订单状态")
    private Integer orderStat;

    /**
     * 门店名称
     */
    @ApiModelProperty("门店名称")
    private String belongStoreNam;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 抹零
     */
    @ApiModelProperty("抹零")
    private String priceml;

    /**
     * 地址编号
     */
    @ApiModelProperty("地址编号")
    private Integer addressId;

    /**
     * 收货人
     */
    @ApiModelProperty("收货人")
    private String recipients;

    @ApiModelProperty("地址编号")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("地址状态")
    private Integer status;


    @ApiModelProperty("订单商品详细")
    private List<GdOrdershopDTO> tableData;

    /**
     * 应付价格
     */
    @ApiModelProperty("应付价格")
    private String comdityprice;

    /**
     * 实付价格
     */
    @ApiModelProperty("实付价格")
    private String comditytrueprice;
    /**
     * 找零
     */
    @ApiModelProperty("找零")
    private String gchange;

    /**
     * 成本
     */
    @ApiModelProperty("成本")
    private float rfmoney;

    /**
     *  付款码
     */
    @ApiModelProperty("付款码")
    private String fukuanma;
}
