$(function(){
	//监听省的选择
	if($("#proSel").length > 0){
		$("#proSel").change(function(){
			var provinceID = $('#proSel option:selected').attr('value');
			getCity(provinceID);
		});
	}
	
});

//通过json的方式得到市
function getCity(provinceID){
	$.ajax({
		type: "post",
		url: "commonAction_getCitys", 
		data: "provinceID="+ provinceID,
		success: function(data){
			console.log("getCtiy data="+data);
			var jsonobject = eval("(" + data + ")");
			var cityHtml = "<option value='0' disabled selected='selected'>请选择：</option>";
			for(var i=0;i<jsonobject.length;i++){
				if(jsonobject[i] != null){
					cityHtml += "<option value="+ jsonobject[i].cityID +">"+ jsonobject[i].city +"</option>";
				}
			}
			$("#citySel").html(cityHtml);
		}
	});
}