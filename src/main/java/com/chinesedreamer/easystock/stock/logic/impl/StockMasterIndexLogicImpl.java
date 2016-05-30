package com.chinesedreamer.easystock.stock.logic.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinesedreamer.easystock.base.jpa.logic.BaseLogicImpl;
import com.chinesedreamer.easystock.domain.model.StockMasterIndex;
import com.chinesedreamer.easystock.domain.query.StockMasterIndexQueryVo;
import com.chinesedreamer.easystock.domain.repository.StockMasterIndexRepository;
import com.chinesedreamer.easystock.stock.logic.StockMasterIndexLogic;

/**
 * Description:
 * Auth:Paris
 * Date:May 30, 2016
**/
@Service
public class StockMasterIndexLogicImpl extends BaseLogicImpl<StockMasterIndexQueryVo, StockMasterIndex, Long> implements StockMasterIndexLogic{
	@Resource
	private StockMasterIndexRepository repository;
	@Override
	public StockMasterIndex findByCodeAndEtlDate(String code, Date etlDate) {
		return this.repository.findByCodeAndEtlDate(code, etlDate);
	}

}
