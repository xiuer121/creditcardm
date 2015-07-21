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
		<script type="text/javascript">
			
			$(document).ready(function(){
				$("#noPass").click(function(){
					self.location='order-proc!noPass.action?orderId=${order.id}&remark='+$("#remark").val();
				});
			});
		</script>
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box2" panelTitle="订单处理" roller="true">
	
<s:form id="commitForm" action="order-list-wait-show!proc.action" method="post">
	<s:hidden name="orderId" />
				
					<fieldset> 
					
						<legend>订单基本信息</legend> 
						
						<table class="tableStyle" transMode="true" footer="normal">
							<tr>
								<td width="10%">订单编号：</td>
								<td width="40%">${order.orderNo}</td>
								
								<td width="10%">所属会员：</td>
								<td>${order.member.loginName}(${order.member.personName})</td>
							</tr>
							<tr>
								<td>商品名称：</td>
								<td>${order.product.title}</td>
							
								<td>商品编号：</td>
								<td>${order.product.productNo}</td>
							</tr>
							<tr>
								<td>商品总价：</td>
								<td>${order.productPrice}</td>
								
							
								<td>实付款：</td>
								<td>${order.payPrice}</td>
								
								
							</tr>
							<tr>
								<td>支付方式：</td>
								<td>
									<c:if test="${order.type==10}">银行汇款</c:if>
									<c:if test="${order.type==20}">奖金支付</c:if>
									<c:if test="${order.type==30}">积分兑换</c:if>
								</td>
								
							</tr>
							
							
						</table>
					</fieldset>
					
					<fieldset> 
					
						<legend>订单地址信息</legend> 
						
						<table class="tableStyle" transMode="true" footer="normal">
							<tr>
								<td width="10%">联系人：</td>
								<td width="40%">${order.personName}</td>
								
								<td width="10%">收货地址：</td>
								<td width="40%">${order.address}</td>
							</tr>
							<tr>
								<td width="10%">联系电话：</td>
								<td width="40%">${order.tel}</td>
								
								<td width="10%">邮政编码：</td>
								<td width="40%">${order.code}</td>
							</tr>
						</table>
					</fieldset>
					
					<fieldset> 
					
						<legend>订单状态信息</legend> 
						
						<table class="tableStyle" transMode="true" footer="normal">
							<tr>
								<td width="10%">订单状态：</td>
								<td width="40%">
									<s:select id="orderState" name="orderState" 
								 		list="orderState.getMap()" listKey="key" listValue="value"/>
								</td>
								
								<td width="10%">提交日期：</td>
								<td width="40%">${order.submitDate}</td>
							</tr>
							<tr>
								<td>备注：</td>
								<td colspan="3">
									<s:textarea name="remark" id="remark"/>
								</td>
							</tr>
						</table>
					</fieldset>
					
					
					
					
					<div class="padding_top10">
						<table class="tableStyle" transMode="true">
							<tr>
								<td>
									<div style="color: red;text-align:center;">
										<s:actionerror/>
										<s:fielderror/>
									</div>
								</td>
							</tr>
						</table>
						<table class="tableStyle" transMode="true">
							<tr>
								<td>
									<input type="submit" value=" 确认  "/>
									<input type="reset"  value=" 重置 "/>
								</td>
							</tr>
						</table>
					</div> 
					
				</s:form>
				
				
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>