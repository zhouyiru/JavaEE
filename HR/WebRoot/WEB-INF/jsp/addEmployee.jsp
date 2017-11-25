<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEmployee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="doSaveEmployee" method="post">
	 <table>
		    		<tr>
		    			<td>姓名：<input type="text" name="name" id="name" size="20"/></td>
		    			<td>身份证号码：<input type="text" name="cardId" id="cardId" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td>性别：
									<select name="sex">
					    			<option value="0">--请选择性别--</option>
					    			<option value="1">男</option>
					    			<option value="2">女</option>
					    		</select></td>
		    			<td >职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：
		    			 <select name="job_id" style="width:143px;">
					    			<option value="0">--请选择职位--</option>
					    			<c:forEach items="${requestScope.jobs }" var="job">
					    				<option value="${job.id}">${job.name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td>学历：<input name="education" id="education" size="20"/></td>
		    			<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="email" id="email" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td>手机：<input name="phone" id="phone" size="20"/></td>
		    			<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input name="tel" id="tel" size="20"/></td>
		    		</tr>



			
			<tr>
				<td class="font3 fftd">
					政治面貌：<input name="party" id="party" size="40"/>&nbsp;&nbsp;
					QQ&nbsp;&nbsp;号码：<input name="qqNum" id="qqNum" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td class="font3 fftd">
					联系地址：<input name="address" id="address" size="40"/>&nbsp;&nbsp;
					邮政编码：<input name="postCode" id="postCode" size="20"/>
				</td>
			</tr>
			
			<tr>
				<td>
					出生日期：<input onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
					name="birthday" id="birthday" size="40"/>&nbsp;&nbsp;
					民&nbsp;&nbsp;&nbsp;&nbsp;族：<input name="race" id="race" size="20"/>
				</td>
			</tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr>
				<td>
					所学专业：<input  name="speciality" id="speciality" size="40"/>&nbsp;&nbsp;
					爱&nbsp;&nbsp;&nbsp;&nbsp;好：<input name="hobby" id="hobby" size="20"/>
				</td>
			</tr>
			
			<tr>
				<td>
					备&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="remark" id="remark" size="40"/>
					&nbsp;&nbsp;所属部门：
					<select  name="dept_id" >
						   <option value="0">--部门选择--</option>
						   <c:forEach items="${requestScope.depts }" var="dept">
			    				<option value="${dept.id }">${dept.name }</option>
			    			</c:forEach>
					</select>
				</td>
			</tr>
            <tr><td>
			<input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
</table>
  </form>
  </body>
</html>
