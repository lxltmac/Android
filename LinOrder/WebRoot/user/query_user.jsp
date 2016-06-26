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
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>系统后台界面</title>

<!-- Bootstrap -->
	<script type="text/javascript" src="jscript/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="jscript/app.js"></script>
	<script type="text/javascript" src="jscript/menu.js"></script>
	<script type="text/javascript" src="jscript/verify.js"></script>
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
					<h2 class="page-title">前台用户</h2>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="admin_main.jsp">首页</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a>用户管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="<%=basePath %>user/userShowAction_show.action">前台用户管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="<%=basePath %>user/userAction_queryUser.action?id=<s:property value="id"/>">前台用户修改</a></li>
						</ul>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="<%=basePath %>user/userShowAction_show.action">前台用户信息</a>
							</li>
							<li role="presentation"><a href="<%=basePath %>user/add_user.jsp">前台用户添加</a>
							</li>
							<li role="presentation" class="active"><a href="#">前台用户修改</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="<%=basePath %>user/userAction_updateUser"
					method="post" enctype="multipart/form-data">
						<s:hidden name="user.id" />
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" >
								<label for="username" class="control-label">用&nbsp;户&nbsp;名：</label>
								<div class="controls">
									<p class="span6 m-wrap" style="font-size:18px; margin-top:6px;margin-left:4px;"><s:property value='#request.user.username'/></p>
									<button type="button"
										class="btn blue button-next" id="btn-userEdit" >修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
									<button type="button"
										class="btn blue button-next" id="btn-noUserEdit" style="display:none;">不修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
								</div>
							</div>
							<div class="control-group" id="gro-username" style="display:none;">
								<label for="username" class="control-label">用&nbsp;户&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="username" value="<s:property value='#request.user.username'/>"
										placeholder="输入用户名">
								</div>
								<div class="controls" >
									<div class="alert alert-info" id="alert-username">
									<i class="icon-info-sign"></i>
										4-20位字符，由字母、数字、下划线组成
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-password">
								<label for="password" class="col-xs-2 control-label">密&nbsp;&nbsp;&nbsp;码：</label>
								<div class="controls">
									<input type="password" class="span6 m-wrap" name="password" value="<s:property value='#request.user.password'/>"
										placeholder="输入密码">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-password">
									<i class="icon-info-sign"></i>
										 6-20位字符，建议由字母、数字和符号两种以上组合
						     		</div>
					     		</div>
							</div>
							<div class="control-group">
								<label for="sex" class="control-label">性&nbsp;&nbsp;&nbsp;别：</label>
								<div class="controls" style="padding-left:24px">
									<label class="radio">
										<input type="radio" name="sex" value="1" <s:if test='#request.user.sex == "男"'> checked</s:if>>男
									</label>
									<label class="radio">
										<input type="radio" name="sex" value="2" <s:if test='#request.user.sex == "女"'> checked</s:if> style="margin-left:1px;">女
									</label>
								</div>
							</div>
							<div class="control-group" id="gro-phone">
								<label for="phone" class="col-xs-2 control-label">电&nbsp;&nbsp;&nbsp;话：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="phone" value="<s:property value='#request.user.phone'/>"
										placeholder="输入电话">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-phone">
									<i class="icon-info-sign"></i>
										请输入有效的电话号码
						     		</div>
					     		</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="button"
										class="btn red button-next" id="btn-add" onclick="checkUpdateUser(this.form)">更新
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
