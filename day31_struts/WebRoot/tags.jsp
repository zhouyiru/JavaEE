<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'tags.jsp' starting page</title> 
    <style type="text/css">
    	/*奇数行的样式*/
    	.odd{
    		background-color: gray;
    	}
    	/*偶数行的样式*/
    	.even{
    		background-color: red;
    	}
    </style> 
  </head>
  
  <body>
    <%-- ognl表达式： 在jsp页面中创建List集合(不需要#) --%>
  	<s:iterator value="{'eric','jacky','rose','lucy'}" var="name">
  		<s:property value="#name"/><br/>
  	</s:iterator>  
    
    <hr/>
     <%-- ognl表达式： 在jsp页面中创建Map集合（需要#号） --%>
    <s:iterator value="#{1:'eric',2:'jacky',3:'rose',4:'lucy'}" var="entry">
  		编号： <s:property value="#entry.key"/>-姓名：<s:property value="#entry.value"/><br/>
  	</s:iterator>
  	
  	  
    <hr/>
    <%-- value: 属性写ognl表达式 --%>
    <s:set id="userName" var="userName" value="%{'eric'}"></s:set>
    
    
    
    <%-- 问题 : 这里的value属性的值，struts不把内容当做ognl内容解析 --%>
    <s:textfield name="userName" value="%{#request.userName}"></s:textfield>
    
    <hr/>
    
    <s:bean name="gz.itcast.b_validate.User" var="user">
       <s:param name="name" value="%{'zhang'}"></s:param>
       <s:param name="password" value="34"></s:param>
	</s:bean>
    
    <s:property value="#request.user.name"/> - <s:property value="#request.user.password"/>
    
    <hr/>
    
    <table border="1">
    	<tr>
    		<th>序号</th>
    		<th>编号</th>
    		<th>姓名</th>
    	</tr>
    	<s:iterator value="#{'101':'eric','102':'jacky','103':'rose','104':'lucy'}" var="entry" status="sta">
    	<tr class="<s:property value="#sta.even?'even':'odd'"/>">
    		<td><s:property value="#sta.count"/></td>
    		<td><s:property value="#entry.key"/></td>
    		<td><s:property value="#entry.value"/></td>
    	</tr>
    	</s:iterator>
    </table>
    
    <hr/>
    <s:set var="age" value="21"></s:set>
    
    
    <s:if test="#age==23">
		23
	</s:if>
	<s:elseif test="#age==21">
		21
	</s:elseif>
	<s:else>
		都不等
	</s:else> 
    
    <hr/>
    
    <%--生成一个链接的url内容 --%>
    <s:url action="user_register" namespace="/validate" var="myurl">
    </s:url>
    <%--使用url链接 --%>
    <a href="<s:property value="#myurl"/>">链接到UserAction</a>
    
    
    <s:debug></s:debug>
  </body>
</html>
