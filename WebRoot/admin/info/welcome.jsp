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
		
		<script type=text/javascript>
			function openWin2(id){
		
				top.Dialog.open({URL:"info/notice-show.action?id="+id,MessageTitle:"公告查看 ",Title:"公告查看 ",Width:800,Height:500});
			}
		</script>
		
		<style type="text/css">
			.cont{
				margin-left:10px;
			}
		</style>
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box4 cont" panelWidth="95%" panelHeight="30"  panelTitle="会员帐号信息">
				<table style="width:100%;border:0px;">
					<tr>
						<td style="width:10%;text-align:right">会员帐号：</td>
						<td style="width:8%;text-align:left">
							<span style="color:blue;font-weight:bolder;">${admin.loginName}</span>
						</td>
						
						<td style="width:10%;text-align:right">上次登录时间：</td>
						<td style="width:8%;text-align:left">
							<span style="color:blue;font-weight:bolder;">${admin.lastTime}</span>
						</td>
						
						<td style="width:10%;text-align:right">登录次数：</td>
						<td style="width:8%;text-align:left">
							<span style="color:blue;font-weight:bolder;">${admin.loginNum}</span>
						</td>
						
						<td style="width:10%;text-align:right">登录时间：</td>
						<td style="width:8%;text-align:left">
							<span style="color:blue;font-weight:bolder;">${admin.loginTime}</span>
						</td>
						
						<td style="width:15%;text-align:right">姓名：</td>
						<td style="width:10%;text-align:left">
							<span style="color:blue;font-weight:bolder;">${admin.personName}</span>
						</td>
						
					</tr>
				</table>
			</div>
		
			<div class="cont" style="width:95%">
				<div class="box4" panelWidth="49%" panelTitle="会员信息" style="float:left;">
					<table class="tableStyle">
						<tr>
							<td style="width:40%">一星人数</td>
							<td style="width:60%">${onex}</td>
						</tr>
						<tr>
							<td style="width:40%">二星人数</td>
							<td style="width:60%">${twox}</td>
						</tr>
						<tr>
							<td style="width:40%">三星人数</td>
							<td style="width:60%">${threex}</td>
						</tr>
						<tr>
							<td style="width:40%">四星人数</td>
							<td style="width:60%">${fourx}</td>
						</tr>
						<tr>
							<td style="width:40%">五星人数</td>
							<td style="width:60%">${fivex}</td>
						</tr>
						
					</table>
				</div>
				<div class="box4" panelWidth="49%" panelTitle="激活信息" style="float:right;">
					<table class="tableStyle">
					 
						<tr>
							<td style="width:40%">当天激活人数</td>
							<td style="width:60%">${renNum}</td>
						</tr>
						<tr>
							<td style="width:40%">当天激活业绩</td>
							<td style="width:60%">${yeNum}</td>
						</tr>
						<tr>
							<td style="width:40%">累计激活人数</td>
							<td style="width:60%">${leirenNum}</td>
						</tr>
						<tr>
							<td style="width:40%">累计激活业绩</td>
							<td style="width:60%">${leiyeNum}</td>
						</tr>
						
						
					</table>
				</div>
			</div>
			
			
			<div class="box4 cont" panelWidth="95%" panelHeight="300"  panelTitle="最新公告">
				<table class="tableStyle">
					<tr>
						<th>编号</th>
						<th style="width:50%">标题</th>
						<th>作者</th>
						<th>发布时间</th>
						<th>附件数</th>
						<th>公告查看</th>
					</tr>
	<c:forEach items="${noticeList}" var="o">
					<tr>
						<td>${o.id}</td>
						<td>
							${o.title}
						</td>
						<td>${o.admin.title}</td>
						<td>${o.commitDate}</td>
						<td>${o.fileNum}</td>
						<td>
							<a href="javascript:openWin2(${o.id})">
								<span class="icon_view">查看</span>
							</a>
						</td>
					</tr>
	</c:forEach>
				</table>
			</div>
			
		</div>
	<!--代码高亮end-->
	</body>
</html>