<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>    
<%@ page import = "java.util.*,java.lang.String" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
<%
System.out.println("yaa, this is jsp page");
%>
<div >

<fmt:setLocale value = '<%= request.getAttribute("theLocale") %>' />
<fmt:setBundle basename = "com.sapientPJP20.assignment.internalization.labels" />
<ul>
<li><a class="active" href = "/home?theLocale=fr_FRA"  >french</a>
</li><li><a href = "/home?theLocale=en_IN" >english</a>
</li><li><a href = "history?theLocale=<%= request.getAttribute("theLocale") %>" ><fmt:message>history</fmt:message></a> 
</li><li><a href = "instructions?theLocale=<%= request.getAttribute("theLocale") %>" >instructions</a> 
</li></ul>
<br/>
<br />
<form  action = "/home">
<input  class = "result" type ="text" name = "data"    
value ="${data }" /> <br/><br/>
<%
String[] actions = new String[]{"one","two","three","four","five","six","seven","eight","nine","zero",
		"addNdays","weekOfMonth","subNdays","dayBefYesterday","nextMonth","nWeeksFromNow","nDaysEarlier",
		"addNweeks","today","lastWeek","nextYear","nDaysFromNow","nWeeksEarlier",
		"subNmonths","addNmonths","tomorrow","prevWeek","lastMonth","nMonthsFromNow","nMonthsEarlier",
		"subNweeks","enter","addDates","subDates","dayOfWeek","yesterday","nextWeek","lastYear","nYearsFromNow"
		,"nDaysEarlier","nYearsEarlier","clear", "comma","slash"};
pageContext.setAttribute("actions",actions);
%>
<div class="btn-group">
<c:forEach var = "action" items = "${actions}">
     <input  type ="submit" name ="${action}" value = '<fmt:message key= "${action}"/>' />
 </c:forEach>
 </div></form></div>
</body>
</html>