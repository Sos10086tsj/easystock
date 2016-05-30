package com.chinesedreamer.easystock.stock.service;

import java.util.List;

import com.chinesedreamer.easystock.showapi.vo.ShowApiStockMasterIndexVo;

/**
 * Description:股指service
 * Auth:Paris
 * Date:May 23, 2016
**/
public interface StockMasterIndexService {
	/**
	 * 从showapi获取股指信息
	 * @param vos
	 */
	public void saveFromShowApi(List<ShowApiStockMasterIndexVo> vos);
}
