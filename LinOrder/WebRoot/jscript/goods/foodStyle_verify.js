$(function(){
	/**
	 * 菜名添加校验
	 */
	if($("input[name='styleName']").length > 0 ){
		nameCheck();
	}
	if($("input[name='foodStyleId']").length > 0 ){
		IdCheck();
	}
	/**
	 * 监听功能
	 */
	$("input[name='styleName']").bind('change input',function(){
		nameCheck();
	}).focus();
	$("input[name='foodStyleId']").bind('change input',function(){
		IdCheck();
	});
});

	$(document).keyup(function(event){
		if(event.keyCode == 13){
			$("#btn-add").trigger("click");
		}
	});
/**
 * 菜系名名检查
 * @returns {Boolean}
 */
function nameCheck(){
	var isOk = false;
	var val = $("input[name='styleName']").val();
	if(val == ""){
		showInfo("styleName"," 由字母、文字组成");
	}else if(!isName(val)){
		showError("styleName"," 只能由字母、文字组成！");
	}else{
		checkFoodName(val);
		isOk = true;
	}
	return isOk;
}
/**
 * 判断菜名是不是非法字符
 * @param val
 * @returns
 */
function isName(val){
	var re = /^([a-zA-Z\u2E80-\u9FFF])+$/;
	return re.test(val);
}

/**
 * 检查菜系名是不是已经存在
 * @param name
 */
function checkFoodName(styleName){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("styleName",htmlLog);
	$.ajax({
		type:"post",
		url:"goods/foodStyleAction_checkFoodStyleName",
		data:"styleName="+styleName,
		success:function(data){
			if(data == "true"){
				showSucc("styleName");
				return true;
			}else{
				showError("styleName"," 该菜名已经存在！");
				return false;
			}
		}
	});
}
/**
 * 菜系号检查
 * @returns {Boolean}
 */
function IdCheck(){
	var isOk = false;
	var val = $("input[name='foodStyleId']").val();
	if(val == ""){
		showInfo("foodStyleId"," 由数字组成");
	}else if(!isPrice(val)){
		showError("foodStyleId"," 只能由数字组成！");
	}else{
		showSucc("foodStyleId");
		isOk = true;
	}
	return isOk;
}

/**
 * 判断价格是不是非法字符
 * @param val
 * @returns
 */
function isPrice(val){
	var re = /^([0-9])+$/;
	return re.test(val);
}

/**
 * 菜品添加检验
 * @param form
 */
function checkRegister(form){
	var isOK = $("#alert-styleName").hasClass("alert-success") && $("#alert-foodStyleId").hasClass("alert-success");
    var isTrue = $("#gro-styleName").hasClass("success") && $("#gro-foodStyleId").hasClass("success") ;
	if(isOK || isTrue){
//		alert(isTrue);
		$('form').submit();
	}
}

/**
 * 菜系更新检验
 * @param form
 */
function checkUpdate(form){
	var isOK =  $("#alert-foodStyleId").hasClass("alert-success");
    var isTrue = $("#gro-foodStyleId").hasClass("success") ;
	var val = $("input[name='styleName']").val();
	if(val == "" || !isName(val) ){
		$('form').click(function(event){
		    event.preventDefault();
		});
	}else if(isOK && isTrue && val != "" && isName(val)){
		$('form').submit();
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