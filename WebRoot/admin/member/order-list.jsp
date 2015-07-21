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
		<!--打印-->
		<SCRIPT Language="Javascript">
		function printit(){
		    if (window.print) {
		        window.print();
		    }
		    else {
		        var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
		        document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
		        WebBrowser1.ExecWB(6, 2);
		    }
		}
		
		
		</script>
		
		
		
	
	</head>
	<body>
		<div id="scrollContent">
			<div class="box2" panelTitle="已发货订单" roller="true">
			<s:form id="queryForm" name="queryForm" method="post">
				<table >
					<tr>
						<td>会员编号:</td>
						<td>
							<s:textfield name="memberId"/>
						</td>
						
						<td>开始时间:</td>
						<td>
							<s:textfield name="startDate" />
						</td>
						
						<td>结束时间：</td>
						<td>
							<s:textfield  name="endDate" />
						</td>
						 
						<td>
							<button onclick="document.queryForm.submit();">
								<span class="icon_find">查询</span>
							</button>
							
						</td>
					</tr>
				</table>
			</s:form>
<s:form name="showTable" method="post" action="order-list.action">
	<s:hidden id="page" name="view.currentPage" />
	<s:hidden id="startDate" name="startDate" />
	<s:hidden id="endDate" name="endDate" />
	<s:hidden id="memberId" name="memberId" />
				<table table1 class="tableStyle">
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
						
						<th>操作</th>
					</tr>
	<c:forEach items="${view.records}" var="o">
					<tr align="center">
						<td>${o.orderNo}</td>
						<td>${o.member.loginName}</td>		
						<td>${o.product.title}</td>
						<td>${o.productPrice}</td>
						<td>${o.payPrice}</td>
						<td>
							<c:if test="${o.type==10}">银行汇款</c:if>
							<c:if test="${o.type==20}">奖金支付</c:if>
							<c:if test="${o.type==30}">积分兑换</c:if>
						</td>
		
						<td>${o.personName}</td>
						<td>${o.tel}</td>
									
						<td>${o.submitDate}</td>
						<td>
							<a href="order-list-show!show.action?orderId=${o.id}">
								<span class="icon_edit">详情</span>
							</a>
							<a href="order-list!cancel.action?orderId=${o.id}" onclick="return confirm('确认取消订单${o.orderNo}?')">
								<span class="icon_edit">取消</span>
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