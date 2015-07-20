/**
 * 
 */
package com.netease.mini7.model;

/**
 * @author hzzhangmin2015
 *
 */
public class StatusInfo {
	private String code;
	private String desc;
	private Info info;
	private String status;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "StatusInfo [code=" + code + ", desc=" + desc + ", info=" + info
				+ ", status=" + status + "]";
	}
	
	
	
}
