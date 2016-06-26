function deleteUser(id){
	$.ajax({
		type: "post",
		url : "user/userAction_deleteUser.action",
		data: "id="+id,
		success:function(data){
			if(data == "true"){
				$("#btn-"+id).hide();
			}
		}
	});
}