<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'i18n.jsp' starting page</title>  
  </head>
  
  <body>
      <%--获取国际化资源包的内容 --%>
      <form action="#">
      	<s:text name="user"></s:text><input type="text" name="name"/><br/>
      	<s:text name="password"></s:text><input type="password" name="password"/><br/>
      	<input type="submit" value="<s:text name="login"/>"/>
      </form>
  </body>
</html>
