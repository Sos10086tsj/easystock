package com.chinesedreamer.easystock.stock.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chinesedreamer.easystock.common.util.DateUtils;
import com.chinesedreamer.easystock.domain.model.StockMasterIndex;
import com.chinesedreamer.easystock.showapi.vo.ShowApiStockMasterIndexVo;
import com.chinesedreamer.easystock.stock.logic.StockMasterIndexLogic;
import com.chinesedreamer.easystock.stock.service.StockMasterIndexService;

/**
 * Description:
 * Auth:Paris
 * Date:May 23, 2016
**/
@Service
public class StockMasterIndexServiceImpl implements StockMasterIndexService{
	private Logger logger = LoggerFactory.getLogger(StockMasterIndexServiceImpl.class);
	
	@Resource
	private StockMasterIndexLogic logic;

	@Override
	public void saveFromShowApi(List<ShowApiStockMasterIndexVo> vos) {
		for (ShowApiStockMasterIndexVo vo : vos) {
			String stockCode = vo.getCode();

			StockMasterIndex smi = this.logic.findByCodeAndEtlDate(stockCode, DateUtils.getEtlDate(vo.getTime()));
			if (null == smi) {
				smi = this.copy2Model(new StockMasterIndex(), vo);
				this.logic.save(smi);
			}else {
				smi = this.update2Model(smi, vo);
				this.logic.update(smi);
			}
		}
	}

	private StockMasterIndex copy2Model(StockMasterIndex smi, ShowApiStockMasterIndexVo vo) {
		if (null == smi) {
			smi = new StockMasterIndex();
		}
		try {
			BeanUtils.copyProperties(smi, vo);
		} catch (Exception e) {
			this.logger.error("{}",e);
		}
		int index = com.chinesedreamer.easystock.common.util.StringUtils.extractionFirstNumber(vo.getCode());
		if (index != -1) {
			smi.setCode(vo.getCode().substring(index));
			smi.setMarket(vo.getCode().substring(0, index - 1));
		}
		smi.setSyncTime(new Date());
		return smi;
	}
	
	private StockMasterIndex update2Model(StockMasterIndex smi, ShowApiStockMasterIndexVo vo) {
		smi.setNowPrice(vo.getNowPrice());
		smi.setMinPrice(vo.getMinPrice());
		smi.setMaxPrice(vo.getMaxPrice());
		smi.setTodayOpenPrice(vo.getTodayOpenPrice());
		smi.setYestodayClosePrice(vo.getYestodayClosePrice());
		smi.setTradeNum(vo.getTradeNum());
		smi.setTradeAmount(vo.getTradeAmount());
		smi.setSyncTime(new Date());
		return smi;
	}
}
