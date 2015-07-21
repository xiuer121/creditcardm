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
	</head>
	
	<body>
		<div class="box1 center" panelWidth="450">
			<div class="msg_icon1"></div>
			<div class="padding_left50 padding_right15 padding_top20 minHeight_100 font_14 font_bold" >
				会员添加成功，点击这里 <a href="person-add!show.action" target="frmright"><span style="color:blue;">返回</span></a> 继续添加。<br/>
				您也可以点击这里 <a href="person-active!show.action?id=${one.id}" target="frmright"><span style="color:blue;">开通</span></a> 该会员。
			</div>
		</div>
	</body>
</html>