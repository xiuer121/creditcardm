<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>注销Session</title>
		<meta http-equiv=Content-Type content="text/html; charset=utf-8" />
	</head>

	<body>

		<% 
			//注销Session
			session.setAttribute("loginInfo",null);		//清空Session的登錄信息
		//	session.invalidate();							//销毁Session，重新获得一个
			
			//跳转到登錄页面
			response.sendRedirect("../login-admin.jsp");
		%>

	</body>
</html>
