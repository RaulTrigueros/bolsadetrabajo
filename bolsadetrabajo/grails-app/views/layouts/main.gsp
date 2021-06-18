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
    
     <asset:stylesheet src="application.css"/>
        <!--<g:layoutHead/>-->
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <asset:stylesheet src="principal.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script> 
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
    
       <!-- <asset:stylesheet src="application.css"/> 
       <!-- <g:layoutHead/> 
        <asset:stylesheet src="nicepage.css"/>
        <asset:stylesheet src="Cerrar-sesion.css"/>
        <asset:javascript src="/empresa/jquery.js"/>
        <asset:javascript src="/empresa/nicepage.js"/>
        
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
        <script src="javascripts/vendor/modernizr-2.6.2.min.js"></script> -->
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
            <a class="navbar-brand ps-3" href="/">BADMASTERS </a>
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
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/empresa/show/${emp}" style="padding: 10px 14px;">Mi Empresa</a></li>
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

                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/persona/show/${pos}" style="padding: 10px 14px;">Area personal</a></li>
                        <li><a class="dropdown-item u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="/emailSender/cambioRol/${pos}" style="padding: 10px 14px;">Solicitar un nuevo Rol</a></li>
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
                            <div class="sb-sidenav-menu-heading">Gestión de Cuentas</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Gestión de cuentas de Usuarios
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/user/listar">Lista de Usuarios</a>
                                    <a class="nav-link" href="/role/index/">Lista de Roles</a>
                                </nav>
                            </div>
                           
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePersona" aria-expanded="false" aria-controls="collapsePersona">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Gestión de cuentas de Postulantes
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePersona" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/persona/listar">Listado de Personas</a>
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEmpresa" aria-expanded="false" aria-controls="collapseEmpresa">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Gestión de cuentas de Empresas
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEmpresa" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/empresa/listar">Listado de Empresas</a>     
                                </nav>
                            </div>
                            
                            <div class="sb-sidenav-menu-heading">Catálogos Generales</div>
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
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseIdioma" aria-expanded="false" aria-controls="collapseIdioma">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Idioma
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseIdioma" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/idioma/index">Idioma</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEvaluacion" aria-expanded="false" aria-controls="collapseEvaluacion">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Evaluacion
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEvaluacion" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/tipoEvaluacion/index/">Tipo de Evaluacion</a>
                                </nav>
                            </div>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEvento" aria-expanded="false" aria-controls="collapseEvento">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Evento
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEvento" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/tipoEvento/index/">tipo de evento</a>
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
        <asset:javascript src="busqueda.js"/>
    </body>
</html>
