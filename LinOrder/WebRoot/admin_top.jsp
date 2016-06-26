<%@ page language="java" import="java.util.*" import="java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css"/>	
	<script type="text/javascript" src="jscript/pwdVerify.js"></script>
</head>
  <body>
  	 <form action="staffAction_updateStaffPassword" namespace="/" method="post" enctype="multipart/form-data" >
   		<!-- 模态框（Modal） -->
		<div id="myMo" class="modal hide fade" tabindex="-1" data-backdrop="myMo" data-keyboard="false">
		 	<div class="modal-header" >
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	            </button>
	            <h4 class="modal-title" id="myModalLabel">
	               	修改密码
	            </h4>
	         </div>
			<div class="modal-body" style="margin-top:20px;">
			  <div class="control-group updatePwd" style="display:none;margin-top:20px;">
					<div class="alert alert-error" id="alert-p">
						<i class="icon-remove-sign"></i>
							新的密码和确认密码不一致
			     	</div>
			    </div>
				<div class="control-group">
					<label for="oldPassword" class="control-label">原&nbsp;来&nbsp;密&nbsp;码：</label>
					<div class="controls">
						<input type="text" class="span4 m-wrap" name="oldPassword" value=""
							placeholder="输入原来密码" style="margin-left:120px;margin-top:-30px;">
					</div>
				</div>
				<div class="control-group">
					<label for="password" class="control-label">新&nbsp;的&nbsp;密&nbsp;码：</label>
					<div class="controls">
						<input type="text" class="span4 m-wrap" name="newPwd" value=""
							placeholder="输入新的密码" style="margin-left:120px;margin-top:-30px;">
					</div>
				</div>
				<div class="control-group">
					<label for="comPassword" class="control-label">确&nbsp;认&nbsp;密&nbsp;码：</label>
					<div class="controls">
						<input type="password" class="span4 m-wrap" name="comPassword" value=""
							placeholder="输入确认密码" style="margin-left:120px;margin-top:-30px;">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button"  class="btn red" onclick="updatePwd(form)">确定</button>
				<button type="button" data-dismiss="modal" class="btn">取消</button>
			</div>
		</div>
	</form>
    <div class="header navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			 <div class="container-fluid">
			 	<a class="brand" href="admin_main.jsp">
			 	<!--<img src="<%=basePath %>image/logo.png" alt="logo" style="margin-top:5px;" />-->
					<span style="color:#fff;margin-left:40px;font-family:Microsoft Yahei In-Bold, Microsoft Yahei, 微软雅黑, Apple LiGothic Medium;">餐厅管理</span><span style="color:#e02222;font-family:Microsoft Yahei In-Bold, Microsoft Yahei, 微软雅黑, Apple LiGothic Medium;">系统</span>
				</a>
					<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
					<img src="<%=basePath %>image/menu-toggler.png" alt="" />
				</a>          
				<ul class="nav pull-right">
					<li style="margin-top:10px;padding-right:10px;">
						<span class="navbar-inverse">
						    <font color="#ddd">		
							今天是
							<%
						   	 	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置时间格式
						   	 	out.print(df.format(new Date()));//new Date()获取当前的系统时间
				   	         %> 
				   	    	</font>     	
						</span>   
						<span class="navbar-link" style="padding-left:30px;">
							<font color="#ddd">	
							欢 迎
							</font>	
						</span>
					</li>		
				 	<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img alt="" src="<%=basePath %>image/avatar1_small.jpg"/>
							<span class="username">
							 <%response.setCharacterEncoding("GB2312"); %>
							   <%=session.getAttribute("name")%>
							</span>
							<i class="icon-angle-down"></i>
						</a>
					    <ul class="dropdown-menu">
					    	<li><a href="staffAction_queryNameStaff.action?name=<%=session.getAttribute("name")%>"><i class="icon-user"></i> 个人信息</a></li>
					    	<li><a href="<%=basePath %>order/orderChuiShowAction_show.action"><i class="icon-calendar"></i> 催单信息</a></li>
					    	<li><a href="<%=basePath %>order/orderShowAction_show.action"><i class="icon-envelope"></i> 查看订单</a></li>
							<li><a href="<%=basePath %>pay/payShowAction_show.action"><i class="icon-tasks"></i> 账单信息</a></li>
							<li class="divider"></li>
							<li><a id="myMo" href="#myMo" data-toggle="modal"><i class="icon-edit"></i> 修改密码</a>
							</li>
							<li><a href="<%=basePath %>staffAction_logout.action"><i class="icon-key"></i> 退出</a></li>
					    </ul>
					    
					</li>
				</ul>
	    	 </div>
		</div>
    </div>
  </body>
</html>
