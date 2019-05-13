<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
					
			<table class="table container">
				<thead>
					<tr>
				    	<th scope="col">id</th>
				     	<th scope="col">email</th>
				      	<th scope="col">rol</th>
				     	<th scope="col">estado</th>
				    </tr>
				</thead>
				<tbody>
				<c:forEach items="${usuarios}" var="item">
			    	<tr>
				     <td>${item.id}</td>
				     <td>${item.email}</td>
				     <td>${item.rol}</td>
				     <td>${item.estado}</td>
				     <td><a class="btn" href="habilitar-usuario">Habilitar</a></td>
				     
				    </tr>
				</c:forEach> 		  
				
				</tbody>
			</table>
			<%--Bloque que es visible si el elemento error no está vacío	--%>
			<c:if test="${not empty error}">
		        <h4><span>${error}</span></h4>
		        <br>
	        </c:if>	
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
