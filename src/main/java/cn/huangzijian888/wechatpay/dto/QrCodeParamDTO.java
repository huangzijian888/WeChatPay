package cn.huangzijian888.wechatpay.dto;

import lombok.Data;

/**
 * @author huangzijian888
 */
@Data
public class QrCodeParamDTO {
    private String appId;
    private String mchId;
    private String timeStamp;
    private String nonceStr;
    private String productId;
    private String sign;
}
