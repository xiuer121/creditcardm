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
			<div class="box2" panelTitle="商务中心申请" roller="true">
			
<s:form name="showTable" method="post">
	<s:hidden id="page" name="view.currentPage" />
	
				<table class="tableStyle">
					<tr>
						<th>编号</th>
						<th>所属会员</th>
						<th>会员级别</th>

						<th>中心名称</th>
						<th>中心地址</th>
								
						<th>状态</th>
								
						<th>申请时间</th>
						<th>处理时间</th>

						<th>确认</th>
						<th>拒绝</th>
					</tr>
	<c:forEach items="${view.records}" var="o">
					<tr>
						<td>${o.id}</td>
						<td>${o.member.loginName}</td>
						<td>
							<c:if test="${!o.member.accountCenter}">会员</c:if>
							<c:if test="${o.member.accountCenter}">商务中心</c:if>
						</td>
											
						<td>${o.title}</td>
						<td>${o.address}</td>

						<td>
							<c:if test="${o.state==10}">未处理</c:if>
							<c:if test="${o.state==20}">已确认</c:if>
							<c:if test="${o.state==30}">已拒绝</c:if>
						</td>

						<td>${o.requestDate}</td>
						<td>${o.commitDate}</td>

						<td>
							<a href="request-center-commit!show.action?id=${o.id}">
								确认
							</a>
						</td>
									
						<td>
							<a href="request-center-list!no.action?id=${o.id}">
								拒绝
							</a>
						</td>
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