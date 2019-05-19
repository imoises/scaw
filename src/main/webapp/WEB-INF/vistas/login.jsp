<%@ include file="_header.jsp" %>
  <!-- Cover -->
  <div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-5 display-4">Iniciar Sesión</h1>
          <p class="mb-5">Login</p>
        </div>
        <div class="col-lg-5 p-3">
          <form:form action="validar-login" method="POST" modelAttribute="usuario">
            <h4 class="mb-4 text-center">Login</h4>
            <div class="form-group"> <label>Nick</label>
              <form:input path="nickname" id="nickname" type="text" class="form-control" /> </div>
            <div class="row">
            </div>
            <div class="form-group"> <label>Contraseña</label>
              <form:input path="password" type="password" id="password" class="form-control" /> </div>
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>Ingresar</b></button>
          </form:form>
		  <%--Bloque que es visible si el elemento error no estÃƒÂ¡ vacÃƒÂ­o	--%>
		  <c:if test="${not empty error}">
			<h4><span>${error}</span></h4>
			<br>
		  </c:if>	
          <div class="col-md-12 text-center"><a class="btn btn-link text-light text-right" href="#" contenteditable="true">¿Olvidaste la contraseña?</a></div>
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
          <form:form action="validar-registrarse" modelAttribute="modeloRegistrarse" method="POST">
            <h4 class="mb-4 text-center">Registarse</h4>
            <p class="my-4" contenteditable="true">Bienvenidos a la aplicación! Complete el formulario con sus datos y las preguntas para la recuperacion de su contraseña.</p>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nick</label>
                  <form:input path="nickname" type="text" class="form-control" placeholder="nick" /> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Email</label>
                  <form:input path="email" type="email" class="form-control" placeholder="email"/> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Contraseña</label>
                  <form:input path="password" type="password" class="form-control" placeholder="contraseña" /> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>¿Pregunta 1?</label>
                  <form:input path="pregunta" class="form-control" type="text" placeholder="pregunta 1" /> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Confirmar contraseña</label>
                  <form:input path="confirmaPassword" type="password" class="form-control" placeholder="confirmaContraseña" /> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Respuesta</label>
                  <form:input path="respuesta" class="form-control" type="text" placeholder="respuesta" /> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nombre</label>
                  <form:input path="nombre" type="text" class="form-control" placeholder="nombre" /> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Confirmar respuesta</label>
                  <form:input path="confirmaRespusta" class="form-control" type="text" placeholder="confirmar respuesta" /> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Apellido</label>
                  <form:input path="apellido" type="text" class="form-control" placeholder="apellido" /> </div>
              </div>
              <div class="col-md-6"></div>
            </div>
            <div class="row">
              <div class="col-md-6"></div>
              <div class="col-md-6"><button type="submit" class="btn mt-4 btn-block btn-primary p-2" style=""  formaction="validar-registrarse"><b class="">Registarse</b></button></div>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
  
  
 <%@ include file="_footer.jsp" %>