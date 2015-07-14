/**
 * 
 */
package com.netease;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author hzzhangmin2015
 *
 */
public class RequestHeader {
	public static final String APP_KEY = "65a84d826808943006997f3504e1ee0f";
	public static final String SECRET_KEY = "8caea6f2170b";
	private String nonce;
	private String curTime;
	private String checkSum;
	
	public RequestHeader() {
		this.curTime = Long.toString(System.currentTimeMillis() / 1000);
		this.nonce = UUID.randomUUID().toString();
	}
	
	public String genCheckSum() {
		StringBuilder sb = new StringBuilder();
		sb.append(SECRET_KEY).append(this.nonce).append(this.curTime);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.digest(sb.toString().getBytes());
			this.checkSum = bytesToHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return checkSum;
	}
	public static String bytesToHexString(byte[] src){   
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
		RequestHeader rh = new RequestHeader();
		rh.setNonce("ffa9016bcd2d4b3a8358c8ad60d55ea5");
		rh.setCurTime("1436865094");
		System.out.println(rh.getNonce());
		System.out.println(rh.getCurTime());
		//expect : 6a7b6c528c8c1641387940c377372bd727543831
		System.out.println("checksum:" + rh.genCheckSum());

	}

}
