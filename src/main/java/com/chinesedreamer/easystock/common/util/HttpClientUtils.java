package com.chinesedreamer.easystock.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Auth:Paris
 * Date:May 18, 2016
**/
@SuppressWarnings("deprecation")
public class HttpClientUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	/**
	 * post请求，返回response
	 * @param url
	 * @param params
	 * @return
	 */
	public static String post(String url, int timeout,Map<String, Object> params) {
		logger.info("Post to {}", url);
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,timeout);//连接时间
		httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,timeout);//数据传输时间

		HttpPost post = createPost(url, params);
		try {
			HttpResponse response = httpclient.execute(post);
			String body = parseResponse(response);
			return body;
		} catch (ClientProtocolException e) {
			logger.error("{}", e);
			return null;
		} catch (IOException e) {
			logger.error("{}", e);
			return null;
		}finally {
			httpclient.close();
		}
	}
	
	private static HttpPost createPost(String url, Map<String, Object> params) {
		HttpPost post = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (null != params) {
			for (String key : params.keySet()) {
				nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
			}
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			logger.error("{}", e);
		}
		
		return post;
	}
	
	private static String parseResponse(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		String body = null;  
        try {  
            body = EntityUtils.toString(entity);  
        } catch (ParseException e) {  
        	logger.error("{}", e);
        } catch (IOException e) {  
        	logger.error("{}", e);
        }  
        return body;
	}
}
