package com.chinesedreamer.easystock.showapi.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
		}
		return null;
	}

}
