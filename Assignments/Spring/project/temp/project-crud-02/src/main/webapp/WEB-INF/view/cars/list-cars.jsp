<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML>
<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<title>Death Race</title>
</head>

<body>

<div class="container">

	<h3>Cars List</h3>
	<hr>

	<!-- Add a button -->
	<a href="/cars/showFormForAdd"
	   class="btn btn-primary btn-sm mb-3">
		Add Car
	</a>


	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
		<tr>
			<th>Car Name</th>
			<th>Model Year</th>
			<th>Fuel Type</th>
			<th>Intake Type</th>
			<th>Power</th>
			<th>Torque</th>
			<th>Action</th>
		</tr>
		</thead>

		<tbody>


		<c:forEach items="${cars}" var="tempCar">
		<tr>
			<td> ${tempCar.carName}</td>
			<td> ${tempCar.modelYear} </td>
			<td> ${tempCar.fuelType} </td>
			<td> ${tempCar.intakeType} </td>
			<td> ${tempCar.power} </td>
			<td> ${tempCar.torque} </td>

			<td>
				<!-- Add "update" button/link -->
				<a href="/cars/showFormForUpdate" name="carId"
				   class="btn btn-info btn-sm">
					Update
				</a>
				<li>
                    <a href="/cars/showFormForUpdate?carId=${tempCar.id}">
                         dsd </a>
                </li>

				<!-- Add "delete" button/link -->
				<a href="/cars/delete(carId=${tempCar.id})"
				   class="btn btn-danger btn-sm"
				   onclick="if (!(confirm('Are you sure you want to dump this car?'))) return false">
					Eliminate
				</a>

			</td>


		</tr>
		</c:forEach>
		</tbody>
	</table>

</div>

</body>
</html>