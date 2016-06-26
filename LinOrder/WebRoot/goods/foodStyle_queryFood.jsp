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
	<script type="text/javascript" src="jscript/goods/foodStyle_verify.js"></script>
	<script type="text/javascript" src="jscript/goods/style_update.js"></script>
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
					<h2 class="page-title">菜系管理</h2>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="<%=basePath %>goods/foodStyleShowAction_show.action">菜系信息</a>
							</li>
							<li role="presentation"><a href="<%=basePath %>goods/foodStyle_add.jsp">菜系添加</a>
							</li>
							<li role="presentation" class="active"><a href="#">菜系修改</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="<%=basePath %>goods/foodStyleAction_updateFoodStyle"
					method="post" enctype="multipart/form-data">
						<s:hidden name="foodStyle.id" />
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" id="gro-foodStyleId">
								<label for="foodStyleId" class="col-xs-2 control-label">菜&nbsp;系&nbsp;号：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="foodStyleId" value="<s:property value='#request.foodStyle.foodStyleId'/>"
										placeholder="输入菜系号">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-foodStyleId">
									<i class="icon-info-sign"></i>
										 只能输入数字
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-stylepName">
								<label for="stylepName" class="control-label">菜&nbsp;系&nbsp;名：</label>
								<div class="controls">
									<p class="span6 m-wrap" style="font-size:18px; margin-top:6px; margin-left:4px;"><s:property value='#request.foodStyle.styleName'/></p>
									<button type="button"
										class="btn blue button-next" id="btn-edit" >修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
									<button type="button"
										class="btn blue button-next" id="btn-noedit" style="display:none;">不修改
										<i class="m-icon-swapright m-icon-white"></i>
									</button>
								</div>
							</div>
							<div class="control-group" id="gro-styleName" style="display:none;">
								<label for="styleName" class="control-label">菜&nbsp;系&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="styleName" value="<s:property value='#request.foodStyle.styleName'/>"
										placeholder="输入菜系名">
								</div>
								<div class="controls" >
									<div class="alert alert-info" id="alert-styleName">
									<i class="icon-info-sign"></i>
										由字母、文字线组成
						     		</div>
					     		</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="button"
										class="btn red button-next" id="btn-add" onclick="checkUpdate(this.form)">更新
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
