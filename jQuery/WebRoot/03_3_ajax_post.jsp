<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax异步选择城市</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#country").change(function(){
				var country = $(this).val();
				var type = "xml";
				if(country != undefined && country != null){
					//根据国家获取该国的城市列表 并设置到城市下拉框中
					$.post("${pageContext.request.contextPath}/cityServlet?sendType=post&dataType=" + type,
						{"country":country},
						function(data){
							if("json" == type){
								if(data != undefined && data != null){
									//将城市列表设置到城市下拉框中
									var cities = data.cities;
									//清空城市列表
									var $citySelect = $("#city");
									$citySelect.empty();
									
									$.each(cities, function(i, obj){
										$citySelect.append("<option>"+ obj.city +"</option>");
									});
								} else { alert("操作失败。");}
							} else {//解析xml的文本内容
								var $xmlDocument = $(data);
							    var $cities = $xmlDocument.find("city");
							  	//清空城市列表
								var $citySelect = $("#city");
								$citySelect.empty();
								
							    $.each($cities, function(i, obj){//遍历所有的城市列表
							    	//设置城市下拉框中的选项
							    	$citySelect.append("<option>"+ $(obj).text() +"</option>");
							    });
							}
						}
					,type);
				} else {
					alert("请选择国家！");
				}
			});
		});
	</script>
  </head>
  
  <body>
    <div style="width:100%;text-align: center;margin-top: 30px;">
    	国家：<select id="country" style="width:160px;">
    		<option>请选择</option>
    		<option value="中国">中国</option>
    		<option value="美国">美国</option>
    	</select>
    	&nbsp;&nbsp;---&nbsp;&nbsp;
    	城市：<select id="city"></select>
    </div>
  </body>
</html>
