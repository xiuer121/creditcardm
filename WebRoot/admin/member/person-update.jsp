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
		
			<div class="box2" panelTitle="资料修改" roller="true">
	
<s:form id="commitForm" action="person-update!update" method="post">
	<s:hidden name="id"/>

					<table class="tableStyle" formMode="true">
					
						<tr>
							<th colspan="2">资料修改</th>
						</tr>
						<!-- 
						<tr>
							<td>会员编号：</td>
							<td><s:textfield id="loginName" name="loginName"/></td>
						</tr>
					 -->
						<tr>
							<td>一级密码：</td>
							<td><s:textfield id="onePassword" name="onePassword"/></td>
						</tr>
						<tr>
							<td>二级密码：</td>
							<td><s:textfield id="twoPassword" name="twoPassword"/></td>
						</tr>
						<tr>
							<td>昵称：</td>
							<td><s:textfield id="title" name="title"/></td>
						</tr>
						<tr>
							<td>Email：</td>
							<td><s:textfield id="email" name="email"/></td>
						</tr>
						
						<tr>
							<td>开户行：</td>
							<td><s:textfield id="bankName" name="bankName"/></td>
						</tr>
						<tr>
							<td>开户行地址：</td>
							<td><s:textfield id="bankAddress" name="bankAddress"/></td>
						</tr>
						<tr>
							<td>银行卡号：</td>
							<td><s:textfield id="bankCardNo" name="bankCardNo" cssStyle="width:200px;"/></td>
						</tr>
						<tr>
							<td>开户名：</td>
							<td><s:textfield id="bankPersonName" name="bankPersonName"/></td>
						</tr>
						
						<tr>
							<td>联系电话：</td>
							<td>
								<s:textfield id="tel" name="tel"/>
							</td>
						</tr>
						
						<tr>
							<td>QQ号码：</td>
							<td>
								<s:textfield id="qq" name="qq"/>
							</td>
						</tr>
						
						<tr>
							<td>身份证号：</td>
							<td>
								<s:textfield id="cardNo" name="cardNo"/>
							</td>
						</tr>
						<tr>
							<td>真实姓名：</td>
							<td>
								<s:textfield id="personName" name="personName"/>
							</td>
						</tr>
						<tr>
							<td>地址：</td>
							<td>
								<s:textfield id="adds" name="adds" cssStyle="width:350px;"/>
							</td>
						</tr>
						<tr>
							<td>分红天数：</td>
							<td>
								<s:textfield id="tuiNum" name="tuiNum" cssStyle="width:350px;"/>
							</td>
						</tr>
						<tr>
							<td>报单中心参数：</td>
							<td>
								<s:textfield id="baoWage" name="baoWage"/>
							</td>
						</tr>
							
					<tr>
					
					</tr>
					
						
						<tr>
							<td>密码保护问：</td>
							<td>
								<s:select id="pwdQuestion" name="pwdQuestion" 
								  	headerKey="" headerValue="请选择密码保护问题"
								  	list="#{'您的出生地是？':'您的出生地是？',
								  		  '您高中班主任的名字是？':'您高中班主任的名字是？',
								  		  '您父亲的姓名是？':'您父亲的姓名是？',
								  		  '您母亲的生日是？':'您母亲的生日是？',
								  		  '您配偶的姓名是？':'您配偶的姓名是？'}"/>
							</td>
						</tr>
						<tr>
							<td>密码保护答案：</td>
							<td>
								<s:textfield id="pwdAnswer" name="pwdAnswer"/>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<div style="color:red;text-align:center">
									<s:actionerror/>
									<s:fielderror/>
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