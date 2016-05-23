package com.chinesedreamer.easystock.showapi.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 * Auth:Paris
 * Date:May 18, 2016
**/
public class ShowApiStockMasterIndexVo {
	private String code;//sh000001
	
	private String name;//上证指数
	private Date time;//2016-05-18 13:00:00.271
	private BigDecimal nowPrice;//2828.178
	private BigDecimal minPrice;// 2789.4656
	private BigDecimal maxPrice;//2828.2552
	private BigDecimal todayOpenPrice;//2828.178
	private BigDecimal yestodayClosePrice;// 2843.6841
	private BigDecimal tradeNum;//73324819
	private BigDecimal tradeAmount;//78833181692
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public Date getTime() {
		return time;
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
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTime(Date time) {
		this.time = time;
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
	@Override
	public String toString() {
		return "ShowApiStockMasterIndexVo [code=" + code + ", name=" + name + ", time=" + time + ", nowPrice="
				+ nowPrice + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", todayOpenPrice=" + todayOpenPrice
				+ ", yestodayClosePrice=" + yestodayClosePrice + ", tradeNum=" + tradeNum + ", tradeAmount="
				+ tradeAmount + "]";
	}
	
	
}
