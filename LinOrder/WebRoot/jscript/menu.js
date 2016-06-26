$(function menuChange(){
	$('ul.page-sidebar-menu li a').each(function(){
		if($($(this))[0].href==String(window.location)){
			 $(this).parents('li').each(function () {
                 $(this).addClass('active');
             });
			 $(this).parents('li').each(function () {
                 $('.arrow', $(this)).addClass('open');
             });
		}
	});
	//禁止用户点击“后台用户修改这一项”
	$("#user-edit").click(function(event){
	    event.preventDefault();
	});
	//禁止用户点击“前台用户修改这一项”
	$("#username-edit").click(function(event){
	    event.preventDefault();
	});
	//禁止用户点击“菜品修改这一项”
	$("#food-edit").click(function(event){
	    event.preventDefault();
	});
	//禁止用户点击“菜品修改这一项”
	$("#foodStyle-edit").click(function(event){
	    event.preventDefault();
	});
	//禁止用户点击“桌号修改这一项”
	$("#table-edit").click(function(event){
	    event.preventDefault();
	});
	//禁止用户点击“订单详情”
	$("#order_detial").click(function(){
		event.preventDefault();
	});
});