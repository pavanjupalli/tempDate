<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href = "/home?theLocale=tl_IN" >telugu(INDIA)</a>|
<a href = "/internalization?theLocale=en_IN" >english(INDIA)</a>
<hr />
<%= request.getAttribute("theLocale") %>
<fmt:setLocale value = '<%= request.getAttribute("theLocale") %>' />
<fmt:setBundle basename = "com.sapientPJP20.assignment.internalization.labels" />
<input type = "submit" value = '<fmt:message key= "addNdays"/>'  name = "addNdays"/>


</body>
</html>