<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save or Update Student</title>
</head>

<body>

	<div class="container">

		<h3>Book Directory</h3>
		<hr>

		<p class="h4 mb-4">Enter Book</p>

		<form action="/DebateEventManagement/studentdetails/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="studentId" value="${Student.id}" />

			<div class="form-inline">
				<input type="text" name="FirstName" value="${Student.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>

			<div class="form-inline">

				<input type="text" name="LastName" value="${Student.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>

			<div class="form-inline">

				<input type="text" name="Course" value="${Student.course}"
					class="form-control mb-4 col-4" placeholder="Course">



			</div>
			
			<div class="form-inline">

                <input type="text" name="Country" value="${Student.country}"
                    class="form-control mb-4 col-4" placeholder="Country">



            </div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/DebateEventManagement/studentdetails/list"><b>Back to Student List</b></a>

	</div>
</body>

</html>










