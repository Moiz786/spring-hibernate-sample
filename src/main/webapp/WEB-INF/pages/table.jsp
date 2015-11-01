<%--
  Created by IntelliJ IDEA.
  User: moiz
  Date: 10/30/2015
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Spring MVC and Ajax : Contact</title>

  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

  <script src="<c:url value="/resources/student.js"/>"></script>

</head>
<body>
<div>
<h2>Find Student By Name</h2>

<label for="search">Search</label>
<input type="text" id="search" name="search">
<div id="info"></div>
<table id="loadTable" >
  <thead>
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age</th>
  </tr>
  </thead>
  <tbody id="tbody">
  <jsp:include page="search.jsp"/>
  </tbody>
</table>
</div>
</body>
</html>
