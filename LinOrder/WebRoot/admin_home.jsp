<%@ page language="java" import="java.util.*" import="java.text.SimpleDateFormat" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
   <div class="page-content">
		<div class="container-fluid">
			<div class="row" style="margin-left:10px;margin-top:30px;">
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" >
					<div class="dropzone dz-clickable" data-dz-message>
					<class="dz-default dz-message">
					  <h1 style="font-size: 63px;margin-top:70px;">欢迎
					  <%response.setCharacterEncoding("GB2312"); %>
					  <%=session.getAttribute("name")%></h1>
					  <p style="margin-bottom: 15px;font-size: 21px;font-weight: 200;margin-top:20px;">进入后台管理界面</p>
					  </class>
					</div>
			     </div>
		    </div>
	     </div>
   </div>
</body>
</html>
