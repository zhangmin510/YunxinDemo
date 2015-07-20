/**
 * 
 */
package com.netease.mini7;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.netease.mini7.model.StatusInfo;
import com.netease.mini7.service.YunxinApiHelper;
import com.netease.mini7.service.YunxinApiList;

/**
 * @author hzzhangmin2015
 *
 */
public class YunxinApiListTest {
	@Test
	public void testCreateUser() {
		StatusInfo si = YunxinApiList.createUser("chenzz", "陈中正");
		si = YunxinApiList.createUser("liangy", "梁尧");
		si = YunxinApiList.createUser("lir", "黎瑞");
		assertEquals("200", "414", si.getCode());
	}
	
	@Test
	public void testUpdateUser() {
		StatusInfo si = YunxinApiList.updateUser("chenzz", "陈中正");
		assertEquals("200", si.getCode());
	}
	
	@Test
	public void testSendMsg() {
		StatusInfo si = YunxinApiList.sendMsg("chenzz", "0", "liangy", "0", 
				"{"
				+ "\"msg\":\"哈哈\""
				+ "}");
		assertEquals("200", si.getCode());
	}
	
	@Test
	public void testSendAttachMsg() {
		StatusInfo si = YunxinApiList.sendAttachMsg("chenzz", "0", "liangy", 
				"{"
				+ "\"x\":120,"
				+ "\"y\":200"
				+ "}");
		assertEquals("200", si.getCode());
	}
}
