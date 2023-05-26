<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<meta charset="ISO-8859-1">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js">
	
</script>

<!-- Datatable plugin JS library file -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
	
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table" id="tableID">
			<thead>
				<tr>

					<th>Id</th>
					<th>Name</th>
					<th>Address</th>
					<th>Salary</th>
					<th>Edit</th>
					<th>Delete</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${employees}" var="emp">
					<tr>

						<td>${emp.eid}</td>
						<td>${emp.ename}</td>
						<td>${emp.eadd}</td>
						<td>${emp.salary}</td>
						<td><a href="editEmployee?eid=${emp.eid}"><button
									class="btn btn-primary">Edit</button></a></td>
						<td><a href="deleteEmployee?eid=${emp.eid}"><button
									class="btn btn-danger">Delete</button></a></td>
						<td><a href="viewEmployees?eid=${emp.eid}"><button
									class="btn btn-success">View</button></a></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
		<script>
			/* Initialization of datatable */
			$(document).ready(function() {
				$('#tableID').DataTable({});
			});
		</script>
		<div class="btn-group" role="group"
			aria-label="Basic mixed styles example ">
			<a href="pdf"><button type="button" class="btn btn-warning">PdfGenerator</button></a>
			&nbsp; <a href="excel"><button type="button"
					class="btn btn-success">ExcelGenerator</button></a>&nbsp;
					<!-- <a href="pdf"><button type="button" class="btn btn-success">EmailGeneration</button></a> -->
		</div>
	</div>
</body>
</html>