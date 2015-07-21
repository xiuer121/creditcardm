<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--框架必需start-->
	<script type="text/javascript" src="../../js/jquery-1.4.js"></script>
	<script type="text/javascript" src="../../js/framework.js"></script>
	<link href="../../css/import_basic.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript"
		src="../../fusionCharts/FusionCharts.js"></script>
	<link rel="stylesheet" type="text/css"
		href="../../fusionCharts/prettify.css" style="" />

	<script type="text/javascript" src="../../js/tree/ztree/ztree.js"></script>
	<link href="../../js/tree/ztree/ztree.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript" src="../../js/form/selectTree.js"></script>


	<link rel="stylesheet" type="text/css" id="skin" prePath="../../" />
	<script type="text/javascript">
	
	function fx() {
		
		$.ajax({
			type : 'POST',
			url : './company-huan-line-ajax.action',
			data : $("#fxTable").serialize(),//序列化表单里所有的内容
			success : function(data) {
			
				FusionCharts.printManager.enabled(true);
				var chartObj = new FusionCharts(
						'../../fusionCharts/swf/MSLine.swf',
						'flash-chart', '600', '350');

				chartObj.setJSONData(JSON.stringify(data.chartsObject));
				chartObj.render('user_q_h_m');

			}
		});
	}
	
</script>
	<!--框架必需end-->
	<body>
		<div class="position">
			<div class="center">
				<div class="left">
					<div class="right">
						<span>当前位置：数据分析 >>职工对比分析</span>
					</div>
				</div>
			</div>
		</div>
		<div id="scrollContent">
			<div class="box2" panelTitle="功能面板" roller="false">

				<s:form action="#" method="post" id="fxTable" > 
					<table>
						<tr>
						
							<td>
								开始时间：
							</td>
							<td>
								<s:textfield  name="start" cssClass="date" dateFmt="yyyyMMdd"/>
							</td>
							<td>
								结束：
							</td>
							<td>
								<s:textfield  name="end" cssClass="date" dateFmt="yyyyMMdd"/>
							</td>
							<td>
								<input type="button" value="查询" onclick="fx();"  />
							</td>
						</tr>
					</table>
				</s:form>
			</div>
			
			<div class="box1" panelWidth="500" id="user_q_h_m">
			 
			</div>
		</div>
	</body>
</html>