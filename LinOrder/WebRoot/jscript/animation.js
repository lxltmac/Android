function login(form){
	var htmlLog = "<img width='20px' src='image/beam/loading2.gif' /> Loading...";
	$("#myButton").html(htmlLog);
	$.ajax({
		type: "post",
		url: "staffAction_loginCheck",
		data:"name=" + form.name.value + "&password=" + form.password.value,
		async: false,
		success: function(data){
			if(data == "true"){
				console.log("data is true");
//				$("#js_wrap").show(200);
//				$(".form-signin").hide();
				document.forms[0].action="admin_main.jsp";
				document.forms[0].submit();
				return true;
			}else{
				$("#myButton").html("登录");
				$("input[name='password']").val("");
				$("input[name='password']").focus();
				if($("input[name='name']").length>0 && $("input[name='password']").length>0 ){
					$("#loginVer").show(100);
				}
				return false;
			}
		}
	});
}
