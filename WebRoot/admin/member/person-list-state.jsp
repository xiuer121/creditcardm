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
			<div class="box2" panelTitle="会员参数列表" roller="true">
			
<s:form name="showTable" method="post">
	<s:hidden id="page" name="view.currentPage" />
	
				<table class="tableStyle">
					<tr>
						<th>编号</th>
						<th>姓名</th>

						<th>推荐人</th>
						<th>会员级别</th>
						
						<th>推荐人数</th>
						<th>推荐业绩</th>
	
						<th>奖金币</th>
						<th>报单币</th>
						
						<th>接点人</th>
						<th>小区人数</th>
						
						<th>所属区域</th>
						
						<th>左区会员</th>
						<th>右区会员</th>
						
						<th>左区人数</th>
						<th>右区人数</th>
						
						<th>左区业绩</th>
						<th>右区业绩</th>
								
						<th>开通时间</th>

					</tr>
	<c:forEach items="${view.records}" var="o">
					<tr>
						<td>${o.loginName}</td>
									
						<td>${o.personName}</td>

						<td>${o.recommend.loginName}</td>
									
						<td>
						<c:if test="${o.level==10}">金卡会员</c:if>
						<c:if test="${o.level==20}">高级会员</c:if>
						
						</td>
						
						<td>${o.recommendNum}</td>
						<td>${o.recommendYe}</td>
										
						<td>${o.money}</td>
						<td>${o.ele}</td>
						
						<td>${o.father.loginName}</td>
						<td>${o.xiaoRen}</td>
						
						<td>
							<c:if test="${o.qu==1}">左区</c:if>
							<c:if test="${o.qu==2}">右区</c:if>
						</td>
						
						<td>${o.zuo.loginName}</td>
						<td>${o.you.loginName}</td>
						
						<td>${o.zuoRen}</td>
						<td>${o.youRen}</td>
						
						<td>${o.zuoNum}</td>
						<td>${o.youNum}</td>

						<td>${o.activeDate}</td>

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