<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Index Postulante</title>
 
    </head>
    
    <body>
  
            <div class="container">
                <div class="row page-title text-center wow bounce"  data-wow-delay="1s">
                    <h5>Empleos Recientes</h5>
                    <p><br/></p>
                    <h2>Empleos disponibles para ti</h2>
                </div>
                <div class="row jobs">
                    <div class="col-md-12">
                        <div class="job-posts table-responsive">
                            <table class="table">
                                <thead>
                                    <tr class="even wow fadeInUp" data-wow-delay="1s">
                                        <th class="text-center">Nombre de Puesto</th>
                                        <th class="text-center">Descripción</th>
                                        <th class="text-center">Conocimientos Necesario</th>
                                        <th class="text-center">Perfil Académico</th>
                                        <th class="text-center">Habilidades Requeridas</th>
                                        <th class="text-center">Experiencia Laboral</th>
                                        <th class="text-center">Salario Minimo</th>
                                        <th class="text-center">Salario Máximo</th>
                                        <th class="text-center">Ubicacion</th>
                                        <th class="text-center">Acción</th>
                                    </tr>
                                </thead>
                                <g:each var="perfil" in="${perfiles}">
                                    <tr class="odd wow fadeInUp" data-wow-delay="1s">
                                        <%-- <td class="tbl-logo"><img src="img/job-logo1.png" alt=""></td> --%>
                                        <td class="tbl-title">
                                            <h4>${perfil.nombrePuestoTrabajo}</h4>
                                        </td>
                                        <td><p class="text-center">${perfil.descripcionPuesto}</p></td>
                                        <td><p class="text-center">${perfil.conocimientosNecesarios}</p></td>
                                        <td><p class="text-center">${perfil.perfilAcademico}</p></td>
                                        <td><p class="text-center">${perfil.habilidades}</p></td>
                                        <td><p class="text-center">${perfil.experienciaLaboral}</p></td>
                                        <td><p class="text-center">&dollar;${perfil.salarioMin}</p></td>
                                        <td><p class="text-center">&dollar;${perfil.salarioMax}</p></td>
                                        <td><p class="text-center"><p><i class="icon-location"></i>${perfil.ubicacionGeografica}</p></p></td>
                                        <td class="tbl-apply"><a href="/PerfilPuesto/show/${perfil.id}">Ver</a></td>
                                    </tr>
                                </g:each>
                                <tfoot>
                                    <tr class="even wow fadeInUp" data-wow-delay="1s">
                                        <th class="text-center">Nombre de Puesto</th>
                                        <th class="text-center">Descripción</th>
                                        <th class="text-center">Conocimientos Necesario</th>
                                        <th class="text-center">Perfil Académico</th>
                                        <th class="text-center">Habilidades Requeridas</th>
                                        <th class="text-center">Experiencia Laboral</th>
                                        <th class="text-center">Salario Minimo</th>
                                        <th class="text-center">Salario Máximo</th>
                                        <th class="text-center">Ubicacion</th>
                                        <th class="text-center">Acción</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>

                    </div>
                </div>

            </div>
            <hr>
            <div class="container">
                <div class="row job-posting wow fadeInUp" data-wow-delay="1s">
                    <div role="tabpanel">
                      <!-- Nav tabs -->
                      

                      <!-- Tab panes -->
                      <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="job-seekers">
                            <ul class="list-inline job-seeker">
                                <li>
                                    <a href="">
                                        <img src="img/team-small-5.jpg" alt="">
                                        <div class="overlay"><h3>Ohidul Islam</h3><p>Web Designer</p></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/team-small-6.jpg" alt="">
                                        <div class="overlay"><h3>Mohidul Islam</h3><p>CEO</p></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/team-small-3.jpg" alt="">
                                        <div class="overlay"><h3>Unknown girl</h3><p>Graphic Designer</p></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/team-small-4.jpg" alt="">
                                        <div class="overlay"><h3>Eftakher Alam</h3><p>Graphic Designer</p></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/team-small-2.jpg" alt="">
                                        <div class="overlay"><h3>Mark Otto</h3><p>Founder</p></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/team-small-1.jpg" alt="">
                                        <div class="overlay"><h3>Rasel Ahmed</h3><p>Web Developer</p></div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="employeers">
                            <ul class="list-inline">
                                <li>
                                    <a href="">
                                        <img src="img/employee4.png" alt="">
                                        <div class="overlay"><h3>Instagram</h3></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/employee5.png" alt="">
                                        <div class="overlay"><h3>Microsoft</h3></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/employee6.png" alt="">
                                        <div class="overlay"><h3>Dribbble</h3></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/employee1.png" alt="">
                                        <div class="overlay"><h3>Beats Music</h3></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/employee2.png" alt="">
                                        <div class="overlay"><h3>Facebook</h3></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <img src="img/employee3.png" alt="">
                                        <div class="overlay"><h3>Twitter</h3></div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                      </div>

                    </div>
                </div>
            </div>
    </body>

</html>