<%@ include file="_header.jsp" %>
  <!-- Cover -->
  <div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-5 display-4">Iniciar Sesi�n</h1>
          <p class="mb-5">Login</p>
        </div>
        <div class="col-lg-5 p-3">
          <form:form action="validar-login" method="POST" modelAttribute="usuario">
            <h4 class="mb-4 text-center">Login</h4>
            <div class="form-group"> <label>Nick</label>
              <form:input path="nickname" id="nickname" type="text" class="form-control" /> </div>
            <div class="row">
            </div>
            <div class="form-group"> <label>Contrase�a</label>
              <form:input path="password" type="password" id="password" class="form-control" /> </div>
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>Ingresar</b></button>
          </form:form>
		  <%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
		  <c:if test="${not empty error}">
			<h4><span>${error}</span></h4>
			<br>
		  </c:if>
          <div class="col-md-12 text-center"><a class="btn btn-link text-light text-right" href="forgot_password">�Olvidaste la contrase�a?</a></div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- div class="container">
  	<a href="http://localhost:8080/Scaw/registrarse" class="btn mt-4 btn-block p-2 btn-primary">Registrarse</a>
  </div-->
  
  <!-- Parallax section -->
  

  
  
  
  <div class="py-5 photo-overlay section-parallax" id="book" style="background-image: url(&quot;assets/restaurant/makereservation_light.jpg&quot;);">
    <div class="container">
      <div class="row my-5">
        <div class="col-lg-11 mx-auto p-3 animate-in-down" style="">
          <form:form action="registrarUsuario" modelAttribute="usuario" method="POST">
            <h4 class="mb-4 text-center">Registarse</h4>
            <p class="my-4" contenteditable="true">Bienvenidos a la aplicaci�n! Complete el formulario con sus datos para crear una cuenta nueva.</p>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nick</label>
                  <form:input path="nickname" type="text" class="form-control" required="required" /> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Email</label>
                  <form:input path="email" type="email" class="form-control" required="required"/> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Contrase�a</label>
                  <form:input path="password" type="password" class="form-control" required="required" pattern=".{12,}" title="La contrase�a debe tener al menos 12 caracteres"/> </div>
              </div>
              <!--div class="col-md-6">
                <div class="form-group"> <label>Confirmar contrase�a</label>
                  <input type="password" class="form-control"> </div>
              </div-->
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nombre</label>
                  <form:input path="nombre" type="text" class="form-control" required="required" /> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Apellido</label>
                  <form:input path="apellido" type="text" class="form-control" required="required" /> </div>
              </div>
            </div>
            <c:if test="${not empty msgRegistrarExito || not empty msgRegistrarError }">
				<script type="text/javascript">
				window.onload = function () {
					    // Handler for .ready() called.
					    $('html, body').animate({
					        scrollTop: $('#book').offset().top
					    }, 'slow');
					};
				</script>
				<c:if test="${not empty msgRegistrarExito}">
					<p style="color: green;">${msgRegistrarExito}</p>
				</c:if>
				<c:if test="${not empty msgRegistrarError}">
					<p style="color: red;">${msgRegistrarError}</p>
				</c:if>
			</c:if>
            <div class="row">
              <div class="col-md-12"><button type="submit" class="btn mt-4 btn-block btn-primary p-2" ><b >Registarse</b></button></div>
            </div>
          </form:form>
          
          
        </div>
      </div>
    </div>
  </div>
  
  
 <%@ include file="_footer.jsp" %>