<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台登录</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/sign.css">
	<link rel="stylesheet" type="text/css" href="css/animation.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<script type="text/javascript" src="jscript/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="jscript/bootstrap.js"></script>
	<script type="text/javascript" src="jscript/animation.js"></script>
  </head>
   <body>
   <h1 style="margin-top:-40px;text-align:center;font-weight:bold;font-family:Microsoft YaHei;height:50px">餐 &nbsp;&nbsp;厅 &nbsp;&nbsp;管 &nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</h1>
  	<form class="form-signin" action="staffAction_loginCheck" method="post">
  		<h1 class="form-signin-heading">登录</h1>
  		<div class="controls" style="margin-left:-449px;margin-top:45px;display:none;" id="loginVer">
			<div class="alert alert-danger" id="alert-name" style="width:300px;height:35px;">
			<div style="margin-top:-5px;"><i class="icon-remove-sign"></i></div>
				<div style="margin-top:-18px;margin-left:20px;">用户名或密码错误！</div>
    		</div>
   		</div>
  		<label for="name" class="sr-only">用户名</label>
  		<div class="input-group">
  			<span class="input-group-addon">
  			   <i class="glyphicon glyphicon-user"></i>
			</span> <input type="text" name="name" class="form-control" 
					placeholder="用户名" required autofocus>
		</div>
		<label for="name" class="sr-only">密码</label>
		<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock"></i>
				</span><input type="password" name="password" class="form-control"
				        placeholder="密码" required autofocus>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit" id="myButton" 
		      onclick="login(this.form)">登录</button>	        
  	</form>    
  	<div class="charector-wrap xfast" id="js_wrap" style="display:none;">
	    <div class="charector"></div>
	</div>
  </body>
</html>
 