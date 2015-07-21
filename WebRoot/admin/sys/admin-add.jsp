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
			<div class="box2" panelTitle="新增管理员" roller="true"  >
			

				
<s:form id="commitForm" action="admin-add" method="post">

					<table class="tableStyle" transMode="true">
						 
						<tr>
							<td>登录名：</td><td><s:textfield id="loginName" name="loginName"/></td>
						</tr>
						<tr>
							<td>一级密码</td><td><s:password id="onePassword" name="password"/></td>
						</tr>
						<tr>
							<td>一级密码确认</td><td><s:password id="onePasswordRec" name="passwordRec"/></td>
						</tr>
					
						
						<tr>
							<td>真实姓名</td><td><s:textfield id="personName" name="personName"/></td>
						</tr>
						<tr>
							<td>联系电话</td><td><s:textfield id="tel" name="tel"/></td>
						</tr>
						 <tr>
							<td>员工返点</td><td><s:textfield id="point" name="point"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<s:actionerror />
								<s:fielderror/>
								<input type="submit" value=" 提交 "/>
								<input type="reset" value=" 重 置 "/>
							</td>
						</tr>
					</table>
</s:form>
				
				
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>