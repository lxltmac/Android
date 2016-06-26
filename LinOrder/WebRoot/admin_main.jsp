<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head >
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台主页面</title>
    
	<script type="text/javascript" src="jscript/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="jscript/app.js"></script>
	<script type="text/javascript" src="jscript/menu.js"></script>
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<script type="text/javascript" src="jscript/animation.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/style-metro.css">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/dropzone.css"/>
  </head>
  	
  <body class="page-header-fixed">
    <jsp:include page="admin_top.jsp" flush="true" />
	<jsp:include page="admin_left.jsp" flush="true" />
	<jsp:include page="admin_home.jsp" flush="true" />
	<jsp:include page="admin_footer.jsp" flush="true"/>
  </body>
</html>
