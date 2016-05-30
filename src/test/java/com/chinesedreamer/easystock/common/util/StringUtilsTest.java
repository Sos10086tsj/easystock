package com.chinesedreamer.easystock.common.util;

import org.junit.Test;

/**
 * Description:
 * Auth:Paris
 * Date:May 30, 2016
**/
public class StringUtilsTest {

	@Test
	public void testExtractionNumber() {
		String a = "abad1231321321";
		int index = StringUtils.extractionFirstNumber(a);
		System.out.println("index:" + index); 
	}

}
