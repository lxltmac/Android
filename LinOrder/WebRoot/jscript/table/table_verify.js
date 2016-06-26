$(function(){
	/**
	 * 桌号名添加校验
	 */
	if($("input[name='tableName']").length > 0 ){
		nameCheck();
	}
	if($("input[name='tableNum']").length > 0 ){
		numCheck();
	}
	if($("input[name='tableInfo']").length > 0 ){
		infoCheck();
	}
	/**
	 * 监听功能
	 */
	$("input[name='tableName']").bind('change input',function(){
		nameCheck();
	}).focus();
	$("input[name='tableNum']").bind('change input',function(){
		numCheck();
	});
	$("input[name='tableInfo']").bind('change input',function(){
		infoCheck();
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
	var val = $("input[name='tableName']").val();
	if(val == ""){
		showInfo("tableName"," 由字母、数字组成，不能多于6位字符");
	}else if(!isName(val)){
		showError("tableName"," 由字母、数字组成！");
	}else if(val.length > 6){
		showError("tableName"," 不能多于六位字符！");
	}else{
		checkTableName(val);
		isOk = true;
	}
	return isOk;
}
/**
 * 判断桌号名是不是非法字符
 * @param val
 * @returns
 */
function isName(val){
	var re = /^([a-zA-Z0-9\u2E80-\u9FFF])+$/;
	return re.test(val);
}

/**
 * 检查桌号名是不是已经存在
 * @param name
 */
function checkTableName(tableName){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("tableName",htmlLog);
	$.ajax({
		type:"post",
		url:"table/tableAction_checkTableName",
		data:"tableName="+tableName,
		success:function(data){
			if(data == "true"){
				showSucc("tableName");
				return true;
			}else{
				showError("tableName"," 该桌号名已经存在！");
				return false;
			}
		}
	});
}

/**
 * 桌号检查
 * @returns {Boolean}
 */
function numCheck(){
	var isOk = false;
	var val = $("input[name='tableNum']").val();
	if(val == ""){
		showInfo("tableNum"," 4位字符，建议由大写字母、数字两种以上组合");
	}else if(!isNum(val)){
		showError("tableNum"," 由大写字母、数字两种以上组合！");
	}else if(val.length != 4){
		showError("tableNum"," 必须是4位字符！");
	}else{
		checkTableNum(val);
		isOk = true;
	}
	return isOk;
}

/**
 * 检查桌号名是不是已经存在
 * @param name
 */
function checkTableNum(tableNum){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	showInfo("tableNum",htmlLog);
	$.ajax({
		type:"post",
		url:"table/tableAction_checkTableNum",
		data:"tableNum="+tableNum,
		success:function(data){
			if(data == "true"){
				showSucc("tableNum");
				return true;
			}else{
				showError("tableNum"," 该桌号已经存在！");
				return false;
			}
		}
	});
}

/**
 * 判断桌号是不是非法字符
 * @param val
 * @returns
 */
function isNum(val){
	var re = /^([A-Z0-9])+$/;
	return re.test(val);
}

/**
 * 桌号检查
 * @returns {Boolean}
 */
function infoCheck(){
	var isOk = false;
	var val = $("input[name='tableInfo']").val();
	if(val == ""){
		showInfo("tableInfo"," 只能输入数字且桌位人数不能超过20");
	}else if(!isInfo(val)){
		showError("tableInfo"," 只能输入数字！");
	}else if(val > 20){
		showError("tableInfo"," 桌位人数不能超过20！");
	}else{
		showSucc("tableInfo");
		isOk = true;
	}
	return isOk;
}

/**
 * 判断桌号是不是非法字符
 * @param val
 * @returns
 */
function isInfo(val){
	var re = /^([0-9])+$/;
	return re.test(val);
}

/**
 * 桌号添加检验
 * @param form
 */
function checkAddTable(form){
	var isOK = $("#alert-tableName").hasClass("alert-success");
    var isTrue = $("#gro-tableName").hasClass("success");
	if(isOK || isTrue){
//		alert(isTrue);
		$('form').submit();
	}
}

/**
 * 菜品更新检验
 * @param form
 */
function checkUpdateTable(form){
	var val = $("input[name='tableName']").val();
	if(val == "" || !isName(val) ){
		$('form').click(function(event){
		    event.preventDefault();
		});
	}else{
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