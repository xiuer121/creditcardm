<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!--框架必需start-->
		<script type="text/javascript" src="../../js/jquery-1.4.js"></script>
		<script type="text/javascript" src="../../js/framework.js"></script>
		<link href="../../css/import_basic.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" id="skin" prePath="../../"/>
		<!--框架必需end-->
		
		<script type=text/javascript>
			function topage(page){
				var form = document.forms["showTable"];
				document.getElementById("page").value=page;
				form.submit();
			}
		</script>
	
	</head>
	<body>
		<div id="scrollContent">
			<div class="box2" panelTitle="修改推荐日志" roller="true">
			
<s:form id="queryForm" name="queryForm" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><s:textfield name="loginName"/></td>
					<td><s:submit value="查询"/></td>
				</tr>
			</table>
</s:form>
			
<s:form name="showTable" method="post">
	<s:hidden id="page" name="view.currentPage" />
	<s:hidden id="loginName" name="loginName"/>
	
				<table class="tableStyle">
					<tr>
						<th>编号</th>
						<th>修改会员</th>
						<th>原推荐人</th>
						<th>新推荐人</th>
						<th>操作人</th>
						<th>IP</th>
						<th>时间</th>   
					</tr>
	<c:forEach items="${view.records}" var="o">
					<tr>    
						<td>${o.id}</td>
						<td>${o.member.loginName}</td>
						<td>${o.oldRecommend.loginName}</td>
						<td>${o.newRecommend.loginName}</td>
						<td>${o.oper.loginName}</td>
						<td>${o.operIp}</td>
						<td>${o.operDate}</td>
					</tr>
	</c:forEach>
				</table>
				
				<%@ include file="../fenye.jsp"%>
				
</s:form>
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>