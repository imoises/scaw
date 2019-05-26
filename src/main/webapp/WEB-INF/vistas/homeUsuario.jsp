<%@ include file="_header.jsp"%>

<!-- Intro -->
<div class="py-5 text-center text-white h-100 align-items-center d-flex"
	style="background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg); background-position: center center, center center; background-size: cover, cover; background-repeat: repeat, repeat;">
	<div class="container py-5">
		<div class="row">
			<div class="mx-auto col-lg-8 col-md-10">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link<c:if test="${empty msg}"> show active</c:if>" href="" data-toggle="tab" data-target="#tabone">Guardar texto</a></li>
					<li class="nav-item"><a class="nav-link" href="" data-toggle="tab" data-target="#tabtwo">Historial Actividades</a></li>
					<li class="nav-item"><a class="nav-link<c:if test="${not empty msg}"> show active</c:if>" href="" data-toggle="tab" data-target="#tabthree">Cambiar contraseña</a></li>
				</ul>
				<div class="tab-content mt-2">
					<div class="tab-pane fade<c:if test="${empty msg}"> show active</c:if>" id="tabone" role="tabpanel">
						<h1 class="display-3 mb-4">Usuario</h1>
						<p class="">Ingrese un texto no mayor a 300 caracteres.</p>
						<form:form action="guardarComentario" method="POST" modelAttribute="textoModel">
							<div class="form-group">
								<!-- input type="textarea" class="form-control" style=""-->
								<form:textarea path="descripcion" rows="5" cols="30" />
							</div>
							<button type="submit" class="btn btn-lg btn-primary mx-1" contenteditable="true">Guardar</button>
						</form:form>
					</div>
					<div class="tab-pane fade" id="tabtwo" role="tabpanel">
						<p class="">Las actividades realidas por el usuario fueron:</p>
						<div class="table-responsive">
							<table class="table table-striped table-dark">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">Descripción</th>
										<th scope="col">Fecha</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${keyListaActividades}" var="item">
										<tr>
											<th scope="row">${item.id}</th>
											<td>${item.descripcion}</td>
											<td>${item.fecha}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="tab-pane fade<c:if test="${not empty msg}"> show active</c:if>" id="tabthree" role="tabpanel">
						<p>Modificar contraseña:</p>
						<form:form action="resetPassword" modelAttribute="usuario" method="POST">
							<div class="form-group row">
								<label class="col-lg-6 control-label">Contraseña actual:</label>
								<form:input class="form-control col-lg-6" path="password" type="password" required="required" />
							</div>
							<div class="form-group row">
								<label class="col-lg-6 control-label">Contraseña nueva:</label>
								<input class="form-control col-lg-6" type="password" id="password_new" name="newPassword" pattern=".{12,}" required title="La nueva contraseña debe tener al menos 12 caracteres" />
							</div>
							<div class="form-group row">
								<div class="col-lg-10">
									<button type="submit" class="btn btn-success">Cambiar contraseña</button>
								</div>
							</div>
							<c:if test="${not empty msg}">
								<h4>
									<span>${msg}</span>
								</h4>
								<br>
							</c:if>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="_footer.jsp"%>