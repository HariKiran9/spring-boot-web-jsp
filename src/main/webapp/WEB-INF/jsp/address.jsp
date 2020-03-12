<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />



<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />



<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<table id="example" class="display" style="width: 100%">
				<thead>
					<tr>
						<th>City Id</th>
						<th>City</th>
						<th>Address Id</th>
						<th>Address</th>
						<th>Address2</th>
						<th>District</th>
						<th>Postal Code</th>
						<th>Phone</th>						
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty cities}">
						<c:forEach var="listValue" items="${cities}">
							<tr>
								<td>${listValue.cityId}</td>
								<td>${listValue.city}</td>
								<td>${listValue.address.addressId}</td>
								<td>${listValue.address.address}</td>
								<td>${listValue.address.address2}</td>
								<td>${listValue.address.district}</td>
								<td>${listValue.address.postalCode}</td>
								<td>${listValue.address.phone}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>

	</div>
	<!-- /.container -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable({
				"pagingType" : "full_numbers"
			});
		});
	</script>


	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
