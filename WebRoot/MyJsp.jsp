<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="./js/jquery-1.4.js"></script>
		<script type="text/javascript">
	$(function() {
 
		$("#okBtn").bind('click', function() {
 			$.ajax({
				type : "post",
				data: $("#kkkk").serialize(), 
				url : "repayment-brush.action",
				success : function(data) {

				}
			});
		});
	});
</script>
	</head>

	<body>
		<form action="#" id="kkkk">
			<input name="userName" type="text" />
			<input type="button" value="tijiao" id="okBtn">
		</form>
	</body>
</html>
