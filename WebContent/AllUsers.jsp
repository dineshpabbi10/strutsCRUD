<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">

<style>
#example_wrapper{
	width:90%;
	margin:auto;
}

.nav{
height:45px;
margin-bottom:10px;
width:100%;
background-color:#002884;
color: white;
font-weight:bold;
display:flex;
align-items:center;
justify-content:center;
}
</style>
</head>
<body>
<div class="nav">
	Employee Records
</div>
<table id="example" class="table table-striped table-bordered" style="width:100%">
<thead>
<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Salary</th>
			<th>Edit </th>
			<th>Delete </th>
</tr>
</thead>

<s:iterator value = "employees">
<tr>
         <td><s:property value = "id"/></td>
         <td><s:property value = "name"/></td>
         <td><s:property value = "email"/></td>
         <td><s:property value = "salary"/></td>
          
         <td>
         	<s:url action="editEmployees.action" var="URLtag">
		    <s:param name="emp.id"><s:property value = "id"/></s:param>
		    </s:url> 
		    <a data-toggle="tooltip" data-placement="top" title="Edit Record" class="btn btn-primary" href="<s:property value="#URLtag" />">Edit</a>
         </td>
         <td>
         <s:url action="deleteEmployees.action" var="URLtag">
		    <s:param name="emp.id"><s:property value = "id"/></s:param>
		    </s:url> 
		    <a data-toggle="tooltip" data-placement="top" title="Delete Record" class="btn btn-danger" href="<s:property value="#URLtag" />">Delete</a>
         </td>
</tr>
</s:iterator>

</table>


<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );

$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
</script>
</body>
</html>