package com.islizx.util;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import org.springframework.cglib.beans.BeanMap;
import org.thymeleaf.expression.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizx
 * @date 2020-02-21 - 15:13
 */
public class ObjectUtil {
    public static String mapToString(Map<String, String[]> paramMap){

        if (paramMap == null) {
            return "";
        }
        Map<String, Object> params = new HashMap<>(16);
        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {

            String key = param.getKey();
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            String obj = StrUtil.endWithIgnoreCase(param.getKey(), "password") ? "密码隐藏" : paramValue;
            params.put(key,obj);
        }
        return new Gson().toJson(params);
    }

    public static String mapToStringAll(Map<String, String[]> paramMap){

        if (paramMap == null) {
            return "";
        }
        Map<String, Object> params = new HashMap<>(16);
        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {

            String key = param.getKey();
            String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
            params.put(key, paramValue);
        }
        return new Gson().toJson(params);
    }

    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }
}
