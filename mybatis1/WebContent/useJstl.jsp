<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%-- <jsp:useBean id="person" class="cn.magic.pojo.Person"></jsp:useBean> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- out标签    -->
<c:out value="out 常量"></c:out><br>
<% request.setAttribute("nickname","铁掌水上漂");
%>
<c:out value="out 变量 ${nickename}"></c:out> <br>
<c:out value="${a}" default="a哥"></c:out><br>
<c:out value="&ltout转义&gt" escapeXml="false"></c:out><br><br>

<!-- set标签 -->
<c:set value="存值到scope" var="day" scope="session"></c:set>
<c:out value="${day }"></c:out><br>
<!-- 向person类里面赋值 -->
<c:set target="${person }" property="age" value="12"></c:set>
<c:out value="${person.age }"></c:out><br> 
<c:set target="${person}" property="country" >中国</c:set>
<c:out value="${person.country }"></c:out><br>

<!-- remove标签，只能remove某个单独的变量 -->
<br>
<c:set var="xx" scope="request">aaa</c:set>
<c:out value="${xx }"></c:out>
<c:remove var="xx"/>
<c:out value="${xx }" default="xx"></c:out>

<!-- catch -->

<!-- if标签 -->
<form action="useJstl.jsp" method="post">
<input type="text" name="age" value="${param.age }">
<input type="submit" value="提交">
</form>
<c:if test="${param.age >18}" scope="application" var="result">
  <c:out value="恭喜你发育成熟了"></c:out>
</c:if>
<c:out value="${applicationScope.result }"></c:out>

<!-- choose-when-otherwise -->
<c:choose>
  <c:when test="${param.age>=1 && param.age< 8 }">
     <c:out value="小家伙"></c:out>
  </c:when>
  <c:when test="${param.age>=8 && param.age< 14 }">
     <c:out value="小男子汉"></c:out>
  </c:when>
  <c:otherwise>
     <c:out value="hello world"></c:out>
  </c:otherwise>
</c:choose>


 <% ArrayList<Object> arrs = new ArrayList<>();
   arrs.add("one");
   arrs.add("two");
   arrs.add("three");
   arrs.add("four");  
   arrs.add("five");
   arrs.add("six");
   request.setAttribute("arrs", arrs);
  %>
<c:forEach var="arr" items="${arrs}" >
   <c:out value="${arr}"></c:out>
</c:forEach> 
</body>
</html>