package com.zp.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonPaser {

	/**
	 * 对节点进行解析
	 *
	 * @param obj
	 * @param node
	 * @return
	 * @author mengfeiyang
	 */
	private static Object getObj(JSONObject obj, String node) {
		try {
			String json = obj.getString(node);
			if (json.contains("{")) {
				return obj.getJSONObject(node);
			} else {
				return obj.getString(node);
			}
		} catch (Exception e) {
			return obj;
		}
//		return null;
	}

	/**
	 * 获取节点值
	 *
	 * @param jsonContent
	 * @param jsonPath
	 * @return
	 * @throws Exception
	 * @author mengfeiyang
	 */
	public static synchronized String getNodeValue(String jsonContent, String jsonPath) throws Exception {
		String[] nodes = jsonPath.split("\\.");
		JSONObject obj = JSON.parseObject(jsonContent);

		for (int i = 0; i < nodes.length; i++) {
			if (obj != null) {
				Object obj1 = getObj(obj, nodes[i]);

			}

			if ((i + 1) == nodes.length) {
				try {
					return obj.getString(nodes[i]);
				} catch (Exception e) {
					return "JSONException:" + e.getMessage() + ",NodeString:" + obj.toString();
				}
			}
		}
		return null;
	}
}