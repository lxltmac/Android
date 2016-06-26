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
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-metro.css"/>
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
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
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="admin_main.jsp">首页</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="#">用户管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="staffShowAction_show.action">后台用户管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="admin_register.jsp">后台用户添加</a></li>
						</ul>
					<div class="tabbable tabbable-custom tabbable-full-width">
						<ul class="nav nav-tabs">
							<li role="presentation"><a href="staffShowAction_show.action">后台用户信息</a>
							</li>
							<li role="presentation" class="active"><a href="#">后台用户添加</a>
							</li>
						</ul><br><br>
						
						<form class="form-horizontal" action="staffAction_addUser" namespace="/" method="post">
						<div class="col-xs-7 col-xs-offset-2">
							<div class="control-group" id="gro-name">
								<label for="name" class="control-label">用&nbsp;户&nbsp;名：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="name" value=""
										placeholder="输入用户名">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-name">
									<i class="icon-info-sign"></i>
										4-20位字符，由字母、数字、下划线组成
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-password">
								<label for="password" class="col-xs-2 control-label">密&nbsp;&nbsp;&nbsp;码：</label>
								<div class="controls">
									<input type="password" class="span6 m-wrap" name="password" value=""
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
										<input type="radio" name="sex" value="男" checked>男
									</label>
									<label class="radio">
										<input type="radio" name="sex" value="女" style="margin-left:1px;">女
									</label>
								</div>
							</div>
							<div class="control-group">
								<label for="duty" class="col-xs-2 control-label">职&nbsp;&nbsp;&nbsp;位：</label>
								<div class="controls">
									<select class="span6 chosen" name="duty">
										<option value="经理" selected="selected">经理</option>
										<option value="副经理">副经理</option>
										<option value="分店管理员">分店管理员</option>
									</select>
								</div>
							</div>
							<div class="control-group" id="gro-email">
								<label for="email" class="col-xs-2 control-label">邮&nbsp;&nbsp;&nbsp;箱：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="email" value=""
										placeholder="输入电子邮箱">
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-email">
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
										<s:iterator value="#request.provinces">
											<option value="<s:property value="provinceID" />"><s:property value="province" /></option>
										</s:iterator>
									</select>
									<select id="citySel" class="form-control" name="city">			
										<option value="0" disabled selected="selected">请选择：</option>
											<s:iterator value="#request.citys">
												<option value="<s:property value="cityID" />"><s:property value="city" /></option>
											</s:iterator>
									</select>
								</div>
								<div class="controls">
									<div class="alert alert-info" id="alert-province">
									<i class="icon-info-sign"></i>
										请输入有效的地址
									<button class='close' data-dismiss='alert'></button>
						     		</div>
					     		</div>
							</div>
							<div class="control-group" id="gro-phone">
								<label for="phone" class="col-xs-2 control-label">电&nbsp;&nbsp;&nbsp;话：</label>
								<div class="controls">
									<input type="text" class="span6 m-wrap" name="phone" value=""
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
										class="btn red button-next" id="btn-add"  data-toggle="modal" data-target="#add">提交添加 
										<i class="m-icon-swapright m-icon-white"></i>
										</button>
								</div>
								<!-- 提交模态框（Modal） -->
								<div id="add" class="modal fade" tabindex="-1" data-backdrop="add" data-keyboard="false">
									<div class="modal-header">
							            <button type="button" class="close" 
							               data-dismiss="modal" aria-hidden="true">
							            </button>
							            <h4 class="modal-title" id="myModalLabel">
							               	提示
							            </h4>
						         	</div>
									<div class="modal-body">
										<p>是否确认提交</p>
									</div>
									<div class="modal-footer">
										<button type="button" data-dismiss="modal" class="btn">取消</button>
										<button type="button" data-dismiss="modal" class="btn red"  onclick="checkRegister(this.form)">确定</button>
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
