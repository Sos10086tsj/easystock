package com.chinesedreamer.easystock.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.chinesedreamer.easystock.base.jpa.model.BaseVersionEntity;

/**
 * Description:股票
 * Auth:Paris
 * Date:May 18, 2016
**/
public class Stock extends BaseVersionEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539381297750017238L;
	
	@Column
	private String code;//600004
	@Column
	@DateTimeFormat(pattern="yyyyMMdd")
	private Date date;//etl时间 20160518
	
	@Column
	private String name;//白云机场
	@Column
	private String market;//sh
	
	@Column(name = "close_price")
	private BigDecimal closePrice;//12.480	 收盘价
	@Column(name = "open_price")
	private BigDecimal openPrice;//11.700 	开盘价
	@Column(name = "min_price")
	private BigDecimal minPrice;//11.700 	最低成交价
	@Column(name = "max_price")
	private BigDecimal maxPrice;//12.700 	最高成交价
	@Column(name = "trade_num")
	private BigDecimal tradeNum;//17541504	成交量
	@Column(name = "trade_money")
	private BigDecimal tradeMoney;//215834624 	成交金额

	@Column(name = "sync_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date syncTime;//2016-05-18 13:00:00.271


	public String getCode() {
		return code;
	}


	public Date getDate() {
		return date;
	}


	public String getName() {
		return name;
	}


	public String getMarket() {
		return market;
	}


	public BigDecimal getClosePrice() {
		return closePrice;
	}


	public BigDecimal getOpenPrice() {
		return openPrice;
	}


	public BigDecimal getMinPrice() {
		return minPrice;
	}


	public BigDecimal getMaxPrice() {
		return maxPrice;
	}


	public BigDecimal getTradeNum() {
		return tradeNum;
	}


	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}


	public Date getSyncTime() {
		return syncTime;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setMarket(String market) {
		this.market = market;
	}


	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}


	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}


	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}


	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}


	public void setTradeNum(BigDecimal tradeNum) {
		this.tradeNum = tradeNum;
	}


	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}


	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}


	@Override
	public String toString() {
		return "Stock [code=" + code + ", date=" + date + ", name=" + name + ", market=" + market + ", closePrice="
				+ closePrice + ", openPrice=" + openPrice + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", tradeNum=" + tradeNum + ", tradeMoney=" + tradeMoney + ", syncTime=" + syncTime + ", version="
				+ version + ", id=" + id + "]";
	}

	
}
