<%@ include file="_header.jsp" %>
  <!-- Cover -->
  <div class="align-items-center d-flex cover section-aquamarine py-5" >
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
            
            <div class="form-group"> <label>Contraseña</label>
              <form:input path="password" type="password" id="password" class="form-control" /> </div>
            
             <div class="g-recaptcha" data-sitekey="6LcElaUUAAAAAOZxPrHTkfaFYnyAxT8rItmCWPhl"></div>
            
 
            
            <button type="submit" class="btn mt-4 btn-block p-2 btn-primary"><b>Ingresar</b></button>
          </form:form>
		  <%--Bloque que es visible si el elemento error no estÃƒÂ¡ vacÃƒÂ­o	--%>
		  <c:if test="${not empty error}">
			<h4><span><p style="color:red;">${error}</p></span></h4>
			
			<br>
		  </c:if>
          <div class="col-md-12 text-center"><a class="btn btn-link text-light text-right" href="forgot_password">¿Olvidaste la contraseña?</a></div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- div class="container">
  	<a href="http://localhost:8080/Scaw/registrarse" class="btn mt-4 btn-block p-2 btn-primary">Registrarse</a>
  </div-->
  
  <!-- Parallax section -->

  
 <%@ include file="_footer.jsp" %>