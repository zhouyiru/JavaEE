<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'login.jsp' starting page</title>  
  </head>
  
  <body>
    
    <form action="${pageContext.request.contextPath }/convert/user_register.action" method="post">
    	用户名： <input type="text" name="user.name"/><br/>
    	年龄: <input type="text" name="user.age"/><br/>
    	成绩： <input type="text" name="user.score"/><br/>
    	出生日期： <input type="text" name="user.birth"/><br/>
    	<input type="submit" value="注册"/>
    	 
    </form>
    
    
  </body>
</html>
