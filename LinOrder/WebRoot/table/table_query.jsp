<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>系统后台界面</title>

<!-- Bootstrap -->
	<script type="text/javascript" src="jscript/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="jscript/app.js"></script>
	<script type="text/javascript" src="jscript/menu.js"></script>
	<script type="text/javascript" src="jscript/table/table_verify.js"></script>
	<script type="text/javascript" src="jscript/table/update_table.js"></script>
	<script type="text/javascript" src="jscript/goods/update.js"></script>
	<script type="text/javascript" src="jscript/common.js"></script>
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<script type="text/javascript" src="jscript/bootstrap-fileupload.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-metro.css"/>
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="css/animation.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-fileupload.css"/>
</head>
<body class="page-header-fixed">
	<jsp:include page="../admin_top.jsp" flush="true" />
	<jsp:include page="../admin_left.jsp" flush="true" />
	
	<div class="page-content">
		<div class="container-fluid">
					<h2 class="page-title">桌号管理</h2>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="<%=basePath %>table/tableShowAction_show.action">桌号信息</a>
							</li>
							<li role="presentation"><a href="<%=basePath %>table/table_add.jsp">桌号添加</a>
							</li>
							<li role="presentation" class="active"><a href="#">桌号修改</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="<%=basePath %>table/tableAction_updateTable"
					method="post" enctype="multipart/form-data">
						<s:hidden name="table.id" />
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" >
								<label for="tableName" class="control-label">桌&nbsp;&nbsp;号&nbsp;&nbsp;名：</label>
								<div class="controls">
									<p class="span6 m-wrap" style="font-size:18px; margin-top:6px;margin-left:4px;"><s:property value='#request.table.tableName'/></p>
									<button type="button"
										class="btn blue button-next" id="btn-tableEdit" >修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
									<button type="button"
										class="btn blue button-next" id="btn-notableEdit" style="display:none;">不修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
								</div>
							</div>
							<div class="control-group" id="gro-tableName" style="display:none;">
								<label for="tableName" class="control-label">桌&nbsp;&nbsp;号&nbsp;&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="tableName" value="<s:property value='#request.table.tableName'/>"
										placeholder="输入桌号名">
								</div>
								<div class="controls" >
									<div class="alert alert-info" id="alert-tableName">
									<i class="icon-info-sign"></i>
										由字母、数字组成，不能多于6位字符
						     		</div>
					     		</div>
							</div>
							<div class="control-group" >
								<label for="tableName" class="control-label">桌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
								<div class="controls">
									<p class="span6 m-wrap" style="font-size:18px; margin-top:6px;margin-left:4px;"><s:property value='#request.table.tableNum'/></p>
									<button type="button"
										class="btn blue button-next" id="btn-tableNumEdit" >修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
									<button type="button"
										class="btn blue button-next" id="btn-notableNumEdit" style="display:none;">不修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
								</div>
							</div>
							<div class="control-group" id="gro-tableNum" style="display:none;">
								<label for="tableNum" class="col-xs-2 control-label">桌&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="tableNum" value="<s:property value='#request.table.tableNum'/>"
										placeholder="输入桌号">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-tableNum">
									<i class="icon-info-sign"></i>
										 4位字符，建议由大写字母、数字两种以上组合
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-tableInfo">
								<label for="tableInfo" class="col-xs-2 control-label">桌&nbsp;位&nbsp;人&nbsp;数：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="tableInfo" value="<s:property value='#request.table.tableInfo'/>"
										placeholder="输入桌位人数">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-tableInfo">
									<i class="icon-info-sign"></i>
										只能输入数字
						     		</div>
					     		</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="button"
										class="btn red button-next" id="btn-add" onclick="checkUpdateTable(this.form)">更新
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
								</div>
							</div>
						</div>
					</form>
					</div>
				</div>
			</div>
	<jsp:include page="../admin_footer.jsp" flush="true" />
</body>
</html>
