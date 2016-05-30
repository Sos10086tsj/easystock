package com.chinesedreamer.easystock.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinesedreamer.easystock.base.jpa.model.BaseVersionEntity;

/**
 * Description: 股票指数
 * Auth:Paris
 * Date:May 18, 2016
**/
public class StockMasterIndex extends BaseVersionEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2410275421687875936L;
	
	@Column
	private String market;//sh
	@Column
	private String code;//000001
	@Column(name = "etl_date")
	@DateTimeFormat(pattern="yyyyMMdd")
	private Date etlDate;//etl时间 20160518
	
	@Column
	private String name;//上证指数
	@Column(name = "now_price")
	private BigDecimal nowPrice;//2828.178
	@Column(name = "min_price")
	private BigDecimal minPrice;// 2789.4656
	@Column(name = "max_price")
	private BigDecimal maxPrice;//2828.2552
	@Column(name = "today_open_price")
	private BigDecimal todayOpenPrice;//2828.178
	@Column(name = "yestoday_close_price")
	private BigDecimal yestodayClosePrice;// 2843.6841
	@Column(name = "trade_num")
	private BigDecimal tradeNum;//73324819
	@Column(name = "trade_amount")
	private BigDecimal tradeAmount;//78833181692
	
	@Column(name = "sync_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date syncTime;//2016-05-18 13:00:00.271

	public String getMarket() {
		return market;
	}

	public String getCode() {
		return code;
	}

	public Date getEtlDate() {
		return etlDate;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getNowPrice() {
		return nowPrice;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public BigDecimal getTodayOpenPrice() {
		return todayOpenPrice;
	}

	public BigDecimal getYestodayClosePrice() {
		return yestodayClosePrice;
	}

	public BigDecimal getTradeNum() {
		return tradeNum;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setEtlDate(Date etlDate) {
		this.etlDate = etlDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNowPrice(BigDecimal nowPrice) {
		this.nowPrice = nowPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public void setTodayOpenPrice(BigDecimal todayOpenPrice) {
		this.todayOpenPrice = todayOpenPrice;
	}

	public void setYestodayClosePrice(BigDecimal yestodayClosePrice) {
		this.yestodayClosePrice = yestodayClosePrice;
	}

	public void setTradeNum(BigDecimal tradeNum) {
		this.tradeNum = tradeNum;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	
	
}
