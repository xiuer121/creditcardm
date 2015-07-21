<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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

		<script type="text/javascript" src="../js/nav/ddaccordion.js"></script>
		<script type="text/javascript" src="../js/text/text-overflow.js"></script>
		<style>
			a {
				behavior: url(../js/method/focus.htc)
			}
			.categoryitems span {
				width: 160px;
			}
		</style>

	</head>

	<body leftFrame="true">
		<div id="scrollContent">
			<div class="arrowlistmenu">
			
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>业务管理
				</div>
				<ul class="categoryitems">
		
						<li>
							<a href="../admin/repayment/client-add!show.action?type=10" target="frmright">
								<span class="text_slice">代还</span>
							</a>
						</li>
						<li>
							<a href="../admin/repayment/repayment-list.action" target="frmright">
								<span class="text_slice">代还列表</span>
							</a>
						</li>
						<li>
							<a href="../admin/repayment/client-add!show.action?type=20" target="frmright">
								<span class="text_slice">取现</span>
							</a>
						</li> 
						<li>
							<a href="../admin/repayment/cash-list.action" target="frmright">
								<span class="text_slice">取现列表</span>
							</a>
						</li>
						<li>
							<a href="../admin/heighten/heighten-info-add.jsp" target="frmright">
								<span class="text_slice">提额</span>
							</a>
						</li>
						<li>
							<a href="../admin/heighten/heighten-info-list.action" target="frmright">
								<span class="text_slice">提额列表</span>
							</a>
						</li>
				
				</ul>
 
 
 				<div class="menuheader expandable">
					<span class="normal_icon2"></span>客户管理
				</div>
				<ul class="categoryitems">
		
						<li>
							<a href="../admin/repayment/client-list.action" target="frmright">
								<span class="text_slice">客户列表</span>
							</a>
						</li> 
				</ul>
				
				
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>银行管理
				</div>
				<ul class="categoryitems">
						<li>
							<a href="../admin/sys/bank-add.jsp" target="frmright">
								<span class="text_slice">银行卡录入</span>
							</a>
						</li> 
						<li>
							<a href="../admin/sys/bank-list.action" target="frmright">
								<span class="text_slice">银行卡管理</span>
							</a>
						</li> 
						<li>
							<a href="../admin/sys/bank-day-list.action" target="frmright">
								<span class="text_slice">银行卡每日还卡记录</span>
							</a>
						</li> 
				</ul>
				
				
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>post机管理
				</div>
				<ul class="categoryitems">
						<li>
							<a href="../admin/sys/post-add.jsp" target="frmright">
								<span class="text_slice">post机录入</span>
							</a>
						</li> 
						<li>
							<a href="../admin/sys/post-list.action" target="frmright">
								<span class="text_slice">post机管理</span>
							</a>
						</li> 
						<li>
							<a href="../admin/sys/post-day-list.action" target="frmright">
								<span class="text_slice">POST机每日刷卡记录</span>
							</a>
						</li> 
				</ul>
				
				
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>员工管理
				</div>
				<ul class="categoryitems">
						<li>
							<a href="../admin/sys/admin-add.jsp" target="frmright">
								<span class="text_slice">新增员工</span>
							</a>
						</li>
						<li>
							<a href="../admin/sys/admin-list.action" target="frmright">
								<span class="text_slice">员工列表</span>
							</a>
						</li>
				</ul>
		 		<!--  
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>提额管理
				</div>
				<ul class="categoryitems">
					<li>
							<a href="../admin/heighten/heighten-info-add.jsp" target="frmright">
								<span class="text_slice">新增提额</span>
							</a>
						</li>
						<li>
							<a href="../admin/heighten/heighten-info-list.action" target="frmright">
								<span class="text_slice">提额管理</span>
							</a>
						</li>
						 
				</ul>
				-->
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>财务管理
				</div>
				<ul class="categoryitems">
					<li>
							<a href="../admin/wealth/deal-info-list.action" target="frmright">
								<span class="text_slice">财务管理</span>
							</a>
						</li>
						 
						 
				</ul>
				
			 <div class="menuheader expandable">
					<span class="normal_icon2"></span>数据分析
				</div>
				<ul class="categoryitems">
				 
				 		<li>
							<a href="../admin/fx/company_h_line.jsp" target="frmright">
								<span class="text_slice">按日走势图</span>
							</a>
						</li>  
						<li>
							<a href="../admin/fx/company_m_line.jsp" target="frmright">
								<span class="text_slice">按月走势图</span>
							</a>
						</li>   
						
				 
				</ul>
				
				
				<div class="menuheader expandable">
					<span class="normal_icon2"></span>系统管理
				</div>
				<ul class="categoryitems">
				 
				 		<li>
							<a href="../admin/sys/data-inport.jsp" target="frmright">
								<span class="text_slice">数据导入</span>
							</a>
						</li>  

			 
						<li>
							<a href="../admin/info/update-pwd!show.action" target="frmright">
								<span class="text_slice">密码修改</span>
							</a>
						</li>
						
				 
				</ul>
				
			</div>
		</div>
	</body>
</html>