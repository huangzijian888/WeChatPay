package cn.huangzijian888.wechatpay.util;

import lombok.Data;

/**
 * @author huangzijian888
 */
@Data
public class CommonResult {
    private Integer code;
    private String msg;

    public CommonResult() {
    }

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
