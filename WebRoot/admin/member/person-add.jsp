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
		
			<div class="box2" panelTitle="注册会员" roller="true">
	
<s:form id="commitForm" action="person-add!add.action" method="post">
					
					<fieldset style=" border:1px solid #3F9DE7"> 
					
						<legend>帐号基本信息</legend> 
						
						<table class="tableStyle" transMode="true" footer="normal">
						
							<tr>
								<td width="10%">经纪人账号：</td>
								<td width="40%">
									<s:textfield id="loginName" name="loginName" readonly="false"/>
									<span style="color:red">(*必填)</span>
								</td>
							 
								<td width="10%">推荐人编号：</td>
								<td width="40%">
									<s:textfield id="recommendLoginName" name="recommendLoginName"/>
								</td>
							
							</tr>
							<tr>
								<td>密码：</td>
								<td>
									<input type="password" id="onePassword" name="password"/>
									<span style="color:red">(*必填)</span>
								</td>
								
								<td>确认密码：</td>
								<td>
									<input type="password" id="onePasswordRec" name="passwordRec" />
									<span style="color:red">(*必填)</span>
								</td>
							</tr>
							
							<tr>
								<td>地址</td>
								<td> 
									<s:textfield id="adds" name="adds" cssStyle="width:350px;"/>
									<span style="color:red">(*必填)</span>
								</td>
								<td>电话</td>
								<td> 
									<s:textfield id="tel" name="tel" />
									<span style="color:red">(*必填)</span>
								</td>
							</tr>
							
							
							<tr>
								<td>真实姓名</td>
								<td> 
									<s:textfield id="personName" name="personName" cssStyle="width:350px;"/>
									<span style="color:red">(*必填)</span>
								</td>
								<td>身份证号</td>
								<td> 
									<s:textfield id="cardNo" name="cardNo" />
									<span style="color:red">(*必填)</span>
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
									<input type="submit" value=" 提 交 "/>
									<input type="reset" value=" 重 置 "/>
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