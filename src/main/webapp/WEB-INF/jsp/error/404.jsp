<%@ page contentType="text/html;charset=UTF-8" %>
<%
//获取异常类
Throwable ex = ExceptionUtils.getThrowable(request);
if (ex != null){
	LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
}
%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.chinesedreamer.easystock.common.util.ExceptionUtils"%>
<html>
<head>
	<title>系统错误</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
			<label>未知错误</label>
		</div>
</body>
</html>