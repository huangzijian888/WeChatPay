package cn.huangzijian888.wechatpay.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 签名验证工具类
 *
 * @author huangzijian888
 */
public class SignUtils {
    /**
     * 将集合params内非空参数值的参数按照参数名ASCII码从小到大排序（字典序）排列
     * 并使用URL键值对的格式（即key1=value1&key2=value2…）拼接
     *
     * @param params
     * @param key
     * @return
     */
    public static String encodeSign(Map params, String key) {
        StringBuffer keyStr = new StringBuffer();
        Set es = params.entrySet();
        Iterator iterator = es.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)) {
                keyStr.append(k + "=" + v + "&");
            }
        }
        keyStr = keyStr.append("key=" + key);
        return keyStr.toString();
    }
}
