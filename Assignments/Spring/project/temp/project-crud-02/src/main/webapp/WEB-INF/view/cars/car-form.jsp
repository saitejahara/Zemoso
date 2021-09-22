<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<title>Save Car</title>
</head>

<body>

	<div class="container">
	
		<h3>Car Directory</h3>
		<hr>
		
		<p class="h4 mb-4">Save Car</p>
	
		<form action="#" action="/cars/save"
						 object="${car}" method="POST">
		
			<!-- Add hidden form field to handle update -->

			<input type="text" value="${car.carName}"
                                					class="form-control mb-4 col-4" placeholder="Car name">




<!--

<input type="hidden" field="*{id}" />
     			<input type="text" field="*{car.carName}"
     					class="form-control mb-4 col-4" placeholder="Car name">



     					<form:input type="text" path="hotelRating" />

     			<input type="text" field="*{modelYear}"
     					class="form-control mb-4 col-4" placeholder="Model Year">

     			<input type="text" field="*{fuelType}"
     					class="form-control mb-4 col-4" placeholder="Fuel Type">

     			<input type="text" field="*{intakeType}"
     				   class="form-control mb-4 col-4" placeholder="Intake Type">

     			<input type="text" field="*{power}"
     				   class="form-control mb-4 col-4" placeholder="Power">

     			<input type="text" field="*{torque}"
     				   class="form-control mb-4 col-4" placeholder="Torque">

     				    --->

				
			<button type="submit" class="btn btn-info col-2">Save</button>
						
		</form>
	
		<hr>
		<a href="/cars/list">Back to Cars List</a>
		
	</div>
</body>

</html>










