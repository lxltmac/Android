<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>系统后台界面</title>

<!-- Bootstrap -->
	<script type="text/javascript" src="jscript/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="jscript/jquery.blockui.min.js"></script>
	<script type="text/javascript" src="jscript/app.js"></script>
	<script type="text/javascript" src="jscript/menu.js"></script>
	<script type="text/javascript" src="jscript/common.js"></script>
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/style-metro.css">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="css/animation.css"/>
</head>

<body class="page-header-fixed">
	<s:action name="staffAction_initAddUser" namespace="/"></s:action>
	
	<jsp:include page="admin_top.jsp" flush="true" />
	<jsp:include page="admin_left.jsp" flush="true" />
	<div class="page-content">
		<div class="container-fluid">
					<h2 class="page-title">后台用户</h2>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation" class="active"><a href="#">个人用户信息</a>
							</li>
							<li role="presentation"><a href="staffAction_queryNameStaffSelf.action?name=<%=session.getAttribute("name")%>">个人信息修改</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="staffAction_updateStaff" namespace="/" method="post" enctype="multipart/form-data">
						<div class="portlet box blue" id="form_wizard_1">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i> 用户个人信息
								</div>
								<div class="tools hidden-phone">
									<a href="javascript:;" class="collapse"></a>
									<a href="staffAction_queryNameStaffSelf.action?name=<%=session.getAttribute("name")%>" data-toggle="modal" class="config"></a>
									<a onclick="javascript:;" class="reload"></a>
									<a href="javascript:;" class="remove"></a>
							    </div>
							</div>
							<div class="portlet-body form">
								<s:hidden name="staff.id" />
								<div class="col-xs-7 col-xs-offset-2" style="margin-left:-60px;">
									<div class="control-group" id="gro-name">
										<label for="name" class="control-label">用&nbsp;户&nbsp;名：</label>
										<div class="controls">
											<p  class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:4px;"><s:property value='#request.staff.name'/></p>
										</div>
									</div>
									<div class="control-group">
										<label for="sex" class="control-label">性&nbsp;&nbsp;&nbsp;别：</label>
										<div class="controls" style="padding-left:24px">
											<p  class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:-20px;"><s:property value='#request.staff.sex'/></p>
										</div>
									</div>
									<div class="control-group" >
										<label for="duty" class="col-xs-2 control-label">职&nbsp;&nbsp;&nbsp;位：</label>
										<div class="controls">
											<p  class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:4px;"><s:property value='#request.staff.duty'/></p>
										</div>
									</div>
									<div class="control-group" id="gro-email">
										<label for="email" class="col-xs-2 control-label">邮&nbsp;&nbsp;&nbsp;箱：</label>
										<div class="controls">
											<p  class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:4px;"><s:property value='#request.staff.email'/></p>
										</div>
									</div>
										<div class="control-group" id="gro-province">
										<label for="city" class="col-xs-2 control-label">地&nbsp;&nbsp;&nbsp;址：</label>
										<div class="controls">
											<p  class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:4px;"><s:property value='#request.staff.city.province.province'/>省<s:property value='#request.staff.city.city'/></p>
										</div>
									</div>
									<div class="control-group" id="gro-phone">
										<label for="phone" class="col-xs-2 control-label">电&nbsp;&nbsp;&nbsp;话：</label>
										<div class="controls">
											<p  class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:4px;"><s:property value='#request.staff.phone'/></p>
										</div>
									</div>
									<div class="control-group">
										<div class="controls" style="margin-left:120px;">
											<button type="button"
												class="btn red button-next" onclick="checkUpdate(this.form)">保存
												<i class="m-icon-swapright m-icon-white"></i>
												</button>
										</div>
									</div>
								</div>	
							</div>
						</div>						
					</form>
					</div>
				</div>
			</div>
	<jsp:include page="admin_footer.jsp" flush="true" />
</body>
</html>
