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
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<script type="text/javascript" src="jscript/animation.js"></script>
	<script type="text/javascript" src="jscript/admincommon.js"></script>
	<script type="text/javascript" src="jscript/user/aja.js"></script>
	<script type="text/javascript" src="jscript/jquery.bootpag.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-metro.css"/>
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="css/animation.css"/>
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
					<li><a href="<%=basePath %>user/userShowAction_show.action">前台用户信息</a></li>
				</ul>
			 <div class="tabbable tabbable-custom tabbable-full-width">
			   <ul class="nav nav-tabs">
				  <li role="presentation" class="active"><a href="#" >前台用户信息</a></li>
				  <li role="presentation"><a href="<%=basePath %>user/add_user.jsp">前台用户添加</a></li>
				</ul>
	          <div class="table-responsive">
	            <table class="table table-striped table-hover" id="user_show">
	              <thead>
	                <tr>
	                  <th>工号ID</th>
	                  <th>用户名</th>
	                  <th>性别</th>
	                  <th style="padding-left:35px;">电话</th>
	                  <th style="padding-left:20px;">操作</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<!-- 迭代 -->
					<s:iterator value="users" status="st" var="user">
	                <tr id="btn-<s:property value="id"/>">
	                 <td><s:property value="#user.id"/></td>
					 <td><s:property value="#user.username"/></td>
					 <td><s:property value="#user.sex"/></td>
					 <td><s:property value="#user.phone"/></td>
	                  <td><a onclick="deleteUser(<s:property value="id"/>)"><i class="icon-trash"></i></a> | 
	                      <a href="<%=basePath %>user/userAction_queryUser.action?id=<s:property value="id"/>"><i class="icon-edit"></i></a></td>
	                </tr>
	              </s:iterator>
                 </tbody>
               </table>
                <!-- <form id ="search" action="staffShowAction_show.action" method="post">
                <input type="text" name="pageNo" style="display:none" />
                </form> -->
                <div align="center">
                	<div class="pagination">
							<ul>
								<li <s:if test="pageNo <= 1">class="disabled"</s:if>><a
									<s:if test="pageNo > 1">href="javascript:goodsPage(<s:property value="pageNo-1" />)"</s:if>
									aria-label="Previous"><span aria-hidden="true">&laquo;</span>
								</a>
								</li>
								<s:bean name="org.apache.struts2.util.Counter" id="counter">
									<s:param name="first" value="1" />
									<s:param name="last" value="totalPage" />
									<s:iterator>
										<li
											<s:if test="%{(current-1) == pageNo}">class="active"</s:if>><a
											href="javascript:goodsPage(<s:property value="current-1" />)"><s:property
													value="current-1" />
											</a>
										</li>
									</s:iterator>
								</s:bean>
								<li
									<s:if test="pageNo >= totalPage">class="disabled"</s:if>><a
									<s:if test="pageNo < totalPage">href="javascript:goodsPage(<s:property value="pageNo+1" />)"</s:if>
									aria-label="Next"><span aria-hidden="true">&raquo;</span> </a>
								</li>
							</ul>
							 <div class="pagination-goto">
								 <form id ="search" action="<%=basePath %>user/userShowAction_show.action" method="post">
									 <input type="text" class="ipt form-control" name="pageNo" />
									 <button type="submit" class="btn btn-default" id="goBtn" onclick="enter()">GO</button>
								 </form>
							 </div>
					 </div>	
	          	</div>
            </div>
		 </div>
	   </div>
	</div>
	<jsp:include page="../admin_footer.jsp" flush="true" />
  </body>
</html>
