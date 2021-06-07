package com.zp.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.Map;

public class MyJsonParser {

    /**
     * 通过key获取value，支持路径，比如a.b.c
     * @param jsonObject
     * @param key
     * @return
     */
    public static Object getValue(JSONObject jsonObject, String key) {
        if (key.contains(".")) {
            return JSONPath.eval(jsonObject, key);
        } else {
            return getValueBySingleKey(jsonObject, key);
        }
    }


    /**
     * 通过单个key获取value
     * @param jsonObject
     * @param key
     * @return
     */
    public static Object getValueBySingleKey(JSONObject jsonObject, String key) {
        Object o = jsonObject.get(key);
        if (o != null) {
            return o;
        }

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            String entryKey = entry.getKey();
            String value = entry.getValue().toString();

            if (value.contains("{")) {
                JSONObject jsonObject1 = jsonObject.getJSONObject(entryKey);
                return getValueBySingleKey(jsonObject1, key);
            } else {
                continue;
            }

        }

        return null;
    }
}
