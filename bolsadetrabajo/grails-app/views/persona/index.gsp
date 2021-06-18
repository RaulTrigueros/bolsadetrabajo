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
                        <div class="job-posts">
                            <table id="TablaEmpleos" class="table table-sm table-hover table-striped">
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
                                        <td class="tbl-title">
                                            <p><b>${perfil.nombrePuestoTrabajo}</b></p>
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
    </body>

</html>