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
			 <h2 class="page-title">账单</h2>
			 	<ul class="breadcrumb">
					<li>
						<i class="icon-home"></i>
						<a href="admin_main.jsp">首页</a> 
						<i class="icon-angle-right"></i>
					</li>
					<li>
						<a>账单管理</a>
						<i class="icon-angle-right"></i>
					</li>
					<li><a href="<%=basePath %>user/userShowAction_show.action">账单信息</a></li>
				</ul>
			 <div class="tabbable tabbable-custom tabbable-full-width">
			   <ul class="nav nav-tabs">
				  <li role="presentation" class="active"><a href="#" >账单信息</a></li>
				  <li role="presentation"><a href="<%=basePath %>user/add_user.jsp">账单添加</a></li>
				</ul>
	          <div class="table-responsive">
	            <table class="table table-striped table-hover" id="user_show">
	              <thead>
	                <tr>
	                  <th>订单号ID</th>
	                  <th>结账桌号</th>
	                  <th>总费用</th>
	                  <th style="padding-left:20px;">操作</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<!-- 迭代 -->
					<s:iterator value="pays" status="st" var="pay">
	                <tr id="btn-<s:property value="id"/>">
	                 <td><s:property value="#pay.id"/></td>
	                 <td><s:property value="#pay.payTableNum"/></td>
	                  <td><s:property value="#pay.payPrice"/>元</td>
	                  <td style="width:60px;"><button class="btn red" style="width:60px;" id="myModal" href="#<s:property value="id"/>" data-toggle="modal">处理</button>
	                  </td>
	                  <td> 
	                      <a href="<%=basePath %>order/orderListShowAction_show.action?tableNum=<s:property value="payTableNum"/>" style="cursor:pointer;"><i class="icon-list-alt" style="font-size:30px;" ></i></a></td>
	                </tr>
	                <!-- 删除模态框（Modal） -->
					<div id="<s:property value="id"/>" class="modal hide fade" tabindex="-1" data-backdrop="<s:property value="id"/>" data-keyboard="false">
					 	<div class="modal-header">
				            <button type="button" class="close" 
				               data-dismiss="modal" aria-hidden="true">
				            </button>
				            <h4 class="modal-title" id="myModalLabel">
				               	提示
				            </h4>
				         </div>
						<div class="modal-body">
							<p>是否已经结账</p>
						</div>
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn">取消</button>
							<button type="button" data-dismiss="modal" class="btn red"  onclick="deletePay(<s:property value="id"/>)">确定</button>
						</div>
					</div>
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
								 <form id ="search" action="<%=basePath %>pay/payShowAction_show.action" method="post">
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
