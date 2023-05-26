<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Edit Employee</h1>
		<form:form action="editSubmit" method="post" modelAttribute="employee">

			<div class="form-group">
				<label class="form-label"> Employee name</label>              
				<form:input class="form-control" path="eid" value="${employee.eid}" />
				         
			</div>

			<div class="form-group">
				<label class="form-label"> Employee name</label>              
				<form:input class="form-control" path="ename"
					value="${employee.ename}" />

				         
			</div>
			<div class="form-group">
				<label class="form-label"> Employee address</label>              
				<form:input class="form-control" path="eadd"
					value="${employee.eadd}" />

				         
			</div>
			<div class="form-group">
				<label class="form-label"> Employee salary</label>              
				<form:input class="form-control" path="salary"
					value="${employee.salary}" />

				         
			</div>
			<div class="text-center">
				<form:button class="btn btn-primary">Submit</form:button>
			</div>


    </form:form>
	</div>
</body>
</html>