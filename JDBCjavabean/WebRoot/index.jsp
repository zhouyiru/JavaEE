<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="java.sql.*,com.code.sqlConn.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";



/*
   String find=request.getParameter("find");
   if(find==null){
   find="";
   }
   db.CreateConnection();
   db.CreateStatement();
   String SQL="";
   if(find.equals("")){
   SQL="select * from emp";
   }
   else{
   SQL="select * from emp where ename like upper('%"+find+"%')";
   }
   ResultSet rs=db.Query(SQL);
   while(rs.next()){
   out.print(rs.getInt("empno")+" "+rs.getString("ename")+"<br>"); 
   }
   db.close();*/
 %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <form method="post">
  <input type="text" name="find"/>
  <input type="submit" value="ËÑË÷">
  </form>  
  <%
     String find=request.getParameter("find");
   if(find==null){
   find="";
   }
   db.CreateConnection();
   db.CreateStatement();
   String SQL="";
   if(find.equals("")){
   SQL="select * from emp";
   }
   else{
   SQL="select * from emp where ename like upper('%"+find+"%')";
   }
   ResultSet rs=db.Query(SQL);
   while(rs.next()){
   out.print(rs.getInt("empno")+" "+rs.getString("ename")+"<br>"); 
   }
   db.close();
   %>
</body>
</html>
