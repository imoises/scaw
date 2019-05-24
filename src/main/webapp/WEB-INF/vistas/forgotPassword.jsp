<%@ include file="_header.jsp" %>

    <div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
	    <div class="container">
	      <div class="row">
	        <div class="col-lg-7 align-self-center text-lg-left text-center">
	          <h1 class="mb-0 mt-5 display-4">Olvidaste la contraseña?</h1>
	          <p class="mb-5">Se enviará un E-mail con una nueva contraseña.</p>
	        </div>
	        <div class="col-lg-5 p-3">
	        <form:form action="forgotPassword" modelAttribute="usuario" method="POST">
	        	<div class="form-group row">
					  <label class="col-lg-3 control-label">Email:</label>
					  	<form:input class="form-control col-lg-9" path="email" type="email" />
				  </div>	
				  <div class="form-group row">
			  		  <div class="col-lg-3"></div>
			  		  <div class="col-lg-9">
					    <button type="submit" class="btn btn-success">Enviar contraseña</button>
					  </div>
				  </div>
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