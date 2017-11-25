<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'register.jsp' starting page</title>  
    <STYLE type="text/css">
    	ul,ul li{
    		display: inline;
    	}
    	ul li{
    		color:red;
    	}
    </STYLE>
  </head>
  
  <body>
  		<%--打印错误信息--%>
  		<%--<font color="red"><s:fielderror></s:fielderror></font> --%>
  		<s:fielderror fieldName="user.error"></s:fielderror>
     <form action="${pageContext.request.contextPath }/model/user_register" method="post">
      	<s:text name="user"></s:text><input type="text" name="name"/><br/>
      	<s:text name="password"></s:text><input type="password" name="password"/><br/>
      	<%--在当前页面生成token值 --%>
      	<s:token></s:token>
      	<input type="submit" value="<s:text name="login"/>"/>
      </form>
  </body>
</html>
