<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		<link rel="stylesheet" type="text/css" id="skin" />
		<!--框架必需end-->
		<style type="text/css">
			a {
				behavior: url(../js/method/focus.htc)
			}
		
			.categoryitems span {
				width: 160px;
			}
		</style>
		<script type="text/javascript">
			$(function() {
				var box4Idx = 0;
				var box4LiIdx;
				var box4Index = jQuery.jCookie('box4Index');
				var box4LiIndex = jQuery.jCookie('box4LiIndex');
				if (box4Index != false) {
					box4Idx = parseInt(box4Index);
				}
				if (box4LiIndex != false) {
					box4LiIdx = parseInt(box4LiIndex);
				}
				$(".box4").not(':eq(' + box4Idx + ')').hide();
				$(".box4 li a").filter(':eq(' + box4LiIdx + ')').addClass("current");
		
				$(".box4 li a").each(function(i) {
					$(this).click(function() {
						$(".box4 li a").removeClass("current");
						$(this).addClass("current");
						jQuery.jCookie('box4LiIndex', i.toString());
					});
				}); 
		
				//打开内页时出现进度条
				//$(".box4 a[target*=frmright]").click(function() {
				//	showProgressBar();
				//});
		
			});
			function showTab(num) {
				$(".box4").hide(500);
				$(".box4").filter(':eq(' + num + ')').show(500);
				jQuery.jCookie('box4Index', num.toString());
			}
		</script>
	</head>
	
	<body leftFrame="true">
		<div id="scrollContent">
			<div style="padding: 5px;">

				<div class="box4" panelTitle="系统首页">
					<ul>
						<li>
						<a href="../member/info/welcome.action" target="frmright">
							<span class="text_slice">返回首页</span>
						</a>
					</li>
					</ul>
				</div>
			

				<div class="box4" panelTitle="会员信息">
					<ul>
						<li>
							<a href="../member/pwd-two-validation.action?path=5" target="frmright">
								<span class="text_slice">会员升级</span>
							</a>
						</li>

					<li>
						<a href="../member/pwd-two-validation.action?path=100" target="frmright">
							<span class="text_slice">资料修改</span>
						</a>
					</li>
					<li>
						<a href="../member/info/update-pwd!show.action" target="frmright">
							<span class="text_slice">密码修改</span>
						</a>
					</li>
					</ul>
				</div>
				<div class="box4" panelTitle="购物中心">
					<ul>
						<li>
						<a href="../member/info/order-list.action" target="frmright">
							<span class="text_slice">订单情况</span>
						</a>
						</li>
						<li>
							
							<a href="../member/info/product-list.action" target="frmright">
								<span class="text_slice">产品列表</span>
							</a>
						</li>
					</ul>
				</div>
				
				<div class="box4" panelTitle="信息管理">
					<ul>
						<li>
						<a href="../member/info/notice-list.action" target="frmright">
							<span class="text_slice">系统公告</span>
						</a>
					</li>
					
					
					<li>
						<a href="../member/pwd-two-validation.action?path=109" target="frmright">
							<span class="text_slice">提交留言</span>
						</a>
					</li>
					<li>
						<a href="../member/pwd-two-validation.action?path=110" target="frmright">
							<span class="text_slice">留言列表</span>
						</a>
					</li>
					
					</ul>
				</div>

				<div class="box4" panelTitle="业务管理">
					<ul>
				
						<li>
							<a href="../member/member/tu-recommend.action" target="frmright">
								<span class="text_slice">我的直接推荐</span>
							</a>
						</li>
						<li>
							<a href="../member/pwd-two-validation.action?path=20" target="frmright">
								<span class="text_slice">申请加盟店</span>
							</a>
						</li>
						<li>
							<a href="../member/pwd-two-validation.action?path=21" target="frmright">
								<span class="text_slice">申请加盟店列表</span>
							</a>
						</li>
					
					
					</ul>
				</div>

				<div class="box4" panelTitle="财务管理">
					<ul>
				  
					<li>
						<a href="../member/pwd-two-validation.action?path=6" target="frmright">
							<span class="text_slice">奖金币提现</span>
						</a>
					</li>
					<li>
						<a href="../member/pwd-two-validation.action?path=7" target="frmright">
							<span class="text_slice">未处理提现</span>
						</a>
					</li>
					
					<li>
						<a href="../member/pwd-two-validation.action?path=8" target="frmright">
							<span class="text_slice">已处理提现</span>
						</a>
					</li>
					<li>
						<a href="../member/pwd-two-validation.action?path=9" target="frmright">
							<span class="text_slice">奖金日汇总</span>
						</a>
					</li>
							
					<li>
						<a href="../member/pwd-two-validation.action?path=10" target="frmright">
							<span class="text_slice">奖金币转账</span>
						</a>
					</li>
						
						<li>
							<a href="../member/pwd-two-validation.action?path=14" target="frmright">
								<span class="text_slice">奖金币转报单币</span>
							</a>
						</li>
				
					<li>
						<a href="../member/pwd-two-validation.action?path=11" target="frmright">
							<span class="text_slice">奖金币明细</span>
						</a>
					</li>
					
					
					
						<li>
							<a href="../member/pwd-two-validation.action?path=16" target="frmright">
								<span class="text_slice">报单币明细</span>
							</a>
						</li>
					
						
						<li>
							<a href="../member/pwd-two-validation.action?path=15" target="frmright">
								<span class="text_slice">报单币转账</span>
							</a>
						</li>
						
					
					
					</ul>
				</div>
				

				<div class="box4" panelTitle="报单管理">
					<ul>	
					<li>
							<a href="../member/pwd-two-validation.action?path=12" target="frmright">
								<span class="text_slice">汇款登记</span>
							</a>
						</li>
						<li>
							<a href="../member/pwd-two-validation.action?path=13" target="frmright">
								<span class="text_slice">汇款列表</span>
							</a>
						</li>
						<li>
							<a href="../member/center/person-add!show.action" target="frmright">
								<span class="text_slice">注册会员</span>
							</a>
						</li>
	
						<li>
							<a href="../member/pwd-two-validation.action?path=1" target="frmright">
								<span class="text_slice">未开通会员</span>
							</a>
						</li>
						<li>
							<a href="../member/pwd-two-validation.action?path=2" target="frmright">
								<span class="text_slice">已开通会员</span>
							</a>
						</li>
	
						
					</ul>
				</div>
			

				
				<div class="box4" panelTitle="系统退出">
					<ul>
						<li>
						<a href="../member/info/welcome.action" target="frmright">
							<span class="text_slice">返回首页</span>
						</a>
					</li>
					</ul>
				</div>

				

			</div>
		</div>
	</body>
</html>