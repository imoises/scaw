<%@ include file="_header.jsp" %>

<div class="align-items-center d-flex cover section-aquamarine py-5"
	style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
	<div class="container">
		<div class="row">

			<div class="col-lg-12 align-self-center text-lg-left text-center">
				<c:choose>

					<c:when test="${not empty error}">
						<%--Bloque que es visible si el elemento error no está vacío--%>
						<h2>
							<span>${error}</span>
						</h2>
					</c:when>
					<c:otherwise>
						<p class="">Las actividades realizadas por el usuario fueron:</p>
						<table class="table container">

							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Descripción</th>
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
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>


<%@ include file="_footer.jsp"%>