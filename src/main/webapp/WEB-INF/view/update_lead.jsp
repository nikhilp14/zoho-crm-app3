<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create lead</title>
</head>
<body>
<h2> LEAD | CREATE</h2>
<form action ="updateAllLead" method="post">
<pre>
<input type="hidden" name="id" value="${leadss.id}"/>
First Name <input type="text" name="firstName" value="${leadss.firstName}"/>
Last Name   <input type="text" name="lastName" value="${leadss.lastName}"/>
Email      <input type="text" name="email" value="${leadss.email}"/>
Mobile     <input type="text" name="mobile" value="${leadss.mobile}"/>
           <input type="submit" value="save"/>
</pre>
</form>
${msg}
</body>
</html>