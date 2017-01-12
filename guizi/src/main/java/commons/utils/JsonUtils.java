package commons.utils;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	
	public static void responseJson(HttpServletResponse res,String json) {
		responseJson(res, json, "utf-8");
	}
	
	public static void responseJson(HttpServletResponse res,String json,String charset) {
		try(OutputStream os = res.getOutputStream()) {
			os.write(json.getBytes(charset));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String toString(Object o) {
		return JSON.toJSONString(o);
	}
}
