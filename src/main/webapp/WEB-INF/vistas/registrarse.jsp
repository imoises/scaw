<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
	<h2>Registrar usuario</h2>
	
	<div class="panel-body">
    	<form:form action="registrarusuario" modelAttribute="usuario" method="POST">
		  
		  <div class="form-group row">
			  <label class="col-lg-2 control-label">Nick:</label>
			  <div class="col-lg-10">
			  	<form:input path="nickname" type="text" />
			  </div>
		  </div>
		  
		  <div class="form-group row">
			  <label class="col-lg-2 control-label">Nombre:</label>
			  <div class="col-lg-10">
			  	<form:input path="nombre" type="text" />
			  </div>
		  </div>
		  
		  <div class="form-group row">
			  <label class="col-lg-2 control-label">Apellido:</label>
			  <div class="col-lg-10">
			  	<form:input path="apellido" type="text" />
			  </div>
		  </div>
		  
		  <div class="form-group row">
			  <label class="col-lg-2 control-label">Email:</label>
			  <div class="col-lg-10">
			  	<form:input path="email" type="email" />
			  </div>
		  </div>
		  
		  <div class="form-group row">
			  <label class="col-lg-2 control-label">Contraseña:</label>
			  <div class="col-lg-10">
			  	<form:input path="password" type="password" />
			  </div>
		  </div>
		  
		  
		  <!-- div id="divMessagesP" style="display: none;">
				<p align="left">
				<div class="alert alert-danger" style="text-align: left;">
					<label id="lblErrorP"
						style="font-size: 12px; color: firebrick; font-weight: bold; margin-left: 5px;"></label>
				</div>
				</p>
		  </div -->
		
		  <div class="form-group row">
	  		  <div class="col-lg-2"></div>
	  		  <div class="col-lg-10">
			    <button type="submit" class="btn btn-success">Registrarse</button>
			  </div>
		  </div>
		  
		</form:form>
	</div>
	
	
	
</body>
</html>