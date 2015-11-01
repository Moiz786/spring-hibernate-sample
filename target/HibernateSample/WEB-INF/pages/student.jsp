<%--
  Created by IntelliJ IDEA.
  User: moiz
  Date: 10/30/2015
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Spring MVC and Ajax : Student</title>

  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

  <script src="<c:url value="/resources/student.js"/>"></script>

</head>
<body>
<div id="container">

  <h2>Submit new student</h2>
  <form id="saveStudent">
    <div>
      <label for="firstNameInput">First Name</label>
      <input type="text" name="firstName" id="firstNameInput" />
    </div>
    <div>
      <label for="lastNameInput">Last Name</label>
      <input type="text" name="lastName" id="lastNameInput"  />
    </div>
    <div>
      <label for="ageInput">Age</label>
      <input type="text" name="age" id="ageInput" />
    </div>

    <div><input id="submit" type="submit" value="Save Student"></div>
  </form>

  <h2>Edit student by Id</h2>
  <form id="editStudent">
    <div>
      <label for="id">ID:</label>
      <input type="number" name="id" id="id" />
    </div>
    <div>
      <label for="firstName">First Name</label>
      <input type="text" name="firstName" id="firstName" />
    </div>
    <div>
      <label for="lastName">Last Name</label>
      <input type="text" name="lastName" id="lastName"  />
    </div>
    <div>
      <label for="age">Age</label>
      <input type="text" name="age" id="age" />
    </div>

    <div><input id="edit" type="submit" value="Edit Student"></div>
  </form>

  <h2>Delete student By Id</h2>
  <div>
    <label for="firstInput">ID:</label>
    <input type="number" name="firstName" id="firstInput"/>
  </div>

  <button type="button" id="button">Delete</button>

  <br>
  <h2>Students Info</h2>
  <table id="studentTableResponse" class="table tr">
    <thead>
    <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${student}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.age}</td>
      </tr>
    </c:forEach>
    <tr>
      <%--<td id="abc"></td>--%>
    </tr>
    </tbody>
  </table>
</div>

</body>
</html>
