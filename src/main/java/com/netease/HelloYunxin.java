/**
 * 
 */
package com.netease;

import java.util.HashMap;
import java.util.Map;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * @author hzzhangmin2015
 *
 */
public class HelloYunxin {
	public static final String URL = 
			"https://api.netease.im/nimserver/user/create.action";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestHeader rh = new RequestHeader();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("AppKey", RequestHeader.APP_KEY);
		headers.put("Nonce", rh.getNonce());
		headers.put("CurTime", rh.getCurTime());
		headers.put("CheckSum", rh.genCheckSum());
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("accid", "temp@zhangmin.name");
		data.put("name", "zhangmin.name");
		String response = HttpRequest.post(URL)
				.headers(headers)
				.contentType("application/x-www-form-urlencoded;charset=utf-8")
				.form(data)
				.body();
		System.out.println(response);

	}

}
