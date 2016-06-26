function deleteTable(id){
	$.ajax({
		type: "post",
		url : "table/tableAction_deleteTable.action",
		data: "id="+id,
		success:function(data){
			if(data == "true"){
				$("#btn-"+id).hide(500);
			}
		}
	});
}