<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

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

	<h3>Driver List</h3>
	<hr>
	
	<!-- Add a button -->
	<a th:href="@{/drivers/showFormForAdd}"
		class="btn btn-primary btn-sm mb-3">
		Add Driver
	</a>
	
	
	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Driver Name</th>
				<th>Track Name</th>
				<th>Crime</th>
				<th>Sentence</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<tr th:each="tempDriver : ${drivers}">
			
				<td th:text="${tempDriver.driverName}" />
				<td th:text="${tempDriver.trackName}" />
				<td th:text="${tempDriver.crime}" />
				<td th:text="${tempDriver.sentence}" />
				
				<td>
					<!-- Add "update" button/link -->
					<a th:href="@{/drivers/showFormForUpdate(driverId=${tempDriver.id})}"
					   class="btn btn-info btn-sm">
						Update
					</a>
					
					<!-- Add "delete" button/link -->					
					<a th:href="@{/drivers/delete(driverId=${tempDriver.id})}"
					   class="btn btn-danger btn-sm"
					   onclick="if (!(confirm('Are you sure you want to eliminate this driver?'))) return false">
						Eliminate
					</a>
					
				</td>
				
				
			</tr>
		</tbody>		
	</table>
	
</div>
	
</body>
</html>