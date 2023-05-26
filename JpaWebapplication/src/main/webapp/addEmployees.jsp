<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>${msg}</h1>

		<h1 class="text-center">Add Employee</h1>
		<form:form action="insert" method="post" modelAttribute="employee">

			<div class="form-group">
				<label class="form-label"> Employee name</label>              
				<form:input class="form-control" path="ename" />

				         
			</div>
			<div class="form-group">
				<label class="form-label"> Employee address</label>              
				<form:input class="form-control" path="eadd" />

				         
			</div>
			<div class="form-group">
				<label class="form-label"> Employee salary</label>              
				<form:input class="form-control" path="salary" />

				<div class="row">
					<div class="col-2">
						<label>VERIFY</label>
					</div>
					<div class="col-4">
						<div class="g-recaptcha"
							data-sitekey="6LfxEYMlAAAAACRhnW3SAL7IiwvPwUvhawR22JHY"></div>
					</div>
				</div>
				         
			</div>
			<div class="text-center">
				<form:button class="btn btn-primary" value="addEmployee">Submit</form:button>
			</div>


			<!-- <a href="viewEmployees">viewAllEmployees</a> -->
			<div class="text-center">
				 
				<p>
					<a class="link-opacity-100 " href="viewEmployees">viewEmployees</a>
				</p>
			</div>

    </form:form>

		 
	</div>



</body>
</html>