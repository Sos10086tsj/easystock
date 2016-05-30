package com.chinesedreamer.easystock.stock.logic;

import java.util.Date;

import com.chinesedreamer.easystock.base.jpa.logic.BaseLogic;
import com.chinesedreamer.easystock.domain.model.StockMasterIndex;
import com.chinesedreamer.easystock.domain.query.StockMasterIndexQueryVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 23, 2016
**/
public interface StockMasterIndexLogic extends BaseLogic<StockMasterIndexQueryVo, StockMasterIndex, Long>{
	/**
	 * 获取某日指定股票市场股指
	 * @param code
	 * @param etlDate
	 * @return
	 */
	public StockMasterIndex findByCodeAndEtlDate(String code, Date etlDate);
}
