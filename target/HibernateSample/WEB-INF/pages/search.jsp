<%--
  Created by IntelliJ IDEA.
  User: moiz
  Date: 10/30/2015
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${student}" var="student">
  <tr id="tr_${student.id}">
    <td>${student.id}</td>
    <td>${student.firstName}</td>
    <td>${student.lastName}</td>
    <td>${student.age}</td>
  </tr>
</c:forEach>