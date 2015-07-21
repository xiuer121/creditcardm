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
			<div class="box2" panelTitle="俱乐部公告" roller="true">
			
<s:form name="showTable" method="post">
	<s:hidden id="page" name="view.currentPage" />
	
				<table class="tableStyle">
					<tr>
						<th>编号</th>
						<th style="width:40%">姓名</th>
						<th>卡号</th>
						<th>身份证号</th> 
						<th>手机</th>
						<th>还款金额</th>
						<th>所属银行</th> 
						<th>还款状态</th>
						<th>是否手续费</th>
						<th>联系人</th>
					</tr>
	<c:forEach items="${viwJiao.records}" var="o">
					<tr>
						<td>${o.id}</td>
						<td>${o.title}</td>
						<td> 
						<c:if test="${o.carType==10}">轿车</c:if>
						<c:if test="${o.carType==20}">跑车</c:if>
						<c:if test="${o.carType==30}">SUV</c:if>
						<c:if test="${o.carType==40}">商务车</c:if>
						</td>
						<td>${o.brandId.title}</td>
						<td>${o.originalPrice}</td>
						<td>${o.price}</td>
						<td> 
						<c:if test="${o.sellState==10}">否</c:if>
						<c:if test="${o.sellState==20}">停售</c:if>
						<c:if test="${o.sellState==100}">是</c:if>
						</td>
						<td>${o.commitAdmin.personName}</td>
						<td>${o.commitDate}</td> 
						<td> 
							<a href="car-update!show.action?id=${o.id}"> 
								<span class="icon_edit">编辑</span>
							 </a>
							<a href="car-update!xia.action?id=${o.id}"> 
								<span class="icon_delete">停售</span>
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