<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--框架必需start-->
	<script type="text/javascript" src="../../js/jquery-1.4.js"></script>
	<script type="text/javascript" src="../../js/framework.js"></script>
	<link href="../../css/import_basic.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../../js/tree/ztree/ztree.js"></script>
	<link href="../../js/tree/ztree/ztree.css" rel="stylesheet"
		type="text/css" />
	<link rel="stylesheet" type="text/css" id="skin" prePath="../../"/>
	<script type="text/javascript">
	$(document).ready(function(){
	
	 var type = $("#type").val();
	 if(type=30){
		 myForm.action="../heighten/heighten-info-update!fen.action";
	 }
	
	
		var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true
			}
		}

		};
		var zNodes = ${json};
	
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);

	 	var zTree =  $.fn.zTree.getZTreeObj("treeDemo");
		var selects=$("#selects").val();
		var items = selects.split(",");
		$.each(items,function(i, item){
			if(item!=""){
				var node = zTree.getNodeByParam("id",item);
				if(node!=null){
						node.checked = true;
						zTree.updateNode(node, "checked");
				}
			}
		
		});
	});
	function viewData() {
		//获取zTree对象
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		//得到选中的数据集
		var checkedNodes = zTree.getCheckedNodes(true);
		//得到未选中的数据集
		var checkedNodes2 = zTree.getCheckedNodes(false);
		var msg = "";
		var msg2 = "";
		var nodes = zTree.getSelectedNodes();
		
		
		for ( var i = 0; i < checkedNodes.length; i++) {
			msg = msg + "," + checkedNodes[i].id
			
		}
		$("#selects").val(msg);
	}
</script>
	<!--框架必需end-->
	<body>
		
		
		<s:form action="../repayment/repayment-update!fen.action" method="post" id="myForm">
		<s:hidden name="is"/>
		<s:hidden name="selects" id="selects"/>
		<s:hidden name="type" id="type"/>
		<div class="box2" overflow="auto" showStatus="false" panelTitle="用户选择">
					<div class="cusBoxContent" style="width:150px;">
							<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
		<s:submit value="提交" onclick="viewData()"/>		
		</s:form>
	</body>
</html>