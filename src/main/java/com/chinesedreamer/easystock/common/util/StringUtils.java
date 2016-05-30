package com.chinesedreamer.easystock.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * Auth:Paris
 * Date:May 30, 2016
**/
public class StringUtils {
	/**
	 * 提取数字
	 * @param str
	 * @return
	 */
	public static int extractionFirstNumber(String str) {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			return matcher.start();
		}
		return -1;
	}
	
}
