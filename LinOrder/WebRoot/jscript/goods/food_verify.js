$(function(){
	/**
	 * 菜名添加校验
	 */
	if($("input[name='foodName']").length > 0 ){
		nameCheck();
	}
	if($("input[name='price']").length > 0 ){
		priceCheck();
	}
	if($("#foodSel").val() > 0 ){
		foodStyleCheck();
	}
	/**
	 * 监听功能
	 */
	$("input[name='foodName']").bind('change input',function(){
		nameCheck();
	}).focus();
	$("input[name='price']").bind('change input',function(){
		priceCheck();
	});
	$("#foodSel").bind('change',function(){
		foodStyleCheck();
	});
});

	$(document).keyup(function(event){
		if(event.keyCode == 13){
			$("#btn-add").trigger("click");
		}
	});
/**
 * 用户名检查
 * @returns {Boolean}
 */
function nameCheck(){
	var isOk = false;
	var val = $("input[name='foodName']").val();
	if(val == ""){
		showInfo("foodName"," 由字母、文字组成");
	}else if(!isName(val)){
		showError("foodName"," 只能由字母、文字组成！");
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
 * 检查菜名是不是已经存在
 * @param name
 */
function checkFoodName(foodName){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("foodName",htmlLog);
	$.ajax({
		type:"post",
		url:"goods/foodAction_checkFoodName",
		data:"foodName="+foodName,
		success:function(data){
			if(data == "true"){
				showSucc("foodName");
				return true;
			}else{
				showError("foodName"," 该菜名已经存在！");
				return false;
			}
		}
	});
}
/**
 * 价格检查
 * @returns {Boolean}
 */
function priceCheck(){
	var isOk = false;
	var val = $("input[name='price']").val();
	if(val == ""){
		showInfo("price"," 由数字、小数点组成");
	}else if(!isPrice(val)){
		showError("price"," 只能由数字、小数点组成！");
	}else{
		showSucc("price");
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
	var re = /^([0-9.])+$/;
	return re.test(val);
}
/**
 * 菜系检查
 * @returns {Boolean}
 */
function foodStyleCheck(){
	var isOk = false;
	var styleId = $('#foodSel option:selected').attr('value');
	//var val = document.getElementById("citySel").options[0].text;
	if(styleId == 0 ){
		showInfo("foodStyle","请输入菜系");
	}else if(styleId == 0){
		showError("foodStyle","请选择菜系！");
	}else if(styleId > 0){
		showSucc("foodStyle");
		isOk = true;
	}
	return isOk;
}


/**
 * 菜品添加检验
 * @param form
 */
function checkRegister(form){
	var isOK = $("#alert-foodName").hasClass("alert-success") && $("#alert-price").hasClass("alert-success");
    var isTrue = $("#gro-foodName").hasClass("success") && $("#gro-price").hasClass("success") ;
	if(isOK || isTrue){
//		alert(isTrue);
		$('form').submit();
	}
}

/**
 * 菜品更新检验
 * @param form
 */
function checkUpdate(form){
	var isOK =  $("#alert-price").hasClass("alert-success");
    var isTrue = $("#gro-price").hasClass("success") ;
	var val = $("input[name='foodName']").val();
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