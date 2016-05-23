package com.chinesedreamer.easystock.showapi.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.chinesedreamer.easystock.base.BaseTest;
import com.chinesedreamer.easystock.showapi.service.ShowApiService;
import com.chinesedreamer.easystock.showapi.vo.ShowApiStockMasterIndexVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 18, 2016
**/
public class ShowApiServiceImplTest extends BaseTest{
	
	@Resource
	private ShowApiService showApiService;

	@Test
	public void testStockMasterIndex() {
		List<ShowApiStockMasterIndexVo> vos = this.showApiService.stockMasterIndex(new Date());
		Assert.assertNotNull(vos);
		for (ShowApiStockMasterIndexVo vo : vos) {
			System.out.println(vo);
		}
	}

}
