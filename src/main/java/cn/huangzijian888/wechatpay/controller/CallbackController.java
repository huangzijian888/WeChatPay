package cn.huangzijian888.wechatpay.controller;

import cn.huangzijian888.wechatpay.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzijian888
 */
@RestController
@RequestMapping("/callback")
public class CallbackController {
    @PostMapping("/wechat")
    public CommonResult wechat(@RequestParam("openid") String openId) {


        System.out.println("微信系统调用了我");
        System.out.println(openId);

        return new CommonResult(1, "success");
    }
}
