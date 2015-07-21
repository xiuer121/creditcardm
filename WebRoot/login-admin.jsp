<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<title>广西百顺兴投资公司管理平台 </title>
		
		<link href="login/skin11/style.css" rel="stylesheet" type="text/css" id="skin" />
		<script type="text/javascript" src="js/jquery-1.4.js"></script>
		<script type="text/javascript" src="js/login.js"></script>

		<!--引入弹窗组件start-->
		<script type="text/javascript" src="js/attention/zDialog/zDrag.js"></script>
		<script type="text/javascript" src="js/attention/zDialog/zDialog.js"></script>
		<!--引入弹窗组件end-->

		<!--修正IE6支持透明png图片start-->
		<script type="text/javascript" src="js/method/pngFix/supersleight.js"></script>
		<!--修正IE6支持透明png图片end-->

		<!--居中显示start-->
		<script type="text/javascript" src="js/method/center-plugin.js"></script>
		<script type="text/javascript">
			$(function() {
				$('.login_main').center();

				if (window.parent != null && window.parent.document.URL != document.URL) {
					window.parent.location = document.URL;
				}

			})
		</script>
			
		<!--居中显示end-->
		<style type="text/css">
			/*提示信息*/
			#cursorMessageDiv {
				position: absolute;
				z-index: 99999;
				border: solid 1px #cc9933;
				background: #ffffcc;
				padding: 2px;
				margin: 0px;
				display: none;
				line-height: 150%;
			}
			/*提示信息*/
		</style>
	</head>
	
	<body>
		<div class="login_main">
			<div class="login_top">
				<div class="login_title"></div>
			</div>
			<div class="login_middle">
				<div class="login_middleleft"></div>
				<div class="login_middlecenter">
				
<s:form action="login-admin!login" cssClass="login_form" method="post">
						<div class="login_user">
							<s:textfield name="loginName"/>
						</div>
						<div class="login_pass">
							<s:password name="password" />
						</div>
						<div class="clear"></div>
						<div class="login_button">
							<div class="login_button_left">
								<input type="submit" value="" onfocus="this.blur()" />
							</div>
							<div class="login_button_right">
								<input type="reset" value="" onfocus="this.blur()" />
							</div>
							<div class="clear"></div>
						</div>
</s:form>
					<div class="login_info">
						<s:actionerror/>
						<s:fielderror/>
					</div>
				</div>
				<div class="login_middleright"></div>
				<div class="clear"></div>
			</div>
			<div class="login_bottom">
				<div class="login_copyright">
					广西百顺兴投资公司管理平台 COPYRIGHT 2014 
				</div>
			</div>
		</div>
	</body>
</html>
