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
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box2" panelTitle="查看邮件" roller="true">
	
<s:form id="commitForm" method="post">

					<table class="tableStyle" formMode="true">
					
						<tr>
							<th colspan="2">查看邮件</th>
						</tr>
					
						<tr>
							<td>标题：</td>
							<td>${one.title}</td>
						</tr>
						<tr>
							<td>发信人：</td>
							<td>
								<c:if test="${one.fromPerson == null}">
									公司客服
								</c:if>
								<c:if test="${one.fromPerson != null}">
									${one.fromPerson.loginName}
								</c:if>
							</td>
						</tr>
						
						<tr>
							<td>收信人：</td>
							<td>
								<c:if test="${one.toPerson == null}">
									公司客服
								</c:if>
								<c:if test="${one.toPerson != null}">
									${one.toPerson.loginName}
								</c:if>
							</td>
						</tr>
						<tr>
							<td>发信时间：</td>
							<td><fmt:formatDate value="${one.commitDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
						</tr>
						
						<tr>
							<td>
								<div style="text-align:right;">
									正文：
								</div>
							</td>
							<td>
								<div style="text-align:left;">
									<s:property value="one.content" escape="false"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td colspan="2">
								<c:if test="${state==20}">
									<input type="button" value="回复会员" onclick="javascript:window.location.href='message-hui!show.action?id=${one.id}'"/>
								</c:if>
							</td>
						</tr>
						
					</table>

				</s:form>
				
				
			</div>
		</div>
	<!--代码高亮end-->

	</body>
</html>