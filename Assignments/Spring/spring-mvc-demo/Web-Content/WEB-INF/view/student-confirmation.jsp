<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<br>
The student details are: ${student.firstName} ${student.lastName} from ${student.country} with the favorite language being ${student.favoriteLanguage} with the following OS options:
<br>
Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">

		<li> ${temp} </li>

	</c:forEach>
</ul>
</body>

</html>