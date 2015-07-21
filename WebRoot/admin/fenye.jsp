<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	.fenye{color:#0866BD;font-weight:bolder;font-size:12px;}
</style>

<div style="height: 35px;">

	<div style="margin-top:10px;width:350px;float:left"> 
				当前页:第<span class="fenye">${view.currentPage}</span>页 |
				总记录数:<span class="fenye">${view.recordTotal}</span>条 | 
				每页显示:<span class="fenye">${view.recorderPage}</span>条 |
				总页数:<span class="fenye">${view.totalPage}</span>页
	</div>
	
	<div class="float_right padding5 paging">
		<div class="float_left padding_top4">
		
			<span>
				<a href="javascript:topage('1')">首页</a>
			</span>
			
<c:forEach begin="${view.startIndex}" end="${view.endIndex}" var="p">
	<c:if test="${view.currentPage==p}">
			<span class="paging_current"><a>${p}</a></span>
	</c:if>
	<c:if test="${view.currentPage!=p}">
			<span><a href="javascript:topage('${p}')">${p}</a></span>
	</c:if>
</c:forEach>
			
			<span>
				<a href="javascript:topage('${view.totalPage}')">尾页</a>
			</span>
		</div>
		
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>