<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<head>
<meta charset="utf-8" />
<base href="<%=basePath%>"><!-- jsp文件头和头部 -->
	<%@ include file="../system/admin/reportTop.jsp"%> 
<script src="plugins/reportTable/common.js"></script>
<script src="plugins/reportTable/report.js"></script>

</head>
<body >
<body class="no-skin">
	<div class="main-container" id="main-container" >
			<table>
			<tr>
					<td align="right">起止时间：</td>
					<td style="width: 60%"><input type="text" id="startDate" name="startDate" onchange="reloadJqGrid()"
						data-date-format="yyyymmdd" /> <span class="input-group-addon">
							<i class="fa fa-exchange"></i>
					</span> <input type="text" class="input-sm form-control" id="endDate" onchange="reloadJqGrid()"
						name="endDate" data-date-format="yyyymmdd" /></td>
					<td align="right">手机号码：</td>
					<td><input type="text" id="phone" name="phone" onchange="reloadJqGrid()"></td>
				</tr>
				<tr>
					<td width="10%;" align="right">角色：</td>
					<td>
			
					<select class="chzn-select" name="roleId" id="roleId" data-placeholder="请选择" onchange="reloadJqGrid()">
							<option value="2">普通人员</option>
							<option value="1">管理员</option>
					  	</select>
					</td>
				</tr>
			
			</table>
			<div align="right">
				<a href="#" onclick="exportToExcel('queryReport',['startDate','endDate','phone','roleId'],'用户查询')"><i class="menu-icon fa fa-download ">导出</i></a>
				</div>

					<table id="grid-table"></table>
					<div id="grid-pager"></div>
		</div>
		

		
</body>
<script type="text/javascript">
$(top.hangge());


</script>
</html>

