<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
	<script type="text/javascript">
	        $(document).ready(function () {
	            var name = '<%=session.getAttribute("name")%>';
	            if(name != "lxltmac"){
	            	$("#quanxian").hide();
	            }
	        });
	    </script>
  <body>
    <div class="page-container row-fluid">
    	<div class="page-sidebar nav-collapse collapse">
    		<ul class="page-sidebar-menu">
    			<li>
    				<div class="sidebar-toggler hidden-phone"></div>
    			</li>
    			<li style="margin-top:20px;">
    			
					<!--<form class="sidebar-search">
						<div class="input-box">
							<a href="javascript:;" class="remove" ></a>
							<input type="text" placeholder="搜索..." />
							<input type="button" class="submit" value=" " />
						</div>
					</form>-->
				</li>
				<li class="start">
					<a href="<%=basePath %>admin_main.jsp">
						<i class="icon-home"></i> 
				    	<span class="title">首页</span>
				    	<span class="selected"></span>
					</a>
				</li>
				<li>
					<a href="#">
						<i class="icon-cogs"></i> 
						<span class="title">用户管理</span>
						<span class="arrow"></span>
						<span class="selected"></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="#">
							<i class="icon-user"></i>
							前台用户管理
							<span class="arrow"></span>
						    <span class="selected"></span>
							</a>
							<ul class="sub-menu">
								<li>
									<a href="<%=basePath %>user/userShowAction_show.action">
									<i class="icon-group"></i>
									前台用户信息</a>
								</li>
								<li>			
									<a href="<%=basePath %>user/add_user.jsp">
									<i class="icon-pencil"></i>
									前台用户添加</a>
								</li>
								<li class="disabled">	
					                <a href="<%=basePath %>user/userAction_queryUser.action?id=<s:property value="id"/>" id="username-edit">
					                <i class="icon-edit"></i>
					                                                        前台用户修改</a>
								</li>
							</ul>
						</li>
						<li id="quanxian">			
							<a href="#">
							<i class="icon-user-md"></i>
							后台用户管理
							<span class="arrow"></span>
						    <span class="selected"></span>
						    </a>
							<ul class="sub-menu">
								<li>
									<a href="<%=basePath %>staffShowAction_show.action">
									<i class="icon-group"></i>
									后台用户信息</a>
								</li>
								<li>			
									<a href="<%=basePath %>admin_register.jsp">
									<i class="icon-pencil"></i>
									后台用户添加</a>
								</li>
								<li class="disabled">	
					                <a href="staffAction_queryStaff.action?id=<s:property value="id"/>" id="user-edit">
					                <i class="icon-edit"></i>
					                                                        后台用户修改</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="staffAction_queryNameStaff.action?name=<%=session.getAttribute("name")%>">
								<i class="icon-male"></i>
								个人信息管理
								<span class="arrow"></span>
						   		<span class="selected"></span>
						    </a>
						    <ul class="sub-menu">
								<li>
									<a href="staffAction_queryNameStaff.action?name=<%=session.getAttribute("name")%>">
									<i class="icon-group"></i>
									用户个人信息</a>
								</li>
								<li>
									<a href="staffAction_queryNameStaffSelf.action?name=<%=session.getAttribute("name")%>">
									<i class="icon-edit"></i>
									用户信息修改</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li style="display:none;">
					<a href="#">
						<i class="icon-key"></i> 
						<span class="title">权限管理</span>
					</a>
				</li>
				<li>
					<a href="javascript:;">
					<i class="icon-bookmark-empty"></i> 
					<span class="title" style="margin-left:4px;">菜品管理</span>
					<span class="arrow"></span>
					<span class="selected"></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="<%=basePath %>goods/foodShowAction_show.action">
							<i class="icon-hdd"></i>
							菜品信息</a>	
						</li>
						<li>
							<a href="<%=basePath %>goods/food_add.jsp">
							<i class="icon-pencil"></i>
							菜品添加</a>
						</li>
						<li >
							<a href="<%=basePath %>goods/foodAction_queryFood.action?id=<s:property value="id"/>" id="food-edit">
							<i class="icon-edit"></i>
							菜品修改</a>				
						</li>						
					</ul>
				</li>
				<li>
					<a href="javascript:;">
					<i class="icon-sitemap"></i> 
					<span class="title">菜系管理</span>
					<span class="arrow"></span>
					<span class="selected"></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="<%=basePath %>goods/foodStyleShowAction_show.action">
							<i class="icon-columns"></i>
							菜系信息</a>	
						</li>
						<li>
							<a href="<%=basePath %>goods/foodStyle_add.jsp">
							<i class="icon-pencil"></i>
							菜系添加</a>
						</li>
						<li >
							<a href="<%=basePath %>goods/foodStyleAction_queryFoodStyle.action?id=<s:property value="id"/>" id="foodStyle-edit" >
							<i class="icon-edit"></i>
							菜系修改</a>				
						</li>						
					</ul>
				</li>
			   <li>
					<a href="javascript:;">
					<i class="icon-table"></i> 
					<span class="title">桌号管理</span>
					<span class="selected"></span>
					<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="<%=basePath %>table/tableShowAction_show.action">
							<i class="icon-list-alt"></i>
							桌号信息</a>
						</li>
						<li >
							<a href="<%=basePath %>table/table_add.jsp">
							<i class="icon-pencil"></i>
							桌号添加</a>
						</li>
						<li >
							<a href="<%=basePath %>table/tableAction_queryTable.action?id=<s:property value="id"/>" id="table-edit">
							<i class="icon-edit"></i>
							桌号修改</a>
						</li>
				    </ul>
			   </li>
			   <li>
					<a href="javascript:;">
					<i class="icon-shopping-cart"></i> 
					<span class="title">订单管理</span>
					<span class="selected"></span>
					<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="<%=basePath %>order/orderShowAction_show.action">
							<i class="icon-envelope"></i>
							订单处理</a>
						</li>
						<li >
							<a href="<%=basePath %>order/orderListShowAction_show.action?tableNum=<s:property value="tableNum"/>" id="order_detial">
							<i class="icon-credit-card"></i>
							订单详情</a>
						</li>
						<li >
							<a href="<%=basePath %>order/orderChuiShowAction_show.action">
							<i class="icon-bell"></i>
							催单处理</a>
						</li>
				    </ul>
			  	 </li>
			   <li>
					<a href="javascript:;">
					<i class="icon-calendar"></i> 
					<span class="title">账单管理</span>
					<span class="selected"></span>
					<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="<%=basePath %>pay/payShowAction_show.action">
							<i class="icon-renminbi"></i>
							账单处理</a>
						</li>
						<li >
							<a href="<%=basePath %>pay/show_charts.jsp">
							<i class="icon-book"></i>
							账单统计</a>
						</li>
				    </ul>
			  	 </li>
			</ul>
		</div>
    </div>
  </body>
</html>
