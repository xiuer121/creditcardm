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
			type="t
			ext/css" />
		<link rel="stylesheet" type="text/css" id="skin" prePath="../../" />
		<!--框架必需end-->

		<script type=text/javascript>
	function topage(page) {
		var form = document.forms["showTable"];
		document.getElementById("page").value = page;
		form.submit();
	}

	function queryForm() {
		var form = $("#searchForm");
		form.action = "repayment-list.action";
		form.submit();
	}

	$(function() {
		top.Dialog.close();
		$('.myCancel')
				.bind(
						'click',
						function() {
							var cardId = $(this).attr('id');
							top.Dialog
									.confirm(
											"是否进行审核",
											function() {
												$
														.ajax({
															type : "post",
															url : "../repayment/repayment-ajax!updateDeal.action?id="
																	+ cardId,
															success : function(
																	data) {
																if (data.result) {
																	top.Dialog
																			.alert("审核成功");
																	location.href = "./deal-info-list.action";
																} else {
																	top.Dialog
																			.alert("审核失败");
																}
															}
														});
											});
						});
	});
</script>

	</head>
	<body>
		<div class="box_tool ">
			<div class="center">
				<div class="left">
					<div class="right">
						<div class="padding_top8 padding_left10">
							<s:form action="" name="searchForm" id="searchForm">
								<table>
									<tr>
										<td>
											姓名:
										</td>
										<td>
											<s:textfield id="personName" name="personName" />
										</td>
										<td>
											电话：
										</td>
										<td>
											<s:textfield id="phone" name="phone" />
										</td>
										<td>
											身份证：
										</td>
										<td>
											<s:textfield id="idNo" name="idNo" />
										</td>

										<td>
											<button>
												<span class="icon_find" href="javascript:queryForm()">查询</span>
											</button>
										</td>
									</tr>
								</table>

							</s:form>
						</div>
					</div>
				</div>
			</div>
			<div id="scrollContent">

				<s:form name="showTable" method="post">
					<s:hidden id="page" name="view.currentPage" />

					<table class="tableStyle">
						<tr>
							<th>
								编号
							</th>
							<th>
								姓名
							</th>
							<th>
								卡号
							</th>
							<th>
								身份证号
							</th>
							<th>
								刷出金额
							</th>
							<th>
								存入金额
							</th>
							<th>
								返点金额
							</th>
							<th>
								业务类型
							</th>
							<th>
								结算状态
							</th>
							<th>
								完成状态
							</th>
							<th>
								操作
							</th>
						</tr>
						<c:forEach items="${view.records}" var="o">
							<tr>
								<td>
									${o.id}
								</td>
								<td>
									${o.cardInfo.personName}
								</td>
								<td>
									${o.cardInfo.cardNo}
								</td>
								<td>
									${o.cardInfo.idNo}
								</td>
								<td>
									<c:if test="${o.postMoney==null}">
										<span style="color: red;">未刷出</span>
									</c:if>
									${o.postMoney}
								</td>
								<td>
									${o.bankMoney}
								</td>
								<td>
									${o.money}
								</td>
								<td>

									<c:if test="${o.cardInfo.cardType==10}">代还</c:if>
									<c:if test="${o.cardInfo.cardType==20}">取现</c:if>
									<c:if test="${o.cardInfo.cardType==30}">提额</c:if>
								</td>
								<td>

									<c:if test="${o.checkState==10}">未结算</c:if>
									<c:if test="${o.checkState==20}">已结算</c:if>
								</td>
								<td>

									<c:if test="${o.finshState==10}">未完成</c:if>
									<c:if test="${o.finshState==20}">
										<span style="color: red">完成</span>
									</c:if>

								</td>

								<td>
									<c:if test="${o.checkState==10}">
										<a class="myCancel" id="${o.id}"> <span class="icon_view">审核</span>
										</a>
									</c:if>
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