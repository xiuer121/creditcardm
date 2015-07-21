<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!--框架必需start-->
		<script type="text/javascript" src="../js/jquery-1.4.js"></script>
		<script type="text/javascript" src="../js/framework.js"></script>
		<link href="../css/import_basic.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" id="skin" prePath="../"/>
		<!--框架必需end-->
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box2" panelTitle="二级密码确认" roller="true">
	
<s:form id="commitForm" action="pwd-two-validation" method="post">
	<s:hidden name="path"/>
	
					<table class="tableStyle" formMode="true">
					
						<tr>
							<th colspan="2">二级密码确认</th>
						</tr>
					
						<tr>
							<td style="width:50%">二级密码：</td>
							<td>
								<s:password id="myTwoPassword" name="myTwoPassword"/>
							</td>
						</tr>
						
						<tr>
							<td colspan="2">
								<div style="color: red;text-align:center;">
									<s:actionerror/>
									<s:fielderror/>
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