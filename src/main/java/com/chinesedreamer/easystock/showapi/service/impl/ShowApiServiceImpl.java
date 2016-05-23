package com.chinesedreamer.easystock.showapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinesedreamer.easystock.common.util.DateUtils;
import com.chinesedreamer.easystock.common.util.EncryptionUtils;
import com.chinesedreamer.easystock.common.util.HttpClientUtils;
import com.chinesedreamer.easystock.common.util.PropertiesUtils;
import com.chinesedreamer.easystock.showapi.constant.ShowApiConstant;
import com.chinesedreamer.easystock.showapi.service.ShowApiService;
import com.chinesedreamer.easystock.showapi.vo.ShowApiStockMasterIndexVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 18, 2016
**/
@Service
public class ShowApiServiceImpl implements ShowApiService{
	private Logger logger = LoggerFactory.getLogger(ShowApiServiceImpl.class);

	@Override
	public List<ShowApiStockMasterIndexVo> stockMasterIndex(Date date) {
		List<ShowApiStockMasterIndexVo> vos = new ArrayList<ShowApiStockMasterIndexVo>();
		//1. 获取地址
		PropertiesUtils pu = new PropertiesUtils(ShowApiConstant.SHOWAPI_CONFIG_FILE);
		String url = pu.getProperty(ShowApiConstant.SHOWAPI_STOCK_INDEX_URL);
		String appId = pu.getProperty(ShowApiConstant.SHOWAPI_APP_ID);
		String token = pu.getProperty(ShowApiConstant.SHOWAPI_TOKEN);
		
		String time = DateUtils.getFormatTime("yyyyMMddHHmmss", date);
		
		StringBuffer signPlainTextBuffer = new StringBuffer();
		signPlainTextBuffer.append("showapi_appid")
		.append(appId)
		.append("showapi_timestamp")
		.append(time)
		.append(token);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("showapi_appid", appId);
		params.put("showapi_timestamp", time);
		params.put("showapi_sign", EncryptionUtils.md5L32(signPlainTextBuffer.toString()));
		
		String response = HttpClientUtils.post(url, 6000, params);
		if (StringUtils.isEmpty(response)) {
			this.logger.info("Could not get response from SHOWAPI for stock master index.");
			return vos;
		}
		
		JSONObject jsonObject = JSONObject.parseObject(response);
		if (jsonObject.getInteger(ShowApiConstant.SHOWAPI_RESPONSE_CODE_PARAM) != ShowApiConstant.SHOWAPI_RESPONSE_SUCCESS_CODE) {
			this.logger.info("Stock master index response error:{}.", jsonObject.getString(ShowApiConstant.SHOWAPI_RESPONSE_ERROR_MSG_PARAM));
			return vos;
		}
		
		JSONArray indexList = jsonObject.getJSONObject(ShowApiConstant.SHOWAPI_RESPONSE_BODY_PARAM).getJSONArray(ShowApiConstant.SHOWAPI_RESPONSE_BODY_DATALIST_PARAM);
		for (Object object : indexList) {
			JSONObject index = (JSONObject)object;
			ShowApiStockMasterIndexVo vo = new ShowApiStockMasterIndexVo();
			vo.setCode(index.getString("code"));//sh0001
			vo.setMaxPrice(index.getBigDecimal("maxPrice"));//2825.9517
			vo.setMinPrice(index.getBigDecimal("minPrice"));//2785.0795
			vo.setName(index.getString("name"));//上证指数
			vo.setNowPrice(index.getBigDecimal("nowPrice"));//2825.4831
			vo.setTime(index.getDate("time"));//2016-05-23 09:00:00.136
			vo.setTodayOpenPrice(index.getBigDecimal("todayOpenPrice"));//2792.8883
			vo.setTradeAmount(index.getBigDecimal("tradeAmount"));//123794592281
			vo.setTradeNum(index.getBigDecimal("tradeNum"));//tradeNum
			vo.setYestodayClosePrice(index.getBigDecimal("yestodayClosePrice"));//2806.9061
			vos.add(vo);
		}
		return vos;
	}

}
