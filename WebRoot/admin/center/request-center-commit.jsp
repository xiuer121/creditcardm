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
		
		<!-- 遮罩效果 -->
		<script type="text/javascript" src="../../js/form/loadmask.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$(":submit").bind("click", function () {
	 				$("#commitForm").mask("数据提交中，请等待！");
				});
			});
			
		</script>
		<!-- 遮罩效果结束 -->
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box2" panelTitle="申请确认" roller="true">
	
<s:form id="commitForm" action="request-center-commit!commit" method="post">
	<s:hidden name="id"/>

					<table class="tableStyle" formMode="true">
					
						<tr>
							<th colspan="2">申请确认</th>
						</tr>
					
						<tr>
							<td>编号：</td>
							<td>${one.id}</td>
						</tr>
						<tr>
							<td>所属会员：</td>
							<td>${one.member.loginName}</td>
						</tr>
						<tr>
							<td>会员级别：</td>
							<td>
								<c:if test="${!one.member.accountCenter}">会员</c:if>
								<c:if test="${one.member.accountCenter}">商务中心</c:if>
							</td>
						</tr>
						<tr>
							<td>中心名称：</td>
							<td>${one.title}</td>
						</tr>
						<tr>
							<td>中心地址：</td>
							<td>${one.address}</td>
						</tr>
						<tr>
							<td>状态：</td>
							<td>
								<c:if test="${one.state==10}">未处理</c:if>
								<c:if test="${one.state==20}">已确认</c:if>
								<c:if test="${one.state==30}">已拒绝</c:if>
							</td>
						</tr>
						<tr>
							<td>申请时间：</td>
							<td>${one.requestDate}</td>
						</tr>
						<tr>
							<td>二级密码：</td>
							<td><s:password id="myTwoPassword" name="myTwoPassword"/></td>
						</tr>
						
						<tr>
							<td colspan="2">
								<div style="color: red;text-align:center;">
									<div style="color:red;text-align:center">
										<s:actionerror/>
										<s:fielderror/>
									</div>
								</div>
							</td>
						</tr>
						
				
						<tr>
							<td colspan="2">
								<input type="submit" value=" 提 交 " />
								<input type="reset" value=" 重 置 " />
							</td>
						</tr>
				
						
					</table>

				</s:form>
				
				
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>