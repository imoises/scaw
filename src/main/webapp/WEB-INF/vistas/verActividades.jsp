<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- PAGE settings -->
  <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico">
  <title>Login TP Seguridad y Calidad Web</title>
  <meta name="description" content="Free Bootstrap 4 Pingendo Aquamarine template for restaurant and food">
  <meta name="keywords" content="Pingendo restaurant food aquamarine free template bootstrap 4">
  <!-- CSS dependencies -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="../css/aquamarine.css" type="text/css">
  <!-- Script: Make my navbar transparent when the document is scrolled to top -->
  <script src="../js/navbar-ontop.js"></script>
  <!-- Script: Animated entrance -->
  <script src="../js/animate-in.js"></script>
</head>


<div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
	<div class="container">
		<div class="row">

			<div class="col-lg-12 align-self-center text-lg-left text-center">
				<p class="">Las actividades realizadas por el usuario fueron:</p>
				<table class="table container">

					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Descripci�n</th>
							<th scope="col">Fecha</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${actividades}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.descripcion}</td>
								<td>${item.fecha}</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
				<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
					<h4>
						<span>${error}</span>
					</h4>
					<br>
				</c:if>
			</div>

		</div>
	</div>
</div>


<%@ include file="_footer.jsp"%>