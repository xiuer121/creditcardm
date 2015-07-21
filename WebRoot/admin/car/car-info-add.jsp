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
		<script type="text/javascript" src="../../js/ajaxfileupload.js"></script>
		<!--文本编辑器start-->
		<script type="text/javascript" src="../../js/xheditor/xheditor-zh-cn.min.js"></script>
		<script type=text/javascript>
			$(document).ready(function(){
				//设置编辑器
				$("#description").xheditor(
					true, { tools: "full", skin: "default" }
				);
 
			});
			
			
			 function fileUploadService(){
			    	//开始上传文件时显示一个图片,文件上传完成将图片隐藏  
			    	//执行上传文件操作的函数  
			    	var carId = $("#carId").val();				
			    	$.ajaxFileUpload({
			    		//处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
			    		url : './image-upload.action?id='+carId,
			    		secureuri : false, //是否启用安全提交,默认为false   
			    		fileElementId : 'imgPic', //文件选择框的id属性  
			    		dataType : 'text', //服务器返回的格式,可以是json或xml等  
			    		success : function(data, status) { //服务器响应成功时的处理函数   
			    			data = data.replace(/<pre.*?>/g, ''); //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀  
			    			data = data.replace(/<PRE.*?>/g, '');
			    			data = data.replace("<PRE>", '');
			    			data = data.replace("</PRE>", '');
			    			data = data.replace("<pre>", '');
			    			data = data.replace("</pre>", ''); //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]    
			    		
			    			var json=$.parseJSON(data);
			    			var str = json.message.split("`");	 
			    			if (str[0] == 1) { //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述) 
			    				 console.log(str[1]);
			    			  
			    					$("#cb_msimg").append('<div class="imgD" id="imgD"><img class="cop_img2" src="'+str[1]+'"/>'+ 
			    							'</div>');
			    			} else if (str[0] == 1){
			    				alertMsg('提示信息',str[1],2);
			    				//alert(str[1]);
			    				//$('#result').html(str[1]);
			    			}
			    		},
			    		error : function(data, status, e) { //服务器响应失败时的处理函数  
			    			$('#result').html('图片上传失败，请重试！！');
			    		}
			    	});
			    }
		</script>
		<!--文本编辑器end-->
		<style type="text/css">
			.imgD {
				width: 120px;
				height: 120px;
				float: left;
				padding-left: 4px;
			}
			.cop_img2{
				width: 120px;
				height: 120px;
			}
		</style>
	
		
	</head>
	
	<body>
		<div id="scrollContent">
		
			<div class="box2" panelTitle="车辆添加" roller="true">
	
<s:form id="commitForm" action="car-add!add" method="post" enctype="multipart/form-data">
					
						<s:hidden name="id" id="carId"/>
						<table class="tableStyle" formMode="true">
					
							<tr>
								<th colspan="4">车辆添加</th>
							</tr>

							<tr>
								<td width="10%">车辆名称：</td>
								<td width="40%">
									<s:textfield id="title" name="title" />
								</td>
								
								<td width="10%">车辆类型：</td>
								<td width="40%">
									<s:select list="#{10:'轿车',20:'跑车',30:'SUV',40:'商务车'}" name="carType"  listKey="key" listValue="value" />
								</td>
							</tr> 
							<tr> 
								<td>推荐车型：</td>
								<td> 
								<s:select list="#{10:'是',20:'否'}" name="recState"  listKey="key" listValue="value"/>
								</td>
							
								<td>热门车型：</td>
								<td><s:select list="#{10:'是',20:'否'}" name="hotState"  listKey="key" listValue="value"/></td> 
							</tr>
							<tr> 
								<td>车况：</td>
								<td><s:textfield id="condition" name="condition"/></td>
							
								<td>行程：</td>
								<td><s:textfield id="travel" name="travel"/>
								
								
								</td> 
							</tr>
							
							<tr> 
								<td>排量：</td>
								<td><s:textfield id="discharge" name="discharge"/></td>
							
								<td>变速箱：</td>
								<td><s:textfield id="creabox" name="creabox"/></td> 
							</tr>
							 
							<tr> 
								<td>驱动模式：</td>
								<td><s:textfield id="driveMode" name="driveMode"/></td>
							
								<td>车辆颜色：</td>
								<td><s:textfield id="color" name="color"/></td> 
							</tr>
							 
							<tr> 
								<td>车辆原用途：</td>
								<td><s:textfield id="used" name="used"/></td>
							
								<td>车辆内色：</td>
								<td><s:textfield id="colorIn" name="colorIn"/></td> 
							</tr>
								 
							<tr> 
								<td>手续：</td>
								<td><s:textfield id="procedures" name="procedures"/></td>
							
								<td>座位数：</td>
								<td><s:textfield id="seatNum" name="seatNum"/></td> 
							</tr>
							
								 
							<tr> 
								<td>座椅：</td>
								<td><s:textfield id="chair" name="chair"/></td>
							
								<td>产地：</td>
								<td><s:textfield id="place" name="place"/></td> 
							</tr>
							
							<tr> 
								<td>燃油：</td>
								<td><s:textfield id="fuel" name="fuel"/></td>
							
								<td>品牌：</td>
								<td><s:select list="list"  listKey="id" listValue="title" id="brandId" name="brandId"/></td> 
							</tr>
							<tr> 
								<td>特价：</td>
								<td><s:textfield id="price" name="price"/><span style="color: red;">(单位万元)</span></td>
							
								<td>原价：</td>
								<td><s:textfield id="originalPrice" name="originalPrice"/><span style="color: red;">(单位万元)</span></td>
							</tr>
							<tr> 
								<td>限时优惠</td>
								<td><s:select list="#{10:'是',20:'否'}" name="hotState"  listKey="key" listValue="value"/></td>
								<td>优惠天数：</td>
								<td><s:textfield id="xianNum" name="xianNum"/> </td>
								
							</tr>
							<tr> 
								<td>图片：</td>
								<td><s:file id="file" name="file" /></td>  
							</tr>
							<tr> 
								<td>相册：</td>
								<td>	
								<input class="cb_slbtt"  type="file" id="imgPic" name="imgPic" onchange="fileUploadService()"/>
								</td>
								<td colspan="2"><div class="cb_msimg" id ="cb_msimg"></div></td>
							</tr>
							 
							<tr>
								<td>详情：</td>
								<td colspan="3">
									<s:textarea id="description" name="description" cssStyle="width:95%;height:200px;"/>
								</td>
							</tr>
							
						 

							<tr>
								<td colspan="4">
									<div style="color:red;text-align:center">
										<s:actionerror/>
										<s:fielderror/>
									</div>
								</td>
							</tr>

							<tr>
								<td colspan="4">
									<input type="submit" value=" 提 交 "/>
									<input type="reset" value=" 重 置 "/>
								</td>
							</tr>
						</table>
					
				</s:form>
				
				
			</div>
		</div>
	<!--代码高亮end-->
	</body>
</html>