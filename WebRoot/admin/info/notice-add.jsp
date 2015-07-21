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
		
		<!--文本编辑器start-->
		<script type="text/javascript" src="../../js/xheditor/xheditor-zh-cn.min.js"></script>
		<script type=text/javascript>
			$(document).ready(function(){
				//设置编辑器
				$("#content").xheditor(
					true, 
					{ tools: "full", skin: "default" }
				);
			});
		</script>
		<!--文本编辑器end-->
		
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
		
			<div class="box2" panelTitle="新增公告" roller="true">
	
<s:form id="commitForm" action="notice-add.action" method="post">

					<table class="tableStyle" formMode="true">
					
						<tr>
							<th colspan="2">新增公告</th>
						</tr>
					
						<tr>
							<td>标题</td>
							<td><s:textfield id="title" name="title" cssStyle="width:600px;"/></td>
						</tr>
						<tr>
							<td>所属栏目</td>
							<td>
								<s:select list="list" listKey="id" listValue="title" id="catalogId" name="catalogId"/>
							</td>
						</tr>
						<tr>
							<td>内容：</td>
							<td><s:textarea id="content" name="content" cssStyle="width:600px;height:300px;"/></td>
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