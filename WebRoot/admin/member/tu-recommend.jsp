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
		
		<link href="../../js/zTree/zTreeStyle.css" rel="stylesheet"/>
		<script src="../../js/zTree/jquery.ztree-2.6.min.js" type="text/javascript"></script>
		
		<script type=text/javascript>
			var zTree ;
			var setting;
			var zNodes =[];

			setting = {
			
				async: true,
				
				isSimpleData : true,
				treeNodeKey : "id",
				treeNodeParentKey : "pId",
				
				asyncUrl: "ajax-tu-recommend.action",    				//获取节点数据的URL地址
				asyncParam: ["id"],        	     						//获取节点数据时，必须的数据名称，例如：id、name
				asyncParamOther: ["loginName","${loginName}"],        	//其它参数 ( key, value 键值对格式)
				callback:{
					asyncSuccess: zTreeOnAsyncSuccess,
					expand: zTreeOnExpand
				}
			};
	
			
			
			$(document).ready(function(){
				refreshTree();
			});
			
			//异步返回的数据
			function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
				zTree.expandNode(treeNode, false, false,false);
			}

			//刷新数据
			function refreshTree(asyncUrl) {

				setting.asyncUrl = "ajax-tu-recommend.action";
				setting.asyncDataFilter = dataFilter;

				zTree = $("#tree").zTree(setting, zNodes);
			}
			
			//数据过滤
			function dataFilter(treeId, parentNode, childNodes) {
				childNodes=childNodes.menuList;
				return childNodes;
			}

			//展开的时候增加孙子
			function zTreeOnExpand(event, treeId, treeNode) {
				var nodes = zTree.getNodesByParam("pId", treeNode.id, treeNode);

				for(var i =0; i<nodes.length; i++) {
					if(nodes[i].childNum>0){
						nodes[i].isParent=true;
						zTree.updateNode(nodes[i])
						zTree.reAsyncChildNodes(nodes[i], "refresh");
					}else{
						nodes[i].isParent=false;
					}
					
					
				}
			}
		</script>
		
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box2" panelTitle="推荐网络关系" roller="true">
	
<s:form id="commitForm" method="post">

				<div style="margin:0 auto;width:90%">
					<div id="tree" class="tree" ></div>
				</div>

				<div style="margin:0 auto;width:90%">
					<iframe id="show" name="show" src="tu-recommend-show.action?id=${id}" frameborder="0"
						width="100%" height="120" scrolling="no"/>
				</div>
</s:form>
				
				
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>