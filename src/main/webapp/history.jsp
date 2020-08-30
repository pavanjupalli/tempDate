<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>    
<%@ page import = "java.util.*,java.lang.String" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="instructions.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value = '<%= request.getAttribute("theLocale") %>' />
<fmt:setBundle basename = "com.sapientPJP20.assignment.internalization.labels" />
<ul class = "home">
<li><a class="active" href = "/home?theLocale=fr_FRA"  >french</a>
</li><li><a href = "/home?theLocale=en_IN" >english</a> 
</li><li><a href = "history?theLocale=<%= request.getAttribute("theLocale") %>" ><fmt:message>history</fmt:message></a> 
</li><li><a href = "instructions?theLocale=<%= request.getAttribute("theLocale") %>" >instructions</a> 
</li></ul>
<br /><br /><br />
<table border ="1" >
<tr><th>inputOne</th><th>InputTwo</th><th>operation</th><th>output</th><th>sessionId</th></tr>
<c:forEach var = "action" items = "${history}" >
<tr>
<td>${action.getInputOne() }</td><td>${action.getInputTwo() }</td><td>${action.getOperation() }</td>
<td>${action.getOutput() }</td><td>${action.getSessionId() }</td>
</tr>
</c:forEach>
</table>
</body>
</html>