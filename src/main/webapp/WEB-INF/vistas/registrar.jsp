<%@ include file="_header.jsp" %>

  
  <div class="py-5 photo-overlay section-parallax" id="book" >
    <div class="container">
      <div class="row my-5">
        <div class="col-lg-11 mx-auto p-3 animate-in-down" style="">
          <form:form action="registrarUsuario" modelAttribute="usuario" method="POST" commandName="usuario">
            <h4 class="mb-4 text-center">Registarse</h4>
            <p class="my-4" contenteditable="true">Bienvenidos a la aplicación! Complete el formulario con sus datos para crear una cuenta nueva.</p>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Nick</label>
                  <form:input path="nickname" type="text" class="form-control" required="required"  /> </div>
                  <font color="red"><form:errors path="nickname" /></font>
              </div>
              <div class="col-md-6">
                <div class="form-group"> <label>Email</label>
                  <form:input path="email" type="email" class="form-control" required="required"  /> </div>
                  <font color="red"><form:errors path="email" /></font>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group"> <label>Contraseña</label> 
                  <form:input path="password" type="password" class="form-control" required="required" pattern=".{12,}" title="La contraseña debe tener al menos 12 caracteres" /> </div>
                  <font color="red"><form:errors path="password" /></font>
               </div>
              
      
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