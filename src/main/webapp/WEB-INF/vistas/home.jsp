<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenidos a SCAW</h1>
		</div>
		<c:out value="${sessionScope.ROL}"/>
		<c:if test = "${sessionScope.ROL == 'admin'}">
         <p><a class="btn " href="administrar">Administrar Usuarios</a></p>  
      	</c:if>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>