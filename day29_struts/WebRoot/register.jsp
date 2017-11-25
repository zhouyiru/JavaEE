<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'login.jsp' starting page</title>  
  </head>
  
  <body>
    
    <form action="${pageContext.request.contextPath }/data/user_register.action" method="post">
    	用户名： <input type="text" name="user.name"/><br/>
    	密码： <input type="password" name="user.password"/><br/>
    	性别： <input type="radio" name="user.gender" value="男"/>男
    	 <input type="radio" name="user.gender" value="女"/>女<br/>
    	爱好：
    	<input type="checkbox" name="user.hobit" value="篮球"/>篮球
    	<input type="checkbox" name="user.hobit" value="足球"/>足球
    	<input type="checkbox" name="user.hobit" value="羽毛球"/>羽毛球<br/>
    	<input type="submit" value="注册"/>
    	 
    </form>
    
    
  </body>
</html>
