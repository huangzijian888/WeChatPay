package cn.huangzijian888.wechatpay.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import org.junit.Test;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class SignUtilsTest {

    @Test
    public void encodeSign() {
        SortedMap<Object, Object> params = new TreeMap<>();
        params.put("appid", "wxd930ea5d5a258f4f");
        params.put("mch_id", "10000100");
        params.put("device_info", "1000");
        params.put("body", "test");
        params.put("nonce_str", "ibuaiVcKdpRxkhJA");
        String key = "192006250b4c09247ec02edce69f6a2d";
        String sign = SignUtils.encodeSign(params, key);
        Digester digester = new Digester(DigestAlgorithm.MD5);
        String strA = digester.digestHex(sign).toUpperCase();
        System.out.println(RandomUtil.randomString(16));
        System.out.println(sign);
        System.out.println(strA);
    }
}