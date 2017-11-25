<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>查询值栈数据</title>  
  </head>
  
  <body>
  <%-- 1）取出List栈的数据 --%>
  <s:property value="user.name"/> - <s:property value="user.age"/> <br/>
    <s:property value="book.user.name"/> - <s:property value="name"/>
    <%--查看值栈的所有数据 --%>
    <hr/>
    <%--2)取出Map栈的数据 --%>
    <s:property value="#request.request_data"/><br/>
    <%-- 因为值栈对象是通过request域专递到页面，所以可以直接忽略#request去取request域的数据 --%>
    <s:property value="#request_data"/><br/>
    <s:property value="#session.session_data"/><br/>
    <s:property value="#application.application_data"/><br/>
    <%-- #attr : 类似于findAttribute. 依次从小到大在三个域中搜索数据:  #request-> #session -> #application --%>
    <s:property value="#attr.session_data"/><br/>
    <s:property value="#parameters.name"/><br/>
    <hr/>
    ${session_data }
    <hr/>
    <%-- 遍历集合 :List--%>
    <s:iterator value="#request.userList" var="user">
    	姓名： <s:property value="#user.name"/> - <s:property value="#user.age"/><br/>
    </s:iterator>
    <hr/>
     <%-- 遍历集合:Map --%>
    <s:iterator value="#request.userMap" var="entry">
    	编号: <s:property value="#entry.key"/> - 姓名： <s:property value="#entry.value.name"/> - <s:property value="#entry.value.age"/><br/>
    </s:iterator>
    <s:debug></s:debug>
    
  </body>
</html>
