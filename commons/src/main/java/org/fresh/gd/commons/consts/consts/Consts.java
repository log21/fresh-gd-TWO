package org.fresh.gd.commons.consts.consts;


import com.alibaba.fastjson.JSON;

import java.util.Random;


public class Consts {


    /**
     * 将任意类型转换成字符串
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> String beanToString(T value) {
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return value + "";
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return value + "";
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * 把一个字符串转换成bean对象
     *
     * @param str
     * @param <T>
     * @return
     */
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }


    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 基于毫秒的换算单位
     */
    public static class Time {
        /**
         * 用于表示秒
         */
        public static final long SECONDS = 1000;

        /**
         * 分钟
         */
        public static final long MINUTES = SECONDS * 60;
        /**
         * 小时
         */

        public static final long HOUR = MINUTES * 60;
        /**
         * 一天
         */
        public static final long DAY = HOUR * 24;

        /**
         * yyyyMMdd HHmmss
         */
        public static final String TIME_PARTTRN_ONE = "yyyyMMddHHmmss";
    }

    public enum Role {

        /**
         * 超级管理员
         */
        SUPER_ADMIN("SUPER_ADMIN", "店长"),

        /**
         * 收银员
         */
        CASHIER("CASHIER", "收银员");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        Role(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }


    public static class Department {

        public static final String DEPARTMENT_CODE_PATTERN = "00000";

        public static final String DEPARTMENT_PREFIX = "MD";


    }

    public static class Promotion {
        public static final int PROMOTION_STAT_ENABLED = 1;
    }


    public static class User {
        /**
         * 用户为激活状态
         */
        public static final int USER_STAT_ACTIVE = 1;


    }

    public static class Order {
        public static final String ORDER_NO_PATTERN = "000000";
        /**
         * 已经支付
         */
        public static final int ORDER_PAYMENTED = 1;

        /**
         * 已扣库存
         */
        public static final int ORDER_REDUCE_STOCK = 1;
        /**
         * 未扣库存
         */
        public static final int ORDER_NOT_REDUCE_STOCK = 0;

        public static final int ORDER_MAX_SEQ = 999999;

        /**
         * 超市门店收银订单
         */
        public static final int ORDER_TYPE_STORE = 1;

        /**
         * 余额消费
         */
        public static final int PAY_CHANNEL_BALANCE = 4;


        public static final String ORDER_DELAYED_QUEUE = "order:delayed:queue";
    }


    public static class Dic {


        public static final String DIC_CODE_PREFIX = "ZD";

        public static final String DIC_CODE_PATTERN = "00000";

    }

    public enum DicType {
        DIC_BRAND(100, "品牌"),
        DIC_UNIT(101, "单位"),
        DIC_VIP_CARD_INTERVAL(201, "VIP续期卡");

        private int type;
        private String name;

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        DicType(int type, String name) {
            this.type = type;
            this.name = name;
        }
    }


    public static class Org {


        public static final String ORG_CODE_PATTERN = "00000";

        public static final String ORG_CODE_PREFIX = "SH";
    }


    public static class Supplier {
        public static final String SUPPLIER_CODE_PATTERN = "00000";

        public static final String SUPPLIER_CODE_PREFIX = "GYS";
    }


    /**
     * 功能描述
     * 前缀 表名：属性：ID
     *
     * @param
     * @author zgw
     * @return
     */
    public static class RedisPrefix {

        public static final String PREFFIX_USER_IMEI = "User:imie";

        public static final String PREFFIX_USER_ID = "User:tk";

        public static final String PREFFIX_COMMONS_SEQ = "commons:seq";

        public static final String PREFIX_ORDER_SEQ = "order:seq";

        public static final String PREFIX_PAY_RECORD_SEQ = "pay:record:seq";


        public static final String PREFFIX_GOODS_GCODE_SEQ = "goods:gcode:seq";


    }


    public static class Settlement {

        public static final int QIAN_KUAN = 1;

        public static final int HUI_KUAN = 2;


    }

    /**
     * 支付模块常量
     */
    public static class Payment {
        public static final String PREFIX_PAYMENT_RECORD = "62";
        public static final String PAYMENT_RECORD_PATTERN = "00000";

        /**
         * 支付记录：收入
         */
        public static final int PAYMENT_RECORD_SHOURU = 1;

        /**
         * 收银的支付渠道
         */
        public static final int PAYMENT_CHANNEL_CASHIER = 1;
        /**
         * 下单业务模型
         */
        public static final int PAYMENT_BIZ_TYPE_ORDER = 1;

        /**
         * 充值的业务模型
         */
        public static final int PAYMENT_BIZ_TYPE_CHONG = 2;
    }


    public static class Purchase {

        /**
         * 未入库状态
         */
        public static final int UNREACH_STOCK = 0;

        /**
         * 已经入库状态
         */
        public static final int REACH_STOCK = 1;

        public static final int DISCARD_STOCK = 2;

        public static final String PURCHASE_BATCH_NO_PATTERN = "00000";

        public static final String PUHCHASE_BATCH_NO_PREFIX = "PUR";


    }


    public static class ReturnPurchase {

        public static final String RETURN_PURCHASE_PREFIX = "TUH";

        public static final String RETURN_PURCHASE_PATTERN = "00000";


        public static final int WEI_CHUKU_TYPE = 0;


    }

    public static class MemberCard {
        /**
         * 会员占有状态
         */
        public static final int CARD_OWNER_OCCUPY = 1;
        /**
         * 会员卡处于禁用状态
         */
        public static final int CARD_DISABLE = 0;
    }


    public static class StockIORecord {


        /**
         * 入库类型
         */
        public static final int STOCK_IN_TYPE = 1;

        /**
         * 出库类型
         */
        public static final int STOCK_OUT_TYPE = 2;

        /**
         * 业务类型为采购入库
         */
        public static final int BIZ_TYPE_PURCHASE = 1;


        /**
         * 业务类型为退货
         */
        public static final int BIZ_TYPE_TUIHUO = 2;

        /**
         * 业务类型为零售
         */
        public static final int BIZ_TYPE_LINGSHOU = 3;


    }

    public static class Stock {
        public static final String TOPIC_STOCK_PREFIX_QUEUE = "topic:stock:";
        public static final String STOCK_REDUCE_OPERATE = "stock:reduce:operate:";
        public static final String STOCK_REALEASE_LOCK = "stock:release:operate:";

        public static final int STOCK_ROLLBACK_STAT_DONE = 1;
    }

    public enum GoodsCodeType {
        BAR_CODE(0, "商品条码"),

        AUTO_GENERATE(1, "自动生成"),

        MULTIPLE_CODE(2, "一品多码");


        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        GoodsCodeType(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }


    public enum Result {
        /**
         * 成功
         */
        SUCCESS(0, "处理成功"),

        /**
         * 业务错误
         */
        BIZ_ERROR(101, "业务错误"),
        /**
         * 请求参数错误
         */
        ERROR_PARAM(100, "请求参数错误");

        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        Result(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }

    /**
     * 功能描述:
     * 短信接口所需常量
     *
     * @param:
     * @return:
     * @auther: 郭家恒
     * @date: 2019/4/25 16:59
     */
    public static class QCloudSms {
        /**
         * APPID
         * 短信应用 SDK AppID
         */
        public final static int APPID = 1400203906;

        /**
         * APPKEY
         * 短信应用 SDK AppKey
         */
        public static final String APPKEY = "9bc697c8f003b6eae2ab76270533b3a6";
        /**
         * TEMPLATEID
         * 短信模板 ID，需要在短信应用中申请
         */
        public static final int TEMPLATEID = 0;

        /**
         * 签名
         */
        public static final String SMSSIGN = "格调生鲜";

    }

    /**
     * 功能描述:
     * 秒地短信接口所需常量
     *
     * @param:
     * @return:
     * @auther: 郭家恒
     * @date: 2019/4/25 18:10
     */
    public static class MdSms {
        /**
         * 开发者ID
         */
        public static final String ACCOUNT_SID = "b27718c8f2da489f9bf90f30ce78338a";//SID
        /**
         * 密匙
         */
        public static final String TOKEN = "643417d1f64f4d36862d59d6b02ff3d9"; //pwd
        /**
         * 请求地址
         */
        public static final String path = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";


    }

    public class AliPayConfig {
        /**
         * appID
         */
        public static final String appid = "2016091700534905";
        /**
         * pid
         */
        public static final String pid = "2088102176086492";
        /**
         * 私钥
         */
        public static final String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSEkbNTg1TH2iaPRQK52HBbxQW+OrDKvUvpdzcWX+eqzqlVENAtq9JGt0YBnjXIudE5PvVXlvvuna2pn/6tBhf68vdUkA7u6zCV66Enu1YDkBXwmItkcso5hpUfHOnGgcZxwQYYkPqNmY78xv9iGgaSZ+rL8p+hCv/DIMcunculowEGaScUNranK2ibFw3Q/JSLEvsX9EyP1FFms/R+uVvq+SGhjWA8wLvrIeaFmomeg0uz0kM6ZXPRLWAhJRG4WKhOaGZUtf36gIQ8rfZJHX7PIewVmdPCAZaslSamWX3Gy7mdzvGUNKMWJtroYminb73/2YmHsJMA2Cid6jZgD7HAgMBAAECggEAOkwpDc9U6hPi/4vY7/Egxr66WeDGcVY3vOiJmTfvAzh7k3hpzu4aTyb1jp0mpVY8zvZEvAeI0citkIArG7e88qt9Fbu5/x0L+hRchnmXaElnzJ676EwDtTMA1y9ESTDOHK+dJs4xJMzJSKviQ/Go+rTfkMbmHlBJ7uTjfxe8cU7sRFlii//QYDV5sAHJ9NsgFMjyoCtsSCR538cyWeq60FQEtYRifjRI0mYocI3GL0mK9z6lrqc2WVzPuJcTE+w6/LZTR43X5e+QzsfHWF5EsrLTnRDqknB67IH/XDX3dzzgaYtUCOrKw3QbMuTGNxYsmWgXG4HAq2Ij2i3onWn1YQKBgQD9vY4xZZYdOIuJPWDSjptoJF0Tppdb4KPAEn29On7aVMl/xhcX/OvkeoJ6d5f+zZfJ6GY5A0+C0m9b78+tpFIrc/Ji3TtI2t96QVrKMZUniRUKO2fcgzWGCEjWblVkzXmlq6rEq68TJoi6kyrNJ94A1QGTRK1cFZvIoFKvHDfItQKBgQCTX0VsCSzbxzOxW7uJH72/7rCmT78EzobqYVbCKtVgOcjvo84Non+Nk9QXA1kfOtHMQI+xwJQxIJXWoogT5uHpEF96k4WdP6eciYyD1NcYuRkjfeRT4BxxFUBPA9mjTxgLsSackWJoEmUhVb5AfmLX8MFzKdyM4Z43Eg+ml46DCwKBgQCsCx6id5K09WYHA8rmeTL+BcnmTQpLjaD51o/TAhqIxvxo2lNGPINlQ3u8teIlLhlBGYZWGdyLg0tmNs/FmKjuNYufZQmReHYWWsHIXp4XVGcjrOvbJEviOTPJ0L2tv3Q/1InRF+d5QKNsfeSDfgiU39hVljdFPJGIEsx9VtCsEQKBgG9oGyvzt7ShX2OZTCj6FNCuWV4wdN/mXLl8QkDgbpOiu1LlitRl3nUhpriK8GmaZpU4zSf7xEtrLbqm/aXF6Uvt86/PK7fXMhc1KENUuBJZgzaAagY6KmYWQZo59+Hr3eqgzeaYRUMVfNv5XKyWnpRNzYAIylC6EofhIHG4qqRHAoGAFegElc/QCFGdtL6Fl2HOCbtdM0Z32yjylRlJiAH6GeFhXrq3KyBbCTC2bCqrMhnh3rWiXUOWk9e4LjtsP9hxQ/4NtZLxrsVN5jaWRZT+pBiwGoCOAnocWK+I9coNgzYLMu7BSHyrEsnez7quM7ZiHZviedO3Ex7O9raUDu9ztbk=";
        /**
         * 公钥
         */
        public static final String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkhJGzU4NUx9omj0UCudhwW8UFvjqwyr1L6Xc3Fl/nqs6pVRDQLavSRrdGAZ41yLnROT71V5b77p2tqZ/+rQYX+vL3VJAO7uswleuhJ7tWA5AV8JiLZHLKOYaVHxzpxoHGccEGGJD6jZmO/Mb/YhoGkmfqy/KfoQr/wyDHLp3LpaMBBmknFDa2pytomxcN0PyUixL7F/RMj9RRZrP0frlb6vkhoY1gPMC76yHmhZqJnoNLs9JDOmVz0S1gISURuFioTmhmVLX9+oCEPK32SR1+zyHsFZnTwgGWrJUmpll9xsu5nc7xlDSjFiba6GJop2+9/9mJh7CTANgoneo2YA+xwIDAQAB";
        /**
         * 支付宝公钥
         */
        public static final String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtjkGCPRBqx0aNuSjcxxgB8aETkBIWs5FtMUrv/dmsUqXeb6ktNzJ6kQ0Ws60XpmO8GgSKFfAsmTadshn4AW5JOHQzAzzYss8OWm2OikcK/owMTEoyWYvhskQ174f/pgmq87Pkd2nUXx1a8uQklN7wqgML73N/lSqa/FPdIJhAh9vgTTSib2p5eG/aeW3QWFajgDTb4VuE3RYZ7B3+M0Q0rwW2JSBqjY/pr0MnVPwL4CsR5XlC9kEdqWD6cxS0/Rmue9e3Kvahjtqc+5FRH0S97v5tZExhNQlNXYwIxlwE2djTK8C3rJQuceiXxfR/+SO/vI5cFDVK5dI6v3rJzwbFwIDAQAB";

        /**
         * 签名类型
         */
        public static final String sign_type = "RSA2";
        /**
         * 当面付最大查询次数和查询间隔（毫秒）
         */
        public static final String max_query_retry = "5";
        public static final String query_duration = "5000";

        /**
         * 交易保障线程第一次调度延迟和调度间隔（秒）
         */
        public static final String heartbeat_delay = "5";
        public static final String heartbeat_duration = "900";
    }
}
