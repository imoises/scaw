<%@ include file="_header.jsp" %>
  <!-- Cover -->
  <div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-5 display-4">Iniciar Sessi�n</h1>
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
          <div class="col-md-12 text-center"><a class="btn btn-link text-light text-right" href="#" contenteditable="true">�Olvidaste la contrase�a?</a></div>
        </div>
      </div>
    </div>
  </div>
  
  <div class="container">
  	<a href="http://localhost:8080/Scaw/registrarse" class="btn mt-4 btn-block p-2 btn-primary">Registrarse</a>
  </div>
  
  <br><br>
  
  <!-- Parallax section -->
  <!-- div class="py-5 photo-overlay section-parallax" id="book" style="background-image: url(&quot;assets/restaurant/makereservation_light.jpg&quot;);">
    <div class="container">
      <div class="row my-5">
        <div class="col-lg-11 mx-auto p-3 animate-in-down" style="">
          <form class="p-4 bg-light" modelAttribute="usuario" method="POST">
            <h4 class="mb-4 text-center">Registarse</h4>
            <p class="my-4" contenteditable="true">Bienvenidos a la aplicaci�n! Complete el formulario con sus datos y las preguntas para la recuperacion de su contrase�a.</p>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nick</label>
                  <input class="form-control" path="nick" type="text"> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Email</label>
                  <input class="form-control" path="email" type="text"> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Contrase�a</label>
                  <input type="password" path="password" class="form-control"> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>�Pregunta 1?</label>
                  <input class="form-control" type="text"> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Confirmar contrase�a</label>
                  <input type="password" class="form-control"> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>�Pregunta 1?</label>
                  <input class="form-control" type="text"> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nombre</label>
                  <input class="form-control" path="nombre" type="text"> </div>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>�Pregunta 1?</label>
                  <input class="form-control" type="text"> </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Apellido</label>
                  <input class="form-control" path="apellido" type="text"> </div>
              </div>
              <div class="col-md-6"></div>
            </div>
            <div class="row">
              <div class="col-md-6"></div>
              <div class="col-md-6"><button type="submit" class="btn mt-4 btn-block btn-primary p-2" style=""  formaction="registrarusuario"><b class="">Registarse</b></button></div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div -->
  
  
 <%@ include file="_footer.jsp" %>