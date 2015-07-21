<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--框架必需start-->
		<script type="text/javascript" src="../js/jquery-1.4.js"></script>
		<script type="text/javascript" src="../js/framework.js"></script>
		<link href="../css/import_basic.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" id="skin" />
		<!--框架必需end-->

		<!--修正ie6支持png图片start-->
		<script type="text/javascript"
			src="../js/method/pngFix/supersleight.js"></script>
		<!--修正ie6支持png图片end-->

		<!--鼠标移入图标变色start-->
		<script type=text/javascript>
			$(function() {
				$(".navIconSmall").hover(function() {
					$(this).addClass("navIconSmall_hover");
				}, function() {
					$(this).removeClass("navIconSmall_hover");
				})
			})
		</script>
		<!--鼠标移入图标变色end-->
	</head>

	<body>

		<div class="navIconSmall">
			<a href="info/message-list.action" target="frmright">
				<img src="../icons/png/02.png" />
			</a>
			<br />
			我的收件箱
		</div>
		<div class="navIconSmall">
			<a href="info/data-list.action" target="frmright">
				<img src="../icons/png/07.png" />
			</a>
			<br />
			资料文档
		</div>
		<div class="navIconSmall">
			<a href="info/notice-list.action" target="frmright">
				<img src="../icons/png/08.png" />
			</a>
			<br />
			俱乐部公告
		</div>
		<div class="navIconSmall">
			<a href="member/tu-kuang.action" target="frmright">
				<img src="../icons/png/03.png" />
			</a>
			<br />
			接点框形图
		</div>
		<div class="navIconSmall">
			<a href="wealth/log-money-list.action" target="frmright">
				<img src="../icons/png/39.png" />
			</a>
			<br />
			奖金币明细
		</div>
		<div class="navIconSmall">
			<a href="member/person-add!show.action" target="frmright">
				<img src="../icons/png/71.png" />
			</a>
			<br />
			注册会员
		</div>
		<div class="clear"></div>
	</body>
</html>