package com.chinesedreamer.easystock.domain.repository;

import java.util.Date;

import com.chinesedreamer.easystock.base.jpa.repository.BaseRepository;
import com.chinesedreamer.easystock.domain.model.StockMasterIndex;

/**
 * Description:
 * Auth:Paris
 * Date:May 18, 2016
**/
public interface StockMasterIndexRepository extends BaseRepository<StockMasterIndex, Long>{
	public StockMasterIndex findByCodeAndEtlDate(String code, Date etlDate);
}
