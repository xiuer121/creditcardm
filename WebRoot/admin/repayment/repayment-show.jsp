<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

		<script type=text/javascript>
	$(function() {
	 	changePost();
		tr = $("#burshTable tr").eq(2);
		tr.hide();
		$("#okBtn").bind(
				'click',
				function() {
					//序列化表格内容为字符串    
					$.ajax({
						type : "post",
						data : $("#formBrush").serialize(),
						url : "repayment-brush.action",
						success : function(data) {
							if (data.result) {
								tr = $("#brushTable tr").eq(0);
								var insertStr = '';
								if (tr == null) {
									tr = $("#brushTable tr").eq(0);
								}
								if (data.brushType == 10) {
									insertStr = insertStr
											+ '<tr><td>刷卡</td><td>';
								} else {
									insertStr = insertStr
											+ '<tr><td>存入</td><td>';
								}
								if (data.bankTitle != null
										&& data.bankTitle != "") {
									insertStr = insertStr + data.bankTitle;
								}
								if (data.postTitle != null
										&& data.postTitle != "") {
									insertStr = insertStr + data.postTitle;
								}
								insertStr = insertStr + '<td>'
										+ data.brushMoney + '</td><td>'
										+ data.brushDate + '</td><td>'
										+ data.smallTicketNo + '</td></tr>';

								tr.after(insertStr);

							}
							top.Dialog.alert(data.message);

						}
					});
	
				});

		var alsePayMoney = $("#alsoPayMoney").val();
		var cardId = $("#cardId").val();
		$("#alsoPayMoney").bind(
				'blur',
				function() {
					var alsePayMoneyUpdate = $("#alsoPayMoney").val();
					if (alsePayMoney != alsePayMoneyUpdate) {
						top.Dialog.confirm("是进行更改", function() {
							$.ajax({
								type : "post",
								url : "repayment-ajax!updateAlso.action?id="
										+ cardId + "&alsoPayMoney="
										+ alsePayMoneyUpdate,
								success : function(data) {
									if (data.result) {

										top.Dialog.alert("修改成功");

									} else {
										top.Dialog.alert("修改失败");
									}
								}
							});
						});
					}
				});
	});
	function change() {
		var selectType = $("#brushType").val();

		if (selectType == 10) {
			$("#burshTable tr").eq(1).hide();
			$("#burshTable tr").eq(2).show();
		}
		if (selectType == 20) {
			$("#burshTable tr").eq(1).show();
			$("#burshTable tr").eq(2).hide();
		}
	}

	function changePost() {
		var postId = $("#postId").val();
		$.ajax({
			type : "post",
			url : "repayment-ajax!post.action?id=" +postId,
			success : function(data) { 
				$("#postSpan").html("今日已刷出金额："+data.postMoney+" 元")
			}
		});
	}
</script>

	</head>
	<body>

		<div class="box3" panelWidth="800" panelTitle="客户详细信息"
			style="float: left">
			<fieldset>
				<legend>
					银行卡信息
				</legend>
				<table class="tableStyle" transMode="true" footer="normal">
					<tr>
						<td width="10%">
							姓名：
						</td>
						<td width="40%">
							${one.personName}
						</td>
						<td width="10%">
							身份证：
						</td>
						<td>
							${one.idNo}
						</td>
					</tr>
					<tr>
						<td width="10%">
							卡号：
						</td>
						<td width="40%">
							${one.cardNo}
						</td>
						<td width="10%">
							所属银行：
						</td>
						<td>
							${one.cardBank}
						</td>
					</tr>
					<tr>
						<td width="10%">
							额度：
						</td>
						<td width="40%">
							${one.credits}
						</td>
						<td width="10%">
							余额：
						</td>
						<td>
							${one.balance}

						</td>
					</tr>
					<tr>
						<td width="10%">
							代还金额：
						</td>
						<td width="40%">
							<input type="text" value="${one.alsoPayMoney}" id="alsoPayMoney" />
							<input type="hidden" value="${one.id}" id="cardId" />
						</td>
						<td width="10%">
							还款日期：
						</td>
						<td>
							${one.repaymentDate}
						</td>
					</tr>
					<tr>
						<td>
							操作提示：
						</td>
						<td>

						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>
					联系信息
				</legend>
				<table class="tableStyle" transMode="true" footer="normal">
					<tr>
						<td width="10%">
							手机：
						</td>
						<td width="40%">
							${one.phone}
						</td>
						<td width="10%">
							电话：
						</td>
						<td>
							${one.tel}
						</td>
					</tr>
					<tr>
						<td width="10%">
							第三方：
						</td>
						<td width="40%">
							${one.thirdContact}
						</td>
						<td width="10%">

						</td>
						<td>

						</td>
					</tr>
					<tr>
						<td width="10%">
							家庭住址：
						</td>
						<td width="40%">
							${one.address}
						</td>
						<td width="10%">
							居住地址：
						</td>
						<td>
							${one.liveAddress}
						</td>
					</tr>

				</table>
			</fieldset>
			<fieldset>
				<legend>
					刷卡操作
				</legend>
				<s:form action="" id="formBrush">
					<s:hidden name="id" />
					<table class="tableStyle" transMode="true" footer="normal"
						id="burshTable">
						<tr>
							<td width="30%">
								刷卡操作：
							</td>
							<td width="70%">
								<s:select list="#{'10':'刷出','20':'存入'}" headerKey="20"
									headerValue="存入" name="brushType" id="brushType"
									onchange="change()" />
							</td>

						</tr>
						<tr>
							<td width="30%">
								银行卡：
							</td>
							<td width="70%">
								<s:select list="bankList" listKey="id"
									listValue="bankNo+'---'+bankTitle" name="bankId" />
							</td>
							
						</tr>
						<tr>
							<td width="30%">
								Post机子：
							</td>
							<td width="70%">
								<s:select list="postList" listKey="id"
									listValue="postNo+'---'+postTitle" name="postId" id="postId"
									onchange="changePost()" /><span style="color: red" id="postSpan"></span>
							</td>
						 
						</tr>
						<tr>
							<td width="30%">
								单号：
							</td>
							<td width="70%">
								<s:textfield name="smallTicketNo" id="smallTicketNo" />
							</td>
						</tr>
						<tr>
							<td width="30%">
								刷卡日期：
							</td>
							<td width="70%">
								<s:textfield name="brushDate" id="brushDate" cssClass="date" />
							</td>
						</tr>
						<tr>
							<td width="30%">
								金额：
							</td>
							<td width="70%">
								<s:textfield name="brushMoney" id="brushMoney" />
							</td>
						</tr>
						<tr>
							<td width="50%">

								<input type="button" id="okBtn" value="提交" />
							</td>
							<td>

							</td>
						</tr>

					</table>
				</s:form>
			</fieldset>

		</div>
		<div class="box3" panelWidth="500" panelTitle="操作记录"
			style="float: left">
			<table class="tableStyle" id="brushTable">
				<tr>
					<th>
						操作类型
					</th>
					<th>
						POST机/卡号
					</th>
					<th>
						金额
					</th>
					<th>
						日期时间
					</th>
					<th>
						单号
					</th>
				</tr>
				<c:forEach items="${creditsRecList}" var="one">
					<tr>
						<td>
							<c:if test="${one.brushType==10}">
							刷卡
							</c:if>
							<c:if test="${one.brushType==20}">
							存入
							</c:if>
						</td>
						<td>
							<c:if test="${one.postInfo!=null}">		
							${one.postInfo.postNo}--${one.postInfo.postTitle}
							</c:if>
							<c:if test="${one.bankInfo!=null}">	
							${one.bankInfo.bankNo}--${one.bankInfo.bankTitle}
							</c:if>
						</td>
						<td>
							${one.brushMoney}
						</td>
						<td>

							<fmt:formatDate value="${one.brushDate}" pattern="yyyy-MM-dd" />
						</td>
						<td>
							${one.smallTicketNo}
						</td>

					</tr>
				</c:forEach>
			</table>

		</div>
		<div style="height: 35px;">
			<div class="float_left padding5">
				<div class="float_left padding_top4">
					<span class="icon_page_first hand">第一页</span>
					<span class="icon_page_prev hand">上一页</span>
					<span class="icon_page_next hand">下一页</span>
					<span class="icon_page_last hand">最后一页</span>
				</div>


				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>

		<!--代码高亮end-->
	</body>
</html>