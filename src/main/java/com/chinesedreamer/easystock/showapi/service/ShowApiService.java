package com.chinesedreamer.easystock.showapi.service;

import java.util.Date;
import java.util.List;

import com.chinesedreamer.easystock.showapi.vo.ShowApiStockMasterIndexVo;

/**
 * Description: {@link https://www.showapi.com/} 易源API接口
 * Auth:Paris
 * Date:May 18, 2016
**/
public interface ShowApiService {
	
	/**
	 * 获取某个时间点的股票指数
	 * @param date
	 * @return 上证指数/深证成指/中小板指/创业板指
	 */
	public List<ShowApiStockMasterIndexVo> stockMasterIndex(Date date);
	
	
}
