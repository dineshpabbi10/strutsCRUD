<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit <s:property value ="user.name" /> </title>
</head>
<body>
<s:form action="updateEmployees">
	<s:textfield key="Email" label="Email" name="emp.email" value="%{emp.email}" />
	<s:textfield key="Name" label="Name" name="emp.name" value = "%{emp.name}" />
	<s:textfield type="number" key="Salary" label="Salary" name="emp.salary" value ="%{emp.salary}"  />
	<s:textfield type= "number" key="id" label="id" name="emp.id" min="%{emp.id}" max="%{emp.id}" value ="%{emp.id}" />
	<s:submit key="Submit"/>
</s:form>
</body>
</html>