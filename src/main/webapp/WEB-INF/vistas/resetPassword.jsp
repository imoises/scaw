<%@ include file="_header.jsp" %>

    <div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
	    <div class="container">
	      <div class="row">
	        <div class="col-lg-7 align-self-center text-lg-left text-center">
	          <h1 class="mb-0 mt-5 display-4">Cambiar contraseña</h1>
	          <p class="mb-5">Cambiar contraseña</p>
	        </div>
	        <div class="col-lg-5 p-3">
	        <form:form action="resetPassword" modelAttribute="usuario" method="POST">
	        	<div class="form-group row">
					  <label class="col-lg-6 control-label">Email:</label>
					  	<form:input class="form-control col-lg-6" path="email" type="email" />
				  </div>	
				  <div class="form-group row">
					  <label class="col-lg-6 control-label">Contraseña actual:</label>
					  	<form:input class="form-control col-lg-6" path="password" type="password" />
				  </div>  
				  <div class="form-group row">
					  <label class="col-lg-6 control-label">Contraseña nueva:</label>
					  	<input class="form-control col-lg-6" type="password" id="password_new" name="newPassword"/>
				  </div>
				  <div class="form-group row">
			  		  <div class="col-lg-2"></div>
			  		  <div class="col-lg-10">
					    <button type="submit" class="btn btn-success">Cambiar contraseña</button>
					  </div>
				  </div>
				  <%--Bloque que es visible si el elemento error no estÃƒÂ¡ vacÃƒÂ­o	--%>
				  <c:if test="${not empty msg}">
					<h4><span>${msg}</span></h4>
					<br>
				  </c:if>
		   	</form:form>
		   </div>
		 </div>
	  </div>
  </div>
     
 <%@ include file="_footer.jsp" %>
