/**
 * 
 */
package com.netease.mini7.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.github.kevinsawicki.http.HttpRequest;
import com.netease.mini7.model.StatusInfo;

/**
 * 
 * @ClassName: YunxinApiHelper 
 * @Description: 云信API封装类
 * @author chenzhongzheng && zhangmin
 *
 */
public class YunxinApiHelper {
	
	//用户服务
	public static final String CREATE_USER = 
			"https://api.netease.im/nimserver/user/create.action";			//创建账号
	public static final String UPDATE_USER = 
			"https://api.netease.im/nimserver/user/update.action";			//账号更新
	public static final String CHECK_ONLINE = 
			"https://api.netease.im/nimserver/user/checkOnline.action";		//检测用户在线状态
	public static final String REFRESH_TOKEN = 
			"https://api.netease.im/nimserver/user/refreshToken.action";	//更新并获取新token
	public static final String BLOCK_USER = 
			"https://api.netease.im/nimserver/user/block.action";			//封禁用户
	public static final String UNBLOCK_USER = 
			"https://api.netease.im/nimserver/user/unblock.action";			//解禁用户
	
	//消息服务
	public static final String SEND_MSG =
			"http://api.netease.im/nimserver/msg/sendMsg.action";			//发送普通消息
	public static final String SEND_ATTACH_MSG = 
			"https://api.netease.im/nimserver/msg/sendAttachMsg.action";	//发送透传消息
	public static final String UPLOAD =
			"https://api.netease.im/nimserver/msg/upload.action";			//文件上传
	public static final String FILE_UPLOAD =
			"https://api.netease.im/nimserver/msg/upload.action";			//文件上传（multipart方式）
	
	
	//高级群相关操作
	public static final String CREATE_GROUP =
			"https://api.netease.im/nimserver/team/create.action";			//创建高级群
	public static final String ADD_MEMBER =
			"https://api.netease.im/nimserver/team/add.action";				//高级群邀请人
	public static final String KICK_MEMBER =
			"https://api.netease.im/nimserver/team/kick.action";			//高级群踢人
	public static final String REMOVE_GROUP =
			"https://api.netease.im/nimserver/team/remove.action";			//删除高级群
	public static final String UPDATE_GROUP =
			"https://api.netease.im/nimserver/team/update.action";			//高级群信息修改
	public static final String QUERY_GROUP =
			"https://api.netease.im/nimserver/team/query.action";			//高级群信息与成员列表查询
	public static final String CHANGE_GROUP_OWNER =
			"https://api.netease.im/nimserver/team/changeOwner.action";		//更换群主
	public static final String ADD_MANAGER =
			"https://api.netease.im/nimserver/team/addManager.action";		//添加群管理员
	public static final String REMOVE_MANAGER =
			"https://api.netease.im/nimserver/team/removeManager.action";	//解除群管理员
	public static final String QUERY_JOIN_GROUPS =
			"https://api.netease.im/nimserver/team/joinTeams.action";		//查询某用户加入的群的信息
	public static final String UPDATE_GROUP_NICK =
			"https://api.netease.im/nimserver/team/updateTeamNick.action";	//修改群昵称
	
	//应用标志和密钥
	public static final String APP_KEY = "8dc63ac2919789147c10f12fe58c54c7";
	public static final String SECRET_KEY = "f87df3e5719e";
	
	//调用易信提供API
	public static StatusInfo invokeApi(String api, Map<String, String> data) {
		Map<String, String> headers = genHeaders();
		
		String response = HttpRequest.post(api)
				.headers(headers)
				.contentType("application/x-www-form-urlencoded;charset=utf-8")
				.form(data)
				.body();
		
		StatusInfo si = JSON.parseObject(response, StatusInfo.class);
		
		return si;
	}

	//生成http请求的请求头
	private static Map<String, String> genHeaders() {
		String curTime = Long.toString(System.currentTimeMillis() / 1000);
		String nonce = UUID.randomUUID().toString();
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("AppKey", APP_KEY);
		headers.put("Nonce", nonce);
		headers.put("CurTime", curTime);
		headers.put("CheckSum", genCheckSum(nonce, curTime));
		return headers;
	}
	
	//生成签名
	private static String genCheckSum(String nonce, String curTime) {
		String checkSum;
		StringBuilder sb = new StringBuilder();
		sb.append(SECRET_KEY).append(nonce).append(curTime);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(sb.toString().getBytes());
			checkSum = bytesToHex(md.digest());
			return checkSum;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	//bytes转换为十六进制字符串
	private static String bytesToHexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }
	    return stringBuilder.toString();   
	}
	
	//bytes转换为十六进制字符串
	final private static char[] hexArray = "0123456789abcdef".toCharArray();
	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
}
