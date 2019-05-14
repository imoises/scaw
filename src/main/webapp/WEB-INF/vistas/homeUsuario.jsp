<%@ include file="_header.jsp" %>

  <!-- Intro -->
  <div class="py-5 text-center text-white h-100 align-items-center d-flex" style="background-image: linear-gradient(to bottom, rgba(0, 0, 0, .75), rgba(0, 0, 0, .75)), url(https://static.pingendo.com/cover-bubble-dark.svg);  background-position: center center, center center;  background-size: cover, cover;  background-repeat: repeat, repeat;" >
    <div class="container py-5">
      <div class="row">
        <div class="mx-auto col-lg-8 col-md-10">
          <ul class="nav nav-tabs">
            <li class="nav-item" style=""> <a href="" class="active nav-link" data-toggle="tab" data-target="#tabone">Guardar texto</a> </li>
            <li class="nav-item"> <a class="nav-link" href="" data-toggle="tab" data-target="#tabtwo">Historial Actividades</a> </li>
          </ul>
          <div class="tab-content mt-2">
            <div class="tab-pane fade show active" id="tabone" role="tabpanel">
              <h1 class="display-3 mb-4">Usuario</h1>
              <p class="">Ingrese un texto no mayor a 300 caracteres.</p>
              <form:form action="guardarComentario" method="POST" modelAttribute="textoModel">
                <div class="form-group"> <!-- input type="textarea" class="form-control" style=""-->
               		<form:textarea path="descripcion" rows="5" cols="30" />
                </div>
                <button type="submit" class="btn btn-lg btn-primary mx-1" contenteditable="true">Guardar</button>
              </form:form>
            </div>
            <div class="tab-pane fade" id="tabtwo" role="tabpanel">
              <p class="">Las actividades realidas por el usuario fueron:&nbsp;</p>
              <div class="table-responsive">
                <table class="table table-striped table-dark">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Descripción</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>Mark</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="tab-pane fade" id="tabthree" role="tabpanel">
              <p class="">In my soul and absorb its power, like the form of a beloved mistress, then I often think with longing.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  
 <%@ include file="_footer.jsp" %>