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

		<script type=text/javascript>
	function topage(page) {
		var form = document.forms["showTable"];
		document.getElementById("page").value = page;
		form.submit();
	}

	function queryForm() {
		var form = $("#searchForm");
		form.action = "heighten-info-list.action";
		form.submit();
	}

	function openWin(id) {
		var diag = new top.Dialog();
		diag.Title = "返点设置";
		diag.URL = "heighten/heighten-info-update!show.action?id=" + id;
		diag.Height = 480;
		diag.Width = 680;
		diag.MessageTitle = "返点设置";
		diag.Message = "返点设置";
		diag.CancelEvent = function() {
			diag.innerFrame.contentWindow.location.reload();
			diag.close();
		};
		diag.show();
	}

	function fbill() {
		var form = document.forms[1];
		form.action = "../sys/admin-list!getUson.action?type=30";
		if ($("input[name='ids']:checked").length == 0) {
			top.Dialog.alert("请选择一条记录");
		} else {
			form.submit();
		}

	}
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
			<!-- 
			<div class="box_tool_min padding_top2 padding_bottom2 padding_right5">
				<div class="center">
					<div class="left">
						<div class="right">
							<div class="padding_top5 padding_left10">
								<a href="javascript:fbill();
								"><span
									class="icon_view">任务分配</span> </a>
							</div>
						</div>
					</div>
				</div>
			</div>
			 -->
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
								交易密码
							</th>
							<th>
								查询密码
							</th>
							<th>
								身份证号
							</th>
							<th>
								手机号码
							</th>
							<th>
								所属银行
							</th> 
							<th>
								所属员工
							</th> 
							
							<th>
								当前额度
							</th>
							 
							<th>
								到达额度
							</th>
							<th>
								余额
							</th>
							 
							<th>
								操作
							</th>

						</tr>
						<c:forEach items="${view.records}" var="o">
							<tr>
								<td>
									<input type="checkbox" name="ids" value="${o.id}" />
								</td>
								<td>
									${o.personName}
								</td>
								<td>
									${o.cardNo}
								</td>
								<td>
									${o.cardPassword}
								</td>
								<td>
									${o.queryPassword}
								</td>
								<td>
									${o.idNo}
								</td>
								<td>
									${o.phone}
								</td>
								<td>
									${o.cardBank}
								</td>
								<td>
									${o.admin.personName}
								</td>

								<td>
									${o.credits}
								</td>
								<td>
									${o.money}
								</td>
								 
								<td>
									${o.rates}
								</td>
								 
								<td>

									<a href="javascript:openWin(${o.id})"> <span
										class="icon_view">修改</span> </a>
									<!-- 
									<a href="../heighten/heighten-info-add!zhuan.action?id=${o.id}">
										<span class="icon_edit">提额完成</span> </a>
									 -->
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