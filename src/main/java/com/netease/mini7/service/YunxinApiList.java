/**
 * 
 */
package com.netease.mini7.service;

import java.util.HashMap;
import java.util.Map;

import com.netease.mini7.model.StatusInfo;

/**
 * @author hzzhangmin2015
 *
 */
public class YunxinApiList {
		//创建账号
		public static StatusInfo createUser(String accid, String name) {
			Map<String, String> account = new HashMap<String, String>();
			account.put("accid", accid);
			account.put("name", name);
			StatusInfo si = YunxinApiHelper.invokeApi(YunxinApiHelper.CREATE_USER, account);

			return si;
		}
		
		//账号更新
		public static StatusInfo updateUser(String accid, String name) {
			Map<String, String> account = new HashMap<String, String>();
			account.put("accid", accid);
			account.put("name", name);
			StatusInfo si = YunxinApiHelper.invokeApi(YunxinApiHelper.UPDATE_USER, account);
			
			return si;
		}
		
		//发送普通消息
		public static StatusInfo sendMsg(String from, String ope, String to, String type, String body) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("from", from);
			map.put("ope", ope);
			map.put("to", to);
			map.put("type", type);
			map.put("body", body);
			StatusInfo si = YunxinApiHelper.invokeApi(YunxinApiHelper.SEND_MSG, map);
			
			return si;
		}
		
		//发送透传消息
		public static StatusInfo sendAttachMsg(String from, String msgtype, String to, String attach)  {
			Map<String, String> map = new HashMap<String, String>();
			map.put("from", from);
			map.put("msgtype", msgtype);
			map.put("to", to);
			map.put("attach", attach);
			StatusInfo si = YunxinApiHelper.invokeApi(YunxinApiHelper.SEND_ATTACH_MSG, map);
			
			return si;
		}
	
}
