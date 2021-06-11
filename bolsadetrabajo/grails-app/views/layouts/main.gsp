<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>
            <g:layoutTitle default="BADMASTERS"/>
        </title>
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <!--ESTILOS PARA ADMINISTRADOR-->
    <sec:ifAllGranted roles="ROLE_ADMIN">
            
        <asset:stylesheet src="application.css"/>
        <g:layoutHead/>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <asset:stylesheet src="principal.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    
    </sec:ifAllGranted>
    <!--FIN ESTILOS ADMIN-->
        
    <!--ESTILOS EMPRESA Y POSTULANTE-->
    <sec:ifAnyGranted roles="ROLE_EMPRESA,ROLE_POSTULANTE">
        <asset:stylesheet src="application.css"/>
        <g:layoutHead/>
        <asset:stylesheet src="nicepage.css"/>
        <asset:stylesheet src="Cerrar-sesion.css"/>
        <asset:javascript src="/empresa/jquery.js"/>
        <asset:javascript src="/empresa/nicepage.js"/>
    </sec:ifAnyGranted>
    <!--FIN ESTILOS EMPRESA Y POSTULANTE-->
    <!--ESTILOS POSTULANTE-->
    <sec:ifAllGranted roles="ROLE_POSTULANTE">
        <asset:stylesheet src="normalize.css"/>
        <asset:stylesheet src="font-awesome.min.css"/>
        <asset:stylesheet src="fontello.css"/>
        <asset:stylesheet src="animate.css"/>      
        <asset:stylesheet src="pbootstrap.min.cs"/> 
        <asset:stylesheet src="owl.carousel.css"/>
        <asset:stylesheet src="owl.theme.css"/>
        <asset:stylesheet src="owl.transitions.css"/>
        <asset:stylesheet src="owl.transitions.css"/>
        <asset:stylesheet src="stylePortal.css"/>
        <asset:stylesheet src="responsive.css"/>
        <asset:javascript src="/vendor/modernizr-2.6.2.min.js"/>
        <script src="javascripts/vendor/modernizr-2.6.2.min.js"></script> 
    </sec:ifAllGranted>
    <!--FIN ESTILOS PARA POSTULANTE-->
    </head>
    <body class="sb-nav-fixed">       
<!--SECCION DE MENUS DE NAVEGACION -->
    <!--MENU PARA ADMINISTRADOR-->
        <sec:ifAnyGranted roles="ROLE_ADMIN">
            <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="/">BAD MASTERS </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
             <div class="float-md-left"><a><g:formatDate date="${new Date()}" type="date" style="LONG" /></a></div>
            <!-- Navbar-->
            <ul class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i>
                           <sec:loggedInUserInfo field="username"/>
                        </i>
                        <i class="fas fa-user fa-fw"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Ajustes</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="/logout">Cerrar sesión</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </sec:ifAnyGranted>
    <!--FIN DE MENU PARA ADMINISTRADOR-->
        
    <!--MENU PARA EMPRESA-->
    <sec:ifAnyGranted roles="ROLE_EMPRESA">
        <nav class="navbar navbar-light bg-light static-top">
            <div class = "navbar-nav mr-auto">
                <a class="navbar-brand" href="/"><asset:image src="BADLogo.png" alt="BadMaster Logo"/></a>
            </div>
            
            <div class="float-md-left"><a><g:formatDate date="${new Date()}" type="date" style="LONG" /></a></div>
            <div class="u-custom-menu u-nav-container">
                <ul class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="padding: 10px 14px;">
                        <i>
                           <sec:loggedInUserInfo field="username"/>
                        </i>
                        <i class="fas fa-user fa-fw"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="show/${sec.loggedInUserInfo(field: 'id')}" style="padding: 10px 14px;">Mi Empresa</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Lista-de-solicitudes.html" style="padding: 10px 14px;">Lista de solicitudes</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Ofrecer-Empleo.html" style="padding: 10px 14px;">Ofrecer Empleo</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/emailSender/cambioRol" style="padding: 10px 14px;">Solicitar un nuevo Rol</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/logout" style="padding: 10px 14px;">Cerrar sesion</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        
    </sec:ifAnyGranted>
    <!--FIN MENU PARA EMPRESA-->
                    
    <!--MENU PARA POSTULANTE-->
    <sec:ifAnyGranted roles="ROLE_POSTULANTE">
        
        <nav class="navbar navbar-light bg-light static-top">
            <div class = "navbar-nav mr-auto">
                <a class="navbar-brand" href="/"><asset:image src="BADLogo.png" alt="BadMaster Logo"/></a>
            </div>
            
            <div class="float-md-left"><a><g:formatDate date="${new Date()}" type="date" style="LONG" /></a></div>
            <div class="u-custom-menu u-nav-container">
                <ul class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="padding: 10px 14px;">
                        <i>
                           <sec:loggedInUserInfo field="username"/>
                        </i>
                        
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="show/${sec.loggedInUserInfo(field: 'id')}" style="padding: 10px 14px;">Area personal</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/emailSender/cambioRol" style="padding: 10px 14px;">Solicitar un nuevo Rol</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/logout" style="padding: 10px 14px;">Cerrar sesion</a></li>
                                           
                    </ul> 
                </li>
            </ul>
        </nav>
        
    </sec:ifAnyGranted>
    <!--FIN MENU POSTULANTE-->

<!--SIDEBAR DE ADMINISTRADIR-->
        <sec:ifAllGranted roles="ROLE_ADMIN">
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Menú</div>
                            <a class="nav-link" href="/">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Administracion</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Usuarios
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/user/listar">Lista Usuarios</a>
                                    <a class="nav-link" href="/userRole/index/">Roles</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Configuración
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Autenticación
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="/login/auth">Iniciar sesión</a>
                                            <a class="nav-link" href="/register">Registrarse</a>
                                            <a class="nav-link" href="/password">Olvidaste la contraseña</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePersona" aria-expanded="false" aria-controls="collapsePersona">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Persona
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePersona" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/persona/index">Lista Persona</a>
                                    <a class="nav-link" href="/certificacion/index/">Certificacion</a>
                                    <a class="nav-link" href="/explaboral/index/">Experiencia laboral</a>
                                    <a class="nav-link" href="/formacion/index/">Formacion</a>
                                    <a class="nav-link" href="/habilidadTecnica/index">Habilidades técnicas</a>
                                    <a class="nav-link" href="/idioma/index">Idioma</a>
                                    <a class="nav-link" href="/idiomaPersona/index">Idioma persona</a>
                                    <a class="nav-link" href="/logro/index/">Logro</a>
                                    <a class="nav-link" href="/participacionEvento/index/">Participacion Evento</a>
                                    <a class="nav-link" href="/personaRecomendacion/index/">Recomendacion</a>
                                    <a class="nav-link" href="/publicacion/index/">publicacion</a>
                                    <a class="nav-link" href="/redSocial/index/">Red social</a>
                                    <a class="nav-link" href="/tipoEvento/index/">tipo de evento</a>
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUbicacion" aria-expanded="false" aria-controls="collapseUbicacion">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Ubicacion
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseUbicacion" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/pais/index">Pais</a>
                                    <a class="nav-link" href="/departamento/index/">Departamento</a>
                                    <a class="nav-link" href="/municipio/index/">Municipio</a>
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEvaluacion" aria-expanded="false" aria-controls="collapseEvaluacion">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Evaluacion
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEvaluacion" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/evaluacion/index">listar Evaluaciones</a>
                                    <a class="nav-link" href="/preguntas/index/">Preguntas</a>
                                    <a class="nav-link" href="/recordDeNotas/index/">Record de notas</a>
                                    <a class="nav-link" href="/Respuestas/index/">Respuestas</a>
                                    <a class="nav-link" href="/tipoEvaluacion/index/">Tipo de Evaluacion</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEmpresa" aria-expanded="false" aria-controls="collapseEmpresa">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Empresa
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEmpresa" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/empresa/listar">Empresa</a>
                                    <a class="nav-link" href="/perfilPuesto/index">Perfil Puesto</a>      
                                </nav>
                            </div>

                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Conectado como:</div>
                        <sec:loggedInUserInfo field="username"/>
                    </div>
                </nav>
            </div>
        </sec:ifAllGranted>
<!--FIN SIDEBAR DE ADMINISTRADOR-->
            <div id="layoutSidenav_content">       
                <main>
                    <div class="container">
                        <g:layoutBody/>
                    </div>
                </main>
                
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; BADMASTERS 2021</div>
                            
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>
        <asset:javascript src="application.js"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <asset:javascript src="principal.js"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
