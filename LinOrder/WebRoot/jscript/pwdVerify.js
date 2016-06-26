function updatePwd(form){
	var newpwd = $("input[name='newPwd']").val();
	var compwd = $("input[name='comPassword']").val();
	if(newpwd == compwd && newpwd != "" && compwd != ""){
		$('form').submit();
	}else{
		$(".updatePwd").show(500);
		$(".modal-body").css("margin-top","-20px");
	}
}