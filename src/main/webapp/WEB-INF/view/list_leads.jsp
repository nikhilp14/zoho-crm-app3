<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list lead</title>
</head>
<body>
<h2>LIST ALL LEADS</h2>
<table>
   <tr>
     <th>FirstName</th>
     <th>LastName</th>
     <th>Email</th>
     <th>Mobile</th>
     <th>Actions</th>
  </tr>
<c:forEach var="leads" items="${leads}">
   <tr>
     <td>${leads.firstName}</td>
     <td>${leads.lastName}</td>
     <td>${leads.email}</td>
     <td>${leads.mobile}</td>
     <td><a href="delete?id=${leads.id}">Delete</a>
     <a href="update?id=${leads.id}">Update</a>
     </td>
   </tr>
</c:forEach>

</table>
</body>
</html>