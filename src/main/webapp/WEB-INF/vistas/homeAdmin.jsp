<%@ include file="_header.jsp" %>

<div class="align-items-center d-flex cover section-aquamarine py-5" style="background-image: url(&quot;assets/restaurant/cover_light.jpg&quot;);">
    <div class="container">
      <div class="row">
       
       <div class = "col-lg-12 align-self-center text-lg-left text-center">
					
			<table class="table container">
				<thead>
					<tr>
				    	<th scope="col">id</th>
				     	<th scope="col">email</th>
				      	<th scope="col">rol</th>
				     	<th scope="col">estado</th>
				    </tr>
				</thead>
				<tbody>
				<c:forEach items="${usuarios}" var="item">
			    	<tr>
				     <td>${item.id}</td>
				     <td>${item.email}</td>
				     <td>${item.rol}</td>
				     <td>${item.estado}</td>
				     <td><a class="btn" href="habilitar-usuario">Habilitar</a></td>
				     
				    </tr>
				</c:forEach> 		  
				
				</tbody>
			</table>
			<%--Bloque que es visible si el elemento error no está vacío	--%>
			<c:if test="${not empty error}">
		        <h4><span>${error}</span></h4>
		        <br>
	        </c:if>	
		</div>
       
       
      </div>
	</div>
</div>

  
 <%@ include file="_footer.jsp" %>