$(function(){
	/**
	 * 注册校验
	 */
	if($("input[name='name']").length > 0 ){
		nameCheck();
	}
	if($("input[name='username']").length > 0 ){//前台用户名
		usernameCheck();
	}
	if($("input[name='password']").length > 0 ){
		pwdCheck();
	}
	if($("input[name='email']").length > 0 ){
		emailCheck();
	}
	if($("input[name='phone']").length > 0 ){
		phoneCheck();
	}
	if($("#proSel").val() > 0 && $("#citySel").val() > 0){
		addressCheck();
	}
	/**
	 * 监听功能
	 */
	$("input[name='name']").bind('change input',function(){
		nameCheck();
	}).focus();
	$("input[name='username']").bind('change input',function(){//前台用户
		usernameCheck();
	}).focus();
	$("input[name='password']").bind('change input',function(){
		pwdCheck();
	});
	$("input[name='email']").bind('change input',function(){
		emailCheck();
	});
	$("input[name='phone']").bind('change input',function(){
		phoneCheck();
	});
	$("#proSel").bind('change',function(){
		$("#citySel").bind('change',function(){
			addressCheck();
		}).focus();
		addressCheck();
	});
});

	$(document).keyup(function(event){
		if(event.keyCode == 13){
			$("#btn-add").trigger("click");
		}
	});

	/**
	 * 地址检查
	 * @returns {Boolean}
	 */
	function addressCheck(){
		var isOk = false;
		var provinceId = $('#proSel option:selected').attr('value');
		var cityId = $('#citySel option:selected').attr('value');
		//var val = document.getElementById("citySel").options[0].text;
		if(provinceId == 0 ){
			showInfo("province","请输入有效的地址");
		}else if(cityId == 0){
			showError("province","请选择区域！");
		}else if(provinceId > 0 && cityId > 0){
			showSucc("province");
			isOk = true;
		}
		return isOk;
	}
/**
 * 用户名检查
 * @returns {Boolean}
 */
function nameCheck(){
	var isOk = false;
	var val = $("input[name='name']").val();
	if(val == ""){
		showInfo("name"," 4-20位字符，由字母、数字、下划线、文字组成");
	}else if(!isName(val)){
		showError("name"," 只能由字母、数字、下划线、文字组成！");
	}else if(val.length < 4){
		showError("name"," 不能小于4个字符！");
	}else if(val.length > 20){
		showError("name", " 不能超过20个字符！");
	}else{
		checkName(val);
		isOk = true;
	}
	return isOk;
}
/**
 * 前台用户名检查
 * @returns {Boolean}
 */
function usernameCheck(){
	var isOk = false;
	var val = $("input[name='username']").val();
	if(val == ""){
		showInfo("username"," 4-20位字符，由字母、数字、下划线组成");
	}else if(!isUsername(val)){
		showError("username"," 只能由字母、数字、下划线组成！");
	}else if(val.length < 4){
		showError("username"," 不能小于4个字符！");
	}else if(val.length > 20){
		showError("username", " 不能超过20个字符！");
	}else{
		checkUsername(val);
		isOk = true;
	}
	return isOk;
}
/**
 * 判断用户名是不是非法字符
 * @param val
 * @returns
 */
function isName(val){
	var re = /^([a-zA-Z0-9_])+$/;
	return re.test(val);
}

/**
 * 判断前台用户名是不是非法字符
 * @param val
 * @returns
 */
function isUsername(val){
	var re = /^([a-zA-Z0-9_\u2E80-\u9FFF])+$/;
	return re.test(val);
}

/**
 * 检查用户名是不是已经被注册
 * @param name
 */
function checkName(name){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("name",htmlLog);
	$.ajax({
		type:"post",
		url:"staffAction_checkName",
		data:"name="+name,
		success:function(data){
			if(data == "true"){
				showSucc("name");
				return true;
			}else{
				showError("name","该用户名已被注册！");
				return false;
			}
		}
	});
}

/**
 * 检查前台用户名是不是已经被注册
 * @param username
 */
function checkUsername(username){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("username",htmlLog);
	$.ajax({
		type:"post",
		url:"user/userAction_checkUsername",
		data:"username="+username,
		success:function(data){
			if(data == "true"){
				showSucc("username");
				return true;
			}else{
				showError("username","该用户名已被注册！");
				return false;
			}
		}
	});
}

/**
 * 检查修改的用户名是不是已经被注册
 * @param name
 */
function checkReName(name){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("name",htmlLog);
	$.ajax({
		type:"post",
		url:"staffAction_checkName",
		data:"name="+name+"lxl",
		success:function(data){
			if(data == "true"){
				showSucc("name");
				return true;
			}else{
				showError("name","该用户名已被注册！");
				return false;
			}
		}
	});
}
/**
 * 密码检查
 * @returns {Boolean}
 */
function pwdCheck(){
	var isOk = false;
	var val = $("input[name='password']").val();
	if(val == ""){
		showInfo("password"," 6-20位字符，建议由字母、数字和符号两种以上组合");
	}else if(!isPwd(val)){
		showError("password"," 密码不正确，必须由字母、数字和符号两种以上组合");
	}else if(val.length < 6){
		showError("password"," 密码小于六位");
	}else if(val.length > 20){
		showError("password"," 密码大于20位");
	}else{
		showSucc("password");
		isOk = true;
	}
	return isOk;
}
function isPwd(val){
	var re = /^([a-zA-Z0-9])+$/;
	return re.test(val);
}
/**
 * 检查邮箱
 * @returns {Boolean}
 */
function emailCheck(){
	var isOk = false;
	var val = $("input[name='email']").val();
	if(val == ""){
		showInfo("email"," 请输入有效的邮箱");
	}else if(!isEmail(val)){
		showError("email"," 输入的邮箱无效");
	}else {
		showSucc("email");
		isOk = true;
	}
	return isOk;
}
//邮箱格式检查
function isEmail(val){
	var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-\.])+\.)+(com|net)$/;
	return re.test(val);
}
/**
 * 电话检查
 * @returns {Boolean}
 */
function phoneCheck(){
	var isOk = false;
	var val = $("input[name='phone']").val();
	if(val == ""){
		showInfo("phone"," 请输入有效的电话号码");
	}else if(!isPhone(val)){
		showError("phone","输入的电话号码无效！");
	}else if(val.length < 11){
		showError("phone","输入的电话号码小于11位");
	}else if(val.length > 11){
		showError("phone","输入的电话号码大于11位");
	}else{
		showSucc("phone");
		isOk = true;
	} 
	return isOk;
}
//电话格式检查
function isPhone(val){
	var re = /^(1)+([0-9]{10})$/;
	return re.test(val);
}
/**
 * 后台添加检验
 * @param form
 */
function checkRegister(form){
	var isOK = $("#alert-name").hasClass("alert-success") && $("#alert-province").hasClass("alert-province") && $("#alert-password").hasClass("alert-success") && $("#alert-email").hasClass("alert-success") && $("#alert-phone").hasClass("alert-success");
    var isTrue = $("#gro-name").hasClass("success") && $("#gro-province").hasClass("success") && $("#gro-password").hasClass("success") && $("#gro-email").hasClass("success") && $("#gro-phone").hasClass("success");
	if(isOK || isTrue){
//		alert(isTrue);
		$('form').submit();
	}
}

/**
 * 后台更新检验
 * @param form
 */
function checkUpdate(form){
//	var isOK = $("#alert-name").hasClass("alert-success") && $("#alert-province").hasClass("alert-province") && $("#alert-password").hasClass("alert-success") && $("#alert-email").hasClass("alert-success") && $("#alert-phone").hasClass("alert-success");
//    var isTrue = $("#gro-province").hasClass("success") && $("#gro-password").hasClass("success") && $("#gro-email").hasClass("success") && $("#gro-phone").hasClass("success");
//	if(isOK || isTrue){
//		alert(isTrue);
		$('form').submit();
//	}
}

/**
 * 前台用户添加检验
 * @param form
 */
function checkAdd(form){
	var isOK = $("#alert-username").hasClass("alert-success") && $("#alert-password").hasClass("alert-success") && $("#alert-phone").hasClass("alert-success");
    var isTrue = $("#gro-username").hasClass("success") && $("#gro-password").hasClass("success") && $("#gro-phone").hasClass("success");
	if(isOK || isTrue){
		$('form').submit();
	}
}

/**
 * 后台更新检验
 * @param form
 */
function checkUpdateUser(form){
	var val = $("input[name='username']").val();
	var isOK = $("#alert-password").hasClass("alert-success") && $("#alert-phone").hasClass("alert-success");
    var isTrue = $("#gro-password").hasClass("success") && $("#gro-phone").hasClass("success");
	if(val != null || !isUsername(val) ){
		if(isOK || isTrue){
		$('form').submit();
		}
	}
}
//**********************************
//显示提示
function showInfo(alert,msg){
	var al = $("#alert-"+alert);
	var cl = $("#gro-"+alert);
	var icon = "<i class='icon-info-sign'></i><button class='close' data-dismiss='alert'></button>";
	al.removeClass("alert-success");
	al.removeClass("alert-danger");
	al.addClass("alert-info");
	al.css("display","block");
	cl.removeClass("success");
	cl.removeClass("error");
	al.html(icon + msg);
}
//显示错误
function showError(alert,msg){
	var al = $("#alert-"+alert);
	var cl = $("#gro-"+alert);
	var icon = "<i class='icon-remove-sign'></i><button class='close' data-dismiss='alert'></button>";
	al.removeClass("alert-success");
	al.removeClass("alert-info");
	al.addClass("alert-danger");
	cl.removeClass("success");
	cl.addClass("error");
	al.html(icon + msg);
}
//显示成功
function showSucc(alert,msg){
	var al = $("#alert-"+alert);
	var cl = $("#gro-"+alert);
	var icon = "<i class='icon-ok-sign'></i><button class='close' data-dismiss='alert'></button>";
	al.removeClass("alert-danger");
	al.removeClass("alert-info");
	al.addClass("alert-success");
	cl.removeClass("error");
	cl.addClass("success");
	al.html(icon + " 输入正确");
}