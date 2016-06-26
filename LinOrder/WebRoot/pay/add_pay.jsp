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
					<h2 class="page-title">订单管理</h2>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="admin_main.jsp">首页</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a>订单管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="<%=basePath %>order/orderShowAction_show.action">订单处理</a>
								<i class="icon-angle-right"></i>
							</li>
						</ul>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="<%=basePath %>order/orderShowAction_show.action">订单信息</a>
							</li>
							<li role="presentation" class="active"><a href="#">订单添加</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="<%=basePath %>order/orderAction_addOrder"
					method="post" enctype="multipart/form-data">
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" id="gro-orderName">
								<label for="orderName" class="control-label">桌&nbsp;号&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="orderName" value=""
										placeholder="输入桌号名">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit"
										class="btn red button-next" id="btn-add" >提交添加 
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
