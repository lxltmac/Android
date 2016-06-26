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
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<script type="text/javascript" src="jscript/animation.js"></script>
	<script type="text/javascript" src="jscript/admincommon.js"></script>
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
						<a>用户管理</a>
						<i class="icon-angle-right"></i>
					</li>
					<li>
						<a href="staffShowAction_show.action">后台用户管理</a>
						<i class="icon-angle-right"></i>
					</li>
					<li><a href="staffShowAction_show.action">后台用户信息</a></li>
				</ul>
			 <div class="tabbable tabbable-custom tabbable-full-width">
			   <ul class="nav nav-tabs">
				  <li role="presentation" class="active"><a href="#" >后台用户信息</a></li>
				  <li role="presentation"><a href="admin_register.jsp">后台用户添加</a></li>
				</ul>
	          <div class="table-responsive" id="tab1">
	            <table class="table table-striped table-hover">
	              <thead>
	                <tr id="12">
	                  <th>工号ID</th>
	                  <th>用户名</th>
	                  <th>性别</th>
	                  <th>职位</th>
	                  <th style="padding-left:50px;">邮箱</th>
	                  <th style="padding-left:30px;">地址</th>
	                  <th style="padding-left:35px;">电话</th>
	                  <th style="padding-left:35px;">操作</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<!-- 迭代 -->
					<s:iterator value="staffs" status="st" var="staff">
	                <tr id="btn-<s:property value="id"/>">
	                 <td><s:property value="#staff.id"/></td>
					 <td><s:property value="#staff.name"/></td>
					 <td><s:property value="#staff.sex"/></td>
					 <td><s:property value="#staff.duty"/></td>
					 <td><s:property value="#staff.email"/></td> 
					 <td><s:property value="#staff.city.province.province"/><s:property value="#staff.city.city"/></td>
					 <td><s:property value="#staff.phone"/></td>
	                  <td><a id="myModal" href="#<s:property value="id"/>" data-toggle="modal"><i class="icon-trash"></i></a> 
	                  <s:if test="freeBuff == 0">| <a  id="myModal" href="#free<s:property value="id"/>" data-toggle="modal"><i class="icon-unlock" id="free"></i></a></s:if>
					  <s:else> | <a  id="myModal" href="#unfree<s:property value="id"/>" data-toggle="modal"><i class="icon-lock" id="unfree" style="margin-left:4px;"></i></a></s:else>
	                  | <a href="staffAction_queryStaff.action?id=<s:property value="id"/>"><i class="icon-edit"></i></a></td>
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
							<p>是否删除此用户</p>
						</div>
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn">取消</button>
							<button type="button" data-dismiss="modal" class="btn red"  onclick="deleteStaff(<s:property value="id"/>)">确定</button>
						</div>
					</div>
					  <!-- 冻结模态框（Modal） -->
					<!-- 模态框（Modal） -->
					<div class="modal hide fade" id="free<s:property value="id"/>" class="modal hide fade" tabindex="-1" data-backdrop="unfree<s:property value="id"/>" data-keyboard="false">
				         <div class="modal-header">
				            <button type="button" class="close" 
				               data-dismiss="modal" aria-hidden="true">
				            </button>
				            <h4 class="modal-title" id="myModalLabel">
				               	提示
				            </h4>
				         </div>
				         <div class="modal-body">
				          	  是否冻结此用户
				         </div>
				         <div class="modal-footer">
				            <button type="button" class="btn btn-default" 
				               data-dismiss="modal">关闭
				            </button>
				            <button type="button" class="btn red" onclick="freezeStaff(<s:property value="id"/>)">
				      		         确定
				            </button>
				         </div>
					</div><!-- /.modal -->
					  <!-- 解冻模态框（Modal） -->
					<div id="unfree<s:property value="id"/>" class="modal hide fade" tabindex="-1" data-backdrop="unfree<s:property value="id"/>" data-keyboard="false">
					 	<div class="modal-header">
				            <button type="button" class="close" 
				               data-dismiss="modal" aria-hidden="true">
				            </button>
				            <h4 class="modal-title" id="myModalLabel">
				               	提示
				            </h4>
				         </div>
						<div class="modal-body">
							<p>是否解冻此用户</p>
						</div>
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn">取消</button>
							<button type="button" data-dismiss="modal" class="btn red"  onclick="unfreezeStaff(<s:property value="id"/>)">确定</button>
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
								<!-- 循环标签 -->
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
								 <form id ="search" action="staffShowAction_show.action" method="post">
									 <input type="text" class="ipt form-control" name="pageNo" />
									 <button type="submit" class="btn btn-default" id="goBtn">GO</button>
								 </form>
							 </div>
					 </div>	
	          	</div>
            </div>
		 </div>
	   </div>
	</div>
	<jsp:include page="admin_footer.jsp" flush="true" />
  </body>
</html>
