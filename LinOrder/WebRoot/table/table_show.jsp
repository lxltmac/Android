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
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<script type="text/javascript" src="jscript/animation.js"></script>
	<script type="text/javascript" src="jscript/admincommon.js"></script>
	<script type="text/javascript" src="jscript/table/aja.js"></script>
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
			 <h2 class="page-title">桌号管理</h2>
			 <div class="tabbable tabbable-custom tabbable-full-width">
			   <ul class="nav nav-tabs">
				  <li role="presentation" class="active"><a href="#" >桌号户信息</a></li>
				  <li role="presentation"><a href="<%=basePath %>table/table_add.jsp">桌号添加</a></li>
				</ul>
	          <div class="table-responsive">
	            <table class="table table-striped  table-hover" id="show_table">
	              <thead>
	                <tr>
	                  <th style="width:150px;">桌号ID</th>
	                  <th style="width:220px;padding-right:36px;">桌号名</th>
	                  <th style="width:230px;">桌号</th>
	                  <th style="width:220px;">桌位人数</th>
	                  <th style="padding-left:80px;">操作</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<!-- 迭代 -->
					<s:iterator value="tables" status="tb" var="table">
	                <tr id="btn-<s:property value="id"/>">
	                 <td><s:property value="#table.id"/></td>
					 <td><s:property value="#table.tableName"/></td>
					 <td><s:property value="#table.tableNum"/></td>
					 <td style="width:130px;padding-left:28px;"><s:property value="#table.tableInfo"/></td>
	                 <td style="padding-left:70px;"><a onclick="deleteTable(<s:property value="id"/>)"><i class="icon-trash"></i></a> | 
	                      <a href="<%=basePath %>table/tableAction_queryTable.action?id=<s:property value="id"/>"><i class="icon-edit"></i></a></td>
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
								 <form id ="search" action="<%=basePath %>table/tableShowAction_show.action" method="post">
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
