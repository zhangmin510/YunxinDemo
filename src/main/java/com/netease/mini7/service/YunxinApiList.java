package com.netease.mini7.service;

import java.util.HashMap;
import java.util.Map;

import com.netease.mini7.model.StatusInfo;

/**
 * 
 * @ClassName: YunxinApiList 
 * @Description: 云信API封装列表
 * @author chenzhongzheng && zhangmin
 *
 */
public class YunxinApiList {
		/**
		 * 
		 * @Title: createUser 
		 * @Description: 创建用户
		 * @param @param accid
		 * @param @param name
		 * @param @return
		 * @return StatusInfo
		 * @throws
		 */
		public static StatusInfo createUser(String accid, String name) {
			Map<String, String> account = new HashMap<String, String>();
			account.put("accid", accid);
			account.put("name", name);
			StatusInfo si = YunxinApiHelper.invokeApi(YunxinApiHelper.CREATE_USER, account);

			return si;
		}
		
		/**
		 * 
		 * @Title: updateUser 
		 * @Description: 更新用户资料
		 * @param @param accid
		 * @param @param name
		 * @param @return
		 * @return StatusInfo
		 * @throws
		 */
		public static StatusInfo updateUser(String accid, String name) {
			Map<String, String> account = new HashMap<String, String>();
			account.put("accid", accid);
			account.put("name", name);
			StatusInfo si = YunxinApiHelper.invokeApi(YunxinApiHelper.UPDATE_USER, account);
			
			return si;
		}
		
		/**
		 * 
		 * @Title: sendMsg 
		 * @Description: 发送消息
		 * @param @param from
		 * @param @param ope
		 * @param @param to
		 * @param @param type
		 * @param @param body
		 * @param @return
		 * @return StatusInfo
		 * @throws
		 */
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
		
		/**
		 * 
		 * @Title: sendAttachMsg 
		 * @Description: TODO 
		 * @param @param from
		 * @param @param msgtype
		 * @param @param to
		 * @param @param attach
		 * @param @return
		 * @return StatusInfo
		 * @throws
		 */
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
