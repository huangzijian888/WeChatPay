package cn.huangzijian888.wechatpay.controller;

import cn.huangzijian888.wechatpay.util.SignUtils;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author huangzijian888
 */
@Controller
public class PayController {

    @Value("${wxPay.appId}")
    private String appId;
    @Value("${wxPay.mchId}")
    private String mchId;
    @Value("${wxPay.productId}")
    private String productId;
    @Value("${wxPay.key")
    private String key;
    private String nonceStr;
    private String timeStamp;
    private String sign;

    @GetMapping("/wechat")
    public String wxPay(HttpServletRequest request,
                        HttpServletResponse response) {
        timeStamp = String.valueOf(System.currentTimeMillis());
        nonceStr = RandomUtil.randomString(16);
        SortedMap<Object, Object> params = new TreeMap<>();
        params.put("appid", appId);
        params.put("mch_id", mchId);
        params.put("product_id", productId);
        params.put("nonce_str", nonceStr);
        params.put("time_stamp", timeStamp);
        sign = new Digester(DigestAlgorithm.MD5).
                digestHex(SignUtils.encodeSign(params, key)).
                toUpperCase();

        String qrCode = "weixin：//wxpay/bizpayurl?sign=" + sign
                + "&appid=" + appId
                + "&mch_id=" + mchId
                + "&product_id=" + productId
                + "&time_stamp=" + timeStamp
                + "&nonce_str=" + nonceStr;
        request.getSession().setAttribute("url", "http://qr.liantu.com/api.php?text=");
        request.getSession().setAttribute("qrCode", qrCode);
        return "index";
    }
}
