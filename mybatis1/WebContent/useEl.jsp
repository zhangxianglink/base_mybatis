<%@page import="sun.invoke.empty.Empty"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expression Language 简单的使用</title>
</head>
<body>
<% String name = "pony Ma"; 
   String num = "21";
   int a = 21;
   int b = 32;
%>
<%  request.setAttribute("name", name);
	request.setAttribute("a", a);
	request.setAttribute("b", b);
%>
<c:out value="${empty name }"></c:out>
<c:out value="${a+29 }"></c:out>
<c:out value="${a ge b }"></c:out>
</body>
</html>