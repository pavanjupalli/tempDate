<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>        
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
<h2>Instructions:</h2>
<p><fmt:message>note</fmt:message></p>
<p><fmt:message>error</fmt:message></p>
</body>
</html>