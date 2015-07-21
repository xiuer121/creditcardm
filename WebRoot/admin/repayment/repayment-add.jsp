<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<link href="../../css/import_basic.css" rel="stylesheet"
			type="text/css" />
		<link rel="stylesheet" type="text/css" id="skin" prePath="../../" />
		<!--框架必需end-->

		<!-- 遮罩效果 -->
		<script type="text/javascript" src="../../js/form/loadmask.js"></script>
		<script type="text/javascript">
	$(document).ready(function() {
		$(":submit").bind("click", function() {
			$("#commitForm").mask("数据提交中，请等待！");
		});
	});
</script>
		<!-- 遮罩效果结束 -->

	</head>
	<body>
		<div id="scrollContent">
			<div class="box2" panelTitle="代还客户添加" roller="true">



				<s:form id="commitForm" action="repayment-add" method="post">
					<s:hidden name="cardType" value="10"/>
					<table class="tableStyle" transMode="true">

						<tr>
							<td>
								姓名：
							</td>
							<td>
								<s:textfield id="personName" name="personName" />
							</td>
						</tr>
						<tr>
							<td>
								身份证号：
							</td>
							<td>
								<s:textfield id="idNo" name="idNo" />
							</td>
						</tr>
						<tr>
							<td>
								手机：
							</td>
							<td>
								<s:textfield id="phone" name="phone" />
							</td>
						</tr>


						<tr>
							<td>
								电话：
							</td>
							<td>
								<s:textfield id="tel" name="tel" />
							</td>
						</tr>
						<tr>
							<td>
								卡号：
							</td>
							<td>
								<s:textfield id="cardNo" name="cardNo" />
							</td>
						</tr>
						<tr>
							<td>
								交易密码：
							</td>
							<td>
								<s:textfield id="cardPassword" name="cardPassword" />
							</td>
						</tr>
						<tr>
							<td>
								查询密码：
							</td>
							<td>
								<s:textfield id="queryPassword" name="queryPassword" />
							</td>
						</tr>
						<tr>
							<td>
								所属银行：
							</td>
							<td>
								<s:textfield id="cardBank" name="cardBank" />
							</td>
						</tr>
						<tr>
							<td>
								信用卡额度：
							</td>
							<td>
								<s:textfield id="credits" name="credits" />
							</td>
						</tr> 
						<tr>
							<td width="30%">
								还卡用卡：
							</td>
							<td width="70%">
								<s:select list="bankList" listKey="id"
									listValue="bankNo+'---'+bankTitle" name="bankId" />
							</td>
							
						</tr>
						<tr>
							<td>
								代还金额：
							</td>
							<td>
								<s:textfield id="money" name="money" />
							</td>
						</tr>
						 
						<tr>
							<td>
								费率：
							</td>
							<td>
								<s:textfield id="rates" name="rates" />
							</td>
						</tr>
							<tr>
							<td>
								是否留卡：
							</td>
							<td>
								<s:radio list="#{'true':'是','false':'否'}" name="stayStates"/>
							</td>
						</tr>
					 
							<tr>
							<td>
								 <s:actionerror />
							</td>
							<td>
								 
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value=" 提交 " />
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