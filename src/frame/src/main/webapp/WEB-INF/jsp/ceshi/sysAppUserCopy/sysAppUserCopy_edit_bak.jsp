<%@page import="com.fh.util.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	
	function delFile(IP,USER_ID){
		 if(confirm("确定要删除文件吗？")){
			var url = "sysAppUserCopy/delFile.do?IP="+IP+"&USER_ID="+USER_ID+"&guid="+new Date().getTime();
			$.get(url,function(data){
				if(data=="success"){
					document.location.reload();
				}
			});
		} 
	}
	
	//保存
	function save(){
			if($("#USERNAME").val()==""){
				$("#USERNAME").tips({
					side:3,
		            msg:'请输入用户名',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#USERNAME").focus();
				return false;
			}
			if($("#PASSWORD").val()==""){
				$("#PASSWORD").tips({
					side:3,
		            msg:'请输入密码',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PASSWORD").focus();
				return false;
			}
			
			if($("input[name=RIGHTS]:checked").length==0){
				$("#RIGHTS").tips({
					side:3,
		            msg:'请输入权限',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}
			if($("#ROLE_ID").val()==""){
				$("#ROLE_ID").tips({
					side:3,
		            msg:'请输入角色',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ROLE_ID").focus();
				return false;
			}
			
			if($("input[name=LAST_LOGIN]:checked").length==0){
				$("#LAST_LOGIN").tips({
					side:3,
		            msg:'请输入最后登录时间',
		            bg:'#AE81FF',
		            time:2
		        });
				return false;
			}
			if($("#STATUS").val()==""){
				$("#STATUS").tips({
					side:3,
		            msg:'请输入dsds',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#STATUS").focus();
				return false;
			}
			if($("#IP").val()==""){
				$("#IP").tips({
					side:3,
		            msg:'请选择文件',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#IP").focus();
				return false;
			}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="sysAppUserCopy/${msg}.do" name="Form" id="Form" method="post"  class="form-horizontal" enctype="multipart/form-data">
		<div id="zhongxin"  style="margin-top: 20px;">
			
			<input type="hidden" name="USER_ID" id="USER_ID" value="${pd.USER_ID}"/>
		  	<div class="control-group">
				<label class="control-label" >用户名 :</label>
				<div class="controls" >
			 		<input type="text" name="USERNAME" id="USERNAME" value="${pd.USERNAME}"  placeholder="这里输入用户名" title="用户名"/>
				</div>
			</div>
		  	<div class="control-group">
				<label class="control-label" >密码 :</label>
				<div class="controls" >
			 		<input type="text" name="PASSWORD" id="PASSWORD" value="${pd.PASSWORD}"  placeholder="这里输入密码" title="密码"/>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" >权限 :</label>
				<div class="controls" id="RIGHTS">
			 	<c:choose>
					<c:when test="${not empty RIGHTS_list}">
						<c:forEach items="${ RIGHTS_list }" var="var" >
					<label class="checkbox-inline" >
						<input name="RIGHTS"  type="radio" value="${var.ID}" <c:if test="${var.ID == pd.RIGHTS}">checked</c:if> >
						<span class="lbl">${var.NAME}</span>
					</label>
						</c:forEach>
					</c:when>
				</c:choose>
				</div>
			</div>
		
			<div class="control-group">
				<label class="control-label" >角色 :</label>
				<div class="controls">
					<select class="chzn-select" name="ROLE_ID" id="ROLE_ID" data-placeholder="请选择" style="vertical-align:top;width: 120px;">
					<c:choose>
						<c:when test="${not empty ROLE_ID_list}">
							<c:forEach items="${ ROLE_ID_list }" var="var" >
								<option value="${var.ID}" <c:if test="${var.ID == pd.ROLE_ID}">selected</c:if> >${var.NAME}</option>
							</c:forEach>
						</c:when>
					</c:choose>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">最后登录时间 :</label>
				<div class="controls" id="LAST_LOGIN">
			 	<c:choose>
					<c:when test="${not empty LAST_LOGIN_list}">
						<c:forEach items="${ LAST_LOGIN_list }" var="var" >
					<label class="checkbox-inline" >
						<input name="LAST_LOGIN"  type="checkbox" value="${var.ID}" 
 						<c:forTokens items="${pd.LAST_LOGIN}" delims="," var="LAST_LOGIN">
								<c:if test="${var.ID == LAST_LOGIN}">checked</c:if> 
						</c:forTokens>
						>
						<span class="lbl">${var.NAME}</span>
					</label>
						</c:forEach>
					</c:when>
				</c:choose>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" >名字 :</label>
				<div class="controls">
				<input type="file" name="NAME" id="NAME"   placeholder="这里输入NAME" title="NAME"/>
				<!-- 
					<c:choose>
			 			<c:when test="${pd.NAME == '' || pd.NAME == null }">
			 				<input type="file" name="NAME" id="NAME"   placeholder="这里输入NAME" title="NAME"/>
			 			</c:when>
			 			<c:otherwise>
			 			<a href="<%=basePath+Const.FILEPATHFILE%>${pd.NAME}" target="_blank">${pd.NAME}</a>
						<input type="button" class="btn btn-mini btn-danger" value="删除" onclick="delFile('${pd.NAME}','${pd.USER_ID }');" />
						<input type="hidden" name="IP_hidden" id="IP_hidden" value="${pd.NAME }"/>
			 			</c:otherwise>
			 		</c:choose>
			 	 -->	
				</div>
			</div>
		  	<div class="control-group">
				<label class="control-label" >ip1 :</label>
				<div class="controls" >
				<input type="file" name="IP" id="IP"   placeholder="这里输入ip1" title="ip1"/>
				<!--  
			 		<c:choose>
			 			<c:when test="${pd.IP == '' || pd.IP == null }">
			 				<input type="file" name="IP" id="IP"   placeholder="这里输入ip1" title="ip1"/>
			 			</c:when>
			 			<c:otherwise>
			 			<a href="<%=basePath+Const.FILEPATHFILE%>${pd.IP}" target="_blank">${pd.IP}</a>
						<input type="button" class="btn btn-mini btn-danger" value="删除" onclick="delFile('${pd.IP}','${pd.USER_ID }');" />
						<input type="hidden" name="IP_hidden" id="IP_hidden" value="${pd.IP }"/>
			 			</c:otherwise>
			 		</c:choose>
			 		 -->	
				</div>
			</div>
		  	<div class="control-group">
				<label class="control-label" >dsds :</label>
				<div class="controls" >
 
			 		<input type="text" name="STATUS" id="STATUS" value="${pd.STATUS}"  placeholder="这里输入dsds" title="dsds"/>
				</div>
			</div>
			<div class="form-actions">
				<a class="btn  btn-mini btn-primary" onclick="save();"><i class="icon-ok"></i>保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();"><i class="icon-undo"></i>取消</a>
 
			</div>
		</div>
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
			$('#IP,#NAME').ace_file_input({
				no_file:'请选择文件 ...',
				btn_choose:'选择',
				btn_change:'更改',
				droppable:false,
				onchange:null,
				thumbnail:false //| true | large
				//whitelist:'gif|png|jpg|jpeg',
				//blacklist:'gif|png|jpg|jpeg'
				//onchange:''
				//
			});
		});
		
		</script>
</body>
</html>