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
public class YunXinAPIHelperTest {
	YunxinApiHelper apiHelper;
	@Before
	public void setUp() {
		this.apiHelper = new YunxinApiHelper();
	}
	@Test
	public void testUpdateAPI() {
		Map<String, String> account = new HashMap<String, String>();
		account.put("accid", "zhangmin@zhangmin.name");
		account.put("name", "zhangmin.name");
		String res = this.apiHelper.invoke(YunxinApiList.UPDATE_USER, account);
		StatusInfo si = JSON.parseObject(res, StatusInfo.class);
		assertEquals("update account failed", "200", si.getCode());
	}
	

}
