/**
 * 
 */
package com.netease.mini7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * @author hzzhangmin2015
 *
 */
public class YunXinAPIHelper {
	public static final String APP_KEY = "65a84d826808943006997f3504e1ee0f";
	public static final String SECRET_KEY = "8caea6f2170b";
	private String nonce;
	private String curTime;
	private String checkSum;
	
	public YunXinAPIHelper() {
		
	}
	
	public String invoke(String api, Map<String, String> data) {
		this.curTime = Long.toString(System.currentTimeMillis() / 1000);
		this.nonce = UUID.randomUUID().toString();
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("AppKey", APP_KEY);
		headers.put("Nonce", this.nonce);
		headers.put("CurTime", this.curTime);
		headers.put("CheckSum", genCheckSum());
		
		String response = HttpRequest.post(api)
				.headers(headers)
				.contentType("application/x-www-form-urlencoded;charset=utf-8")
				.form(data)
				.body();
		
		return response;
	}
	
	private String genCheckSum() {
		StringBuilder sb = new StringBuilder();
		sb.append(SECRET_KEY).append(this.nonce).append(this.curTime);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(sb.toString().getBytes());
			this.checkSum = bytesToHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return checkSum;
	}
	
	private String bytesToHexString(byte[] src){   
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

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getCurTime() {
		return curTime;
	}

	public void setCurTime(String curTime) {
		this.curTime = curTime;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
