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
			<div class="box2" panelTitle="待发货订单" roller="true">
			
<s:form name="showTable" method="post" action="order-list-wait.action">
	<s:hidden id="page" name="view.currentPage" />
	
				<table class="tableStyle">
					<tr align="center">
						<th>订单号</th>
						<th>所属会员</th>
						<th>所属商品</th>
						<th>商品总价</th>
						<th>实付款</th>
						<th>支付方式</th>
						<th>联系人</th>	
						<th>联系电话</th>
						
						<th>提交日期</th>	
						
								
						<th>审核</th>
					</tr>
	<c:forEach items="${view.records}" var="o">
					<tr align="center">
						<td>${o.orderNo}</td>
						<td>${o.member.loginName}</td>		
						<td>${o.product.title}</td>		
						
						<td>${o.productPrice}</td>
						<td>${o.payPrice}</td>
						<td>
							<c:if test="${o.type==10}">奖金币支付</c:if>
							<c:if test="${o.type==20}">电子货币支付</c:if>
							
						</td>
						<td>${o.personName}</td>
						<td>${o.tel}</td>
						<td>${o.submitDate}</td>
						<td>
							<a href="order-list-wait-show!show.action?orderId=${o.id}">
								<span class="icon_edit">审核</span>
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