$(function(){
	$("#btn-edit").click(function(){
		$("#btn-noedit").show(500);
		$("#gro-styleName").show(500);
	});
	$("#btn-noedit").click(function(){
		$("#btn-noedit").hide(500);
		$("#gro-styleName").hide(500);
	});
});
//无刷新删除菜品
function deleteFood(id){
	$.ajax({
		type: "post",
		url : "goods/foodStyleAction_deleteFoodStyle.action",
		data: "id="+id,
		success:function(data){
			if(data == "true"){
				$("#btn-"+id).hide(500);
			}
		}
	});
}
