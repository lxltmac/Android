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
	<script type="text/javascript" src="jscript/goods/food_verify.js"></script>
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
	<s:action name="foodAction_initShowFood" namespace="/goods"></s:action>

	<jsp:include page="../admin_top.jsp" flush="true" />
	<jsp:include page="../admin_left.jsp" flush="true" />
	
	<div class="page-content">
		<div class="container-fluid">
					<h2 class="page-title">菜品管理</h2>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="<%=basePath %>goods/foodShowAction_show.action">菜品信息</a>
							</li>
							<li role="presentation" class="active"><a href="#">菜品添加</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="<%=basePath %>goods/foodAction_addFood"
					method="post" enctype="multipart/form-data">
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" id="gro-foodName">
								<label for="foodName" class="control-label">菜&nbsp;&nbsp;&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="foodName" value=""
										placeholder="输入菜名">
								</div>
								<div class="controls" >
									<div class="alert alert-info" id="alert-foodName">
									<i class="icon-info-sign"></i>
										由字母、文字组成
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-foodStyle">
								<label for="foodStyle" class="col-xs-2 control-label">菜&nbsp;&nbsp;&nbsp;系：</label>
								<div class="controls">
									<select id="foodSel" class="span6" name="foodStyle" >
										<option id="0" disabled selected="selected">请选择：</option>
										<s:iterator value="#request.foodStyles">
										<option value="<s:property value="foodStyleId" />"><s:property value="styleName" /></option>
										</s:iterator>
									</select>
								</div>
							</div>
							<div class="control-group" id="gro-price">
								<label for="price" class="col-xs-2 control-label">价&nbsp;&nbsp;&nbsp;格：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="price" value=""
										placeholder="输入价格">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-price">
									<i class="icon-info-sign"></i>
										 只能输入数字和小数点
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-description">
								<label for="description" class="col-xs-2 control-label">描&nbsp;&nbsp;&nbsp;述：</label>
								<div class="controls">
									<textarea class="span6 m-wrap" rows="10" name="description"></textarea>
								</div>
							</div>
							<div class="control-group" id="gro-img">
								<label for="img" class="col-xs-2 control-label">图&nbsp;&nbsp;&nbsp;片：</label>
								<div class="controls">
									<div class="fileupload fileupload-new" data-provides="fileupload">
										<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
											<s:if test="food.img != null && food.img !=''">
												<img src="<%=basePath %>image/foodImg/<s:property value="food.img" />"
													alt="...">
											</s:if>
											<s:else>
												<img src="<%=basePath %>image/foodImg/avatar1_small.jpg" alt="..."
													class="img-rounded" style="width: 200px; height: 150px;">
											</s:else>
										</div>
										<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
										<div >
											<span class="btn btn-file">
												<span class="fileupload-new">选择图片</span>
												<span class="fileupload-exists">改变</span>
												<s:file name="upload"></s:file>
												<!-- <input type="file" class="default" />-->
											</span>
											<a href="<%=basePath %>goods/food_add.jsp" class="btn fileupload-exists" id="remove" data-dismiss="fileupload">删掉</a>
										</div>
									</div>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="button"
										class="btn red button-next" id="btn-add" onclick="checkRegister(this.form)">提交添加 
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
