//$(function(){
//	$("#btn-edit").click(function(){
//		$("#gro-foodName").toggle(500);
//		$("#btn-edit").text("不修改");//改变文本
//		$("#btn-edit").attr("id","btn-e");//改变id值
//	});
//	$("#btn-e").click(function(){
//		$("#btn-e").text("修改");
//		$("#btn-e").attr("id","btn-edit");
//	});
//});
$(function(){
	$("#btn-edit").click(function(){
		$("#btn-noedit").show(500);
		$("#gro-foodName").show(500);
	});
	$("#btn-noedit").click(function(){
		$("#btn-noedit").hide(500);
		$("#gro-foodName").hide(500);
	});
});
//无刷新删除菜品
function deleteFood(id){
	$.ajax({
		type: "post",
		url : "goods/foodAction_deleteFood.action",
		data: "id="+id,
		success:function(data){
			if(data == "true"){
				$("#btn-"+id).hide(500);
			}
		}
	});
}

//前台用户
$(function(){
	$("#btn-userEdit").click(function(){
		$("#btn-noUserEdit").show(500);
		$("#gro-username").show(500);
	});
	$("#btn-noUserEdit").click(function(){
		$("#btn-noUserEdit").hide(500);
		$("#gro-username").hide(500);
	});
});