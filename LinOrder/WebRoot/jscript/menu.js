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
	//��ֹ�û��������̨�û��޸���һ�
	$("#user-edit").click(function(event){
	    event.preventDefault();
	});
	//��ֹ�û������ǰ̨�û��޸���һ�
	$("#username-edit").click(function(event){
	    event.preventDefault();
	});
	//��ֹ�û��������Ʒ�޸���һ�
	$("#food-edit").click(function(event){
	    event.preventDefault();
	});
	//��ֹ�û��������Ʒ�޸���һ�
	$("#foodStyle-edit").click(function(event){
	    event.preventDefault();
	});
	//��ֹ�û�����������޸���һ�
	$("#table-edit").click(function(event){
	    event.preventDefault();
	});
	//��ֹ�û�������������顱
	$("#order_detial").click(function(){
		event.preventDefault();
	});
});