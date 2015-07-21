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
		
		<style type="text/css">
			.person {
				width: 115px;
				height: 74px;
				border: 0;
				margin: 0 auto;
			}
			a{
				text-decoration:none;
			}
		</style>
		
	</head>
	
	<body>
		<div id="scrollContent">
			<div class="box2" panelTitle="我的团队" roller="true">	
			
			<table style="text-align:center;width:720px;">
				<tr>
					<td>
						<img src="../../images/person10.jpg" width="60" height="60"/>
					</td>
					<td>
						<img src="../../images/person20.jpg" width="60" height="60"/>
					</td>
					<td>
						<img src="../../images/person30.jpg" width="60" height="60"/>
					</td>
				
					<td>
						<img src="../../images/personKong.jpg" width="60" height="60"/>
					</td>
					<td>
						<img src="../../images/personKong.jpg" width="60" height="60"/>
					</td>
				</tr>
				<tr>
					<td>签约普卡</td>
					<td>签约月卡</td>
					<td>疗程卡</td>
					<td>未激活</td>
					<td>空点位</td>
				</tr>
			</table>
				
			<s:form method="post">
				<div>
						<table class="queryTable">
							<tr>
								<td>用户名</td>
								<td><s:textfield name="loginName"/></td>
								<td><s:submit value="查询"/></td>
								<td style="color:red">
									${msg}
								</td>
							</tr>
						</table>
				</div>
			</s:form>	

	
				
			
<div style="width: 834px; height: 600px;" style="clear:left;margin-top:20px;">

			<div style="width:834px;">
			
				<!-- 返回上一层 -->
				<c:if test="${member1.loginName!=self.loginName}">
					<div style="text-align:center;">
						<a href="?loginName=${member1.father.loginName}">
							<strong>返回上一层</strong>
						</a>
					</div>
				</c:if>		
			
				<table border=0 cellspacing=0 cellpadding=0 width="834" style="text-align:center;">
					
					<tr style="height:20px;"></tr>
					
					<tr>
						<td style="width:25%" valign="top">

						</td>
						<td colspan="2">
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member1!=null}">
											<img src="../../images/${member1.ico}" width="60" height="60" />
										</c:if>
										<c:if test="${member1==null}">
											<img src="../../images/personKong.jpg" width="60" height="60" />
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										${member1.loginName}<br/>
										左区:${member1.zuoRen} &nbsp; 右区:${member1.youRen}
									</td>
								</tr>
							</table>	
						</td>
						<td style="width:25%"></td>
					</tr>
					
					<tr>
						<td colspan="4">
							<img src="../../images/s1.gif" width="50%" height="20"/>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" style="width:50%">
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member21!=null}">
											<a href="?loginName=${member21.loginName}"> 
												<img src="../../images/${member21.ico}" width="60" height="60" />
											</a>
										</c:if>
										<c:if test="${member21==null}">
											 
											<a href="person-add!show.action?fatherLoginName=${member1.loginName}&qu=1">
												<img src="../../images/personKong.jpg" width="60" height="60"/>
											</a>
											
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										<c:if test="${member21!=null}">
											<a href="?loginName=${member21.loginName}">${member21.loginName}</a><br/>
											左区:${member21.zuoRen} &nbsp; 右区:${member21.youRen}
										</c:if>
										<c:if test="${member21==null}">
											<a href="person-add!show.action?fatherLoginName=${member1.loginName}">
												点击报单
											</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
						
						<td colspan="2" style="width:50%">
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member22!=null}">
											<a href="?loginName=${member22.loginName}"> 
												<img src="../../images/${member22.ico}" width="60" height="60" />
											</a>
										</c:if> 

										<c:if test="${member22==null}">
											
											<a href="person-add!show.action?fatherLoginName=${member1.loginName}&qu=2">
												<img src="../../images/personKong.jpg" width="60" height="60" />
											</a>
											
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										<c:if test="${member22!=null}">
											<a href="?loginName=${member22.loginName}">${member22.loginName}</a><br/>
											左区:${member22.zuoRen} &nbsp; 右区:${member22.youRen}
										</c:if>
										<c:if test="${member22==null}">
											<a href="person-add!show.action?fatherLoginName=${member1.loginName}">
												点击报单
											</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					
					<tr>
						<td colspan="2" style="width:50%">
							<img src="../../images/s1.gif" width="50%" height="20"/>
						</td>
						<td colspan="2" style="width:50%">
							<img src="../../images/s1.gif" width="50%" height="20"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member31!=null}">
											<a href="?loginName=${member31.loginName}">
												<img src="../../images/${member31.ico}" width="60" height="60"/>
											</a>
										</c:if>
										<c:if test="${member31==null}">
											
											<a href="person-add!show.action?fatherLoginName=${member21.loginName}&qu=1">
												<img src="../../images/personKong.jpg" width="60" height="60" />
											</a>
											
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										<c:if test="${member31!=null}">
											<a href="?loginName=${member31.loginName}">${member31.loginName}</a><br/>
											左区:${member31.zuoRen} &nbsp; 右区:${member31.youRen}
										</c:if>
										<c:if test="${member31==null}">
											<a href="person-add!show.action?fatherLoginName=${member21.loginName}">
												点击报单
											</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member32!=null}">
											<a href="?loginName=${member32.loginName}">
												<img src="../../images/${member32.ico}" width="60" height="60" title="左区至今业绩：${member32.zuoNum}<br/>右区至今业绩：${member32.youNum}<br/>左区未碰业绩：${member32.zuoYu}<br/>右区未碰业绩：${member32.youYu}"/>
											</a>
										</c:if>
										<c:if test="${member32==null}">
											 
											<a href="person-add!show.action?fatherLoginName=${member21.loginName}&qu=2">
												<img src="../../images/personKong.jpg" width="60" height="60" />
											</a>
											 
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										<c:if test="${member32!=null}">
											<a href="?loginName=${member32.loginName}">${member32.loginName}</a><br/>
											左区:${member32.zuoRen} &nbsp; 右区:${member32.youRen}
										</c:if>
										<c:if test="${member32==null}">
											<a href="person-add!show.action?fatherLoginName=${member21.loginName}">
												点击报单
											</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member33!=null}">
											<a href="?loginName=${member33.loginName}"> 
												<img src="../../images/${member33.ico}" width="60" height="60" title="左区至今业绩：${member33.zuoNum}<br/>右区至今业绩：${member33.youNum}<br/>左区未碰业绩：${member33.zuoYu}<br/>右区未碰业绩：${member33.youYu}"/>
											</a>
										</c:if>
										<c:if test="${member33==null}">
											 
											<a href="person-add!show.action?fatherLoginName=${member22.loginName}&qu=1">
												<img src="../../images/personKong.jpg" width="60" height="60" />
											</a>
										 	
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										<c:if test="${member33!=null}">
											<a href="?loginName=${member33.loginName}">${member33.loginName}</a><br/>
											左区:${member33.zuoRen} &nbsp; 右区:${member33.youRen}
										</c:if>
										<c:if test="${member33==null}">
											<a href="person-add!show.action?fatherLoginName=${member22.loginName}">
												点击报单
											</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table class="person">
								<tr>
									<td height=16>
										<c:if test="${member34!=null}">
											<a href="?loginName=${member34.loginName}"> 
												<img src="../../images/${member34.ico}" width="60" height="60" title="左区至今业绩：${member34.zuoNum}<br/>右区至今业绩：${member34.youNum}<br/>左区未碰业绩：${member34.zuoYu}<br/>右区未碰业绩：${member34.youYu}"/>
											</a>
										</c:if>
										<c:if test="${member34==null}">
											 
											<a href="person-add!show.action?fatherLoginName=${member22.loginName}&qu=1">
												<img src="../../images/personKong.jpg" width="60" height="60" />
											</a>
											
										</c:if>
									</td>
								</tr>
								<tr>
									<td height="16">
										<c:if test="${member34!=null}">
											<a href="?loginName=${member34.loginName}">${member34.loginName}</a><br/>
											左区:${member34.zuoRen} &nbsp; 右区:${member34.youRen}
										</c:if>
										<c:if test="${member34==null}">
											<a href="person-add!show.action?fatherLoginName=${member22.loginName}">
												点击报单
											</a>
										</c:if>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					
					<tr style="height:20px;"></tr>
					
				<!-- 下面八个人结束 -->	
					
				</table>
			</div>



</div>	
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>