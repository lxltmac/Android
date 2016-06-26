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
	<script type="text/javascript" src="jscript/app.js"></script>
	<script type="text/javascript" src="jscript/menu.js"></script>
	<script type="text/javascript" src="jscript/verify.js"></script>
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
					<h2 class="page-title">个人用户</h2>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="staffAction_queryNameStaff.action?name=<%=session.getAttribute("name")%>">个人用户信息</a>
							</li>
							<li role="presentation" class="active"><a href="#">个人用户修改</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="staffAction_updateStaff" namespace="/" method="post" enctype="multipart/form-data">
						<s:hidden name="staff.id" />
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" id="gro-name">
								<label for="name" class="control-label">用&nbsp;户&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="name" value="<s:property value='#request.staff.name'/>"
										placeholder="输入用户名" >
								</div>
								<div class="controls" id="gro-name">
									<div class="alert alert-info" id="alert-name" style="display:none">
									<i class="icon-info-sign"></i>
										4-20位字符，由字母、数字、下划线组成
						     		</div>
					     		</div>
							</div>
							<div class="control-group">
								<label for="sex" class="control-label">性&nbsp;&nbsp;&nbsp;别：</label>
								<div class="controls" style="padding-left:24px">
									<label class="radio">
										<input type="radio" name="sex" value="1" <s:if test='#request.staff.sex == "男"'>checked</s:if> >男
									</label>
									<label class="radio">
										<input type="radio" name="sex" value="2" <s:if test='#request.staff.sex == "女"'>checked</s:if> style="margin-left:1px;">女
									</label>
								</div>
							</div>
							<div class="control-group" >
								<label for="duty" class="col-xs-2 control-label">职&nbsp;&nbsp;&nbsp;位：</label>
								<div class="controls">
									<s:select list="{'经理','副经理','分店管理员'}" name="staff.duty"
									style="width:446px;height:34px" />
								</div>
							</div>
							<div class="control-group" id="gro-email">
								<label for="email" class="col-xs-2 control-label">邮&nbsp;&nbsp;&nbsp;箱：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="email" value="<s:property value='#request.staff.email'/>"
										placeholder="输入电子邮箱">
								</div>
								<div class="controls" id="gro-email">
									<div class="alert alert-info" id="alert-email" style="display:none">
									<i class="icon-info-sign"></i>
										请输入有效的邮箱
						     		</div>
					     		</div>
							</div>
								<div class="control-group" id="gro-province">
								<label for="city" class="col-xs-2 control-label">地&nbsp;&nbsp;&nbsp;址：</label>
								<div class="controls">
									<select id="proSel" class="form-control" name="province" >
										<option id="0" disabled selected="selected">请选择：</option>
										<option value="<s:property value="#request.staff.city.province.provinceID" />" selected="selected"><s:property value="#request.staff.city.province.province" /></option>
										<s:iterator value="#request.provinces">
											<option value="<s:property value="provinceID" />"><s:property value="province" /></option>
										</s:iterator>
									</select>
									<select id="citySel" class="form-control" name="city">			
										<option value="0" disabled selected="selected">请选择：</option>
										<option value="<s:property value="#request.staff.city.cityID"/>" selected="selected"><s:property value="#request.staff.city.city" /></option>
											<s:iterator value="#request.citys">
												<option value="<s:property value="cityID" />"><s:property value="city" /></option>
											</s:iterator>
									</select>
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-province" style="display:none">
									<i class="icon-info-sign"></i>
										请输入有效的地址
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-phone">
								<label for="phone" class="col-xs-2 control-label">电&nbsp;&nbsp;&nbsp;话：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="phone" value="<s:property value='#request.staff.phone'/>"
										placeholder="输入电话">
								</div>
								<div class="controls" id="gro-phone">
									<div class="alert alert-info" id="alert-phone" style="display:none">
									<i class="icon-info-sign"></i>
										请输入有效的电话号码
						     		</div>
					     		</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="button"
										class="btn red button-next" onclick="checkUpdate(this.form)">更新 
										<i class="m-icon-swapright m-icon-white"></i>
										</button>
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
