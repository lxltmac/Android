function goodsPage(pageNo){
	$("input[name='pageNo']").val(pageNo);
	console.log("search"+$("input[name='pageNo']").val());
	$("#search").submit();
}

//无刷新删除账单
function deletePay(id){
	$.ajax({
		type: "post",
		url : "pay/payAction_deletePay.action",
		data: "id="+id,
		success:function(data){
			if(data == "true"){
				$("#btn-"+id).hide(500);
			}
		}
	});
}


function deleteStaff(id){
	$.ajax({
		type: "post",
		url: "staffAction_deleteStaff.action",
		data: "id="+id,
		success:(function(data){
			if(data == "true"){
				//window.location.href = "staffShowAction_show.action";
				//location.reload();//页面刷新 
				$("#btn-"+id).hide(500);
//				alert(id);
			}
		})
	});
	$("#btn-id").hide();
}

function freezeStaff(id){
	$.ajax({
		type: "post",
		url: "staffAction_freezeStaff.action",
		data: "id="+id,
		success:(function(data){
			if(data == "true"){
				$("#free").removeClass("icon-unlock");
				$("#free").addClass("icon-lock");
				location.reload();
				//alert(id);
			}else{
				$("#free").removeClass("icon-lock");
				$("#free").addClass("icon-unlock");
				location.reload();
			}
		})
	});
}

function unfreezeStaff(id){
	$.ajax({
		type: "post",
		url: "staffAction_unfreezeStaff",
		data: "id="+id,
		success:(function(data){
			if(data == "true"){
				$("#unfree").removeClass("icon-lock");
				$("#unfree").addClass("icon-unlock");
				//alert(id);
				location.reload();
			}else{
				$("#unfree").removeClass("icon-unlock");
				$("#unfree").addClass("icon-lock");
				location.reload();
			}
		})
	});
}