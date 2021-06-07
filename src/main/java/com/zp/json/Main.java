package com.zp.json;

import com.alibaba.fastjson.JSONObject;

public class Main {
    public static void main(String[] args) throws Exception {
        String json = "{\n" +
                "    \"a\": \"1\",\n" +
                "    \"b\": {\n" +
                "        \"c\": \"2\"\n" +
                "    },\n" +
                "    \"d\": [\n" +
                "        {\n" +
                "            \"name\": \"11\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"22\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(json);
//        System.out.println(JsonPaser.getNodeValue(json,"b.c"));
//        System.out.println(JsonPaser.getNodeValue(json,"a"));
//        System.out.println(JsonPaser.getNodeValue(json,"b"));
//        System.out.println(JsonUtil.getValue(jsonObject,"b.c",true));
        System.out.println(MyJsonParser.getValue(jsonObject,"b.c"));
        System.out.println(MyJsonParser.getValue(jsonObject,"c"));

    }
}
