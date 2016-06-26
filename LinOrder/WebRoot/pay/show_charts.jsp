<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>系统后台界面</title>
<!-- Bootstrap -->
	<script type="text/javascript" src="jscript/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="jscript/app.js"></script>
	<script type="text/javascript" src="jscript/menu.js"></script>
	<script type="text/javascript" src="jscript/bootstrap.min.js"></script>
	<script type="text/javascript" src="jscript/animation.js"></script>
	<script type="text/javascript" src="jscript/admincommon.js"></script>
	<script type="text/javascript" src="jscript/echarts.js"></script>
	<script type="text/javascript" src="jscript/user/aja.js"></script>
	<script type="text/javascript" src="jscript/jquery.bootpag.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-metro.css"/>
	<link rel="stylesheet" type="text/css" href="css/default.css"/>
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/style-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="css/animation.css"/>
</head>
  <body class="page-header-fixed">
	<jsp:include page="../admin_top.jsp" flush="true" />
	<jsp:include page="../admin_left.jsp" flush="true" />
    <div class="page-content">
    	<div class="container-fluid">
			 <h2 class="page-title">账单</h2>
			 	<ul class="breadcrumb">
					<li>
						<i class="icon-home"></i>
						<a href="admin_main.jsp">首页</a> 
						<i class="icon-angle-right"></i>
					</li>
					<li>
						<a>账单管理</a>
						<i class="icon-angle-right"></i>
					</li>
					<li><a href="<%=basePath %>user/userShowAction_show.action">账单信息</a></li>
				</ul>
			 <div class="tabbable tabbable-custom tabbable-full-width">
			   <ul class="nav nav-tabs">
				  <li role="presentation"><a href="<%=basePath %>pay/payShowAction_show.action">账单信息</a></li>
				  <li role="presentation" class="active"><a>账单统计</a></li>
				</ul>
	          <div class="table-responsive">
	           		<div id="main" style="width: 900px;height:600px;"></div>
				<script type="text/javascript">
				var label=[];
 				var value=[];
 				var s = [];
 				var q = 0;
 				var o = [];
 				var x = [];
 				var m = [];
 				var t = 0;
 				var j = 0;
 				var f = 0;
 				var h = 0;
 				var l = 0;
 				var a = 0;
 				var e = 0;
 				var y = 0;
 				var n = 0;
 				var b = 0;
 				var v = 0;
				$.ajax({
                       type: "post",
                        url: "pay/payShowAction_showJson.action",
                        dataType:"json",
                        success: function (data) {
                        	var jsonobject = eval(data);
                            
                            $.each(data,function(i,p){
                            label[i]=p['payTableNum'];
                            value[i]={'name':p['payTableNum'],'value':p['payPrice'],'month':p['month']};
                            s[i]=value[i].value;
                            x[i]=value[i].name;
                            m[i]=value[i].month;
                            
                            });
                            //o[3] = q;
                            for(var i=0;i<s.length;i++){
                               // q+=s[i]*1;
                                if(m[i]==4){
                            	q+=s[i]*1;
                            	o[3] = q;
                            }
                            else if(m[i]==3){
                            	t+=s[i]*1;
                            	o[2] = t;
                            }else if(m[i]==2){
                            	j+=s[i]*1;
                            	o[1] = j;
                            }else if(m[i]==1){
                            	f+=s[i]*1;
                            	o[0] = f;
                            }else if(m[i]==5){
                            	l+=s[i]*1;
                            	o[4] = l;
                            }else if(m[i]==6){
                            	h+=s[i]*1;
                            	o[5] = h;
                            }else if(m[i]==7){
                            	a+=s[i]*1;
                            	o[6] = a;
                            }else if(m[i]==8){
                            	e+=s[i]*1;
                            	o[7] = e;
                            }else if(m[i]==9){
	                         	y+=s[i]*1;
	                         	o[8] = y;
                            }else if(m[i]==10){
                            	n+=s[i]*1;
                            	o[9] = n;
                            }else if(m[i]==11){
                            	b+=s[i]*1;
                            	o[10] = b;
                            }else if(m[i]==12){
                            	v+=s[i]*1;
                            	o[11] = v;
                               }
                            }
                            //alert(q);
                            // 基于准备好的dom，初始化echarts实例
                            var myChart = echarts.init(document.getElementById('main'));
                            // 指定图表的配置项和数据
                          	 var option = {
						         tooltip: {
						        trigger: 'axis'
						            },
						            toolbox: {
						                feature: {
						                    dataView: {show: true, readOnly: false},
						                    magicType: {show: true, type: ['line', 'bar']},
						                    restore: {show: true},
						                    saveAsImage: {show: true}
						                }
						            },
						            legend: {
						                data:['金额','桌号']
						            },
						            xAxis: [
						                {
						                    type: 'category',
						                    name: '月份',
						                   // data: x
						                    data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
						                }
						            ],
						            yAxis: [
						                {
						                    type: 'value',
						                    name: '金额',
						                    min: 0,
						                    max: 10000,
						                    interval: 1000,
						                    axisLabel: {
						                        formatter: '{value} 元'
						                    }
						                },
						            ],
						            series: [
						                {
						                    name:'金额',
						                    type:'bar',
						                    data:o
						                }, 
						            ]
						                };
						
						        // 使用刚指定的配置项和数据显示图表。
						        myChart.setOption(option);
                           }
				});
				</script>
            </div>
		 </div>
	   </div>
	</div>
	<jsp:include page="../admin_footer.jsp" flush="true" />
  </body>
</html>
