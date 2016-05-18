package com.chinesedreamer.easystock.showapi.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.chinesedreamer.easystock.base.BaseTest;
import com.chinesedreamer.easystock.showapi.service.ShowApiService;

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
		this.showApiService.stockMasterIndex(new Date());
	}

}
