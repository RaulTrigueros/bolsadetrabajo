<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>BADMASTERS</title>
        <meta name="description" content="Bolsa de trabajo">
        <meta name="author" content="badmasters">
        <meta name="keyword" content="html, css, bootstrap, job-board">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="assets/favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        
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
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" type="text/javascript"></script>
    </head>
    <body>
    
        <!-- Body content -->
        <nav class="navbar navbar-light bg-light static-top">
            <div class = "navbar-nav mr-auto">
                <a class="navbar-brand" href="/"><asset:image src="BADLogo.png" alt="BadMaster Logo"/></a>
            </div> 
            <div class="container">
                <div class="button navbar-right"> 
                     
                    <sec:ifLoggedIn>
                        <!--Acceder como Administrador-->
                        <sec:ifAnyGranted roles="ROLE_ADMIN">
                            <a class="btn btn-primary" href="/inicio/">Ir a <sec:username/></a> 
                        </sec:ifAnyGranted>
                        <!--Acceder como postulante-->
                        <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                        <a class="btn btn-primary" href="/persona/index/${sec.loggedInUserInfo(field: 'id')}">Ir a <sec:username/></a> 
                       </sec:ifAnyGranted>
                       <!--Acceder como empresa-->
                        <sec:ifAnyGranted roles="ROLE_EMPRESA">
                            <a class="btn btn-primary" href="/empresa/index/${sec.loggedInUserInfo(field: 'id')}">Ir a <sec:username/></a> 
                        </sec:ifAnyGranted>
                        
                         <a class="btn btn-primary" href="/inicio/">Inicio <sec:username/></a> 
                        
                        <!--Salir-->
                        <a class="btn btn-primary" href="/logout">Cerrar Sesión</a>
                    </sec:ifLoggedIn>
                    <!--Si no ha iniciado sesión-->
                    <sec:ifNotLoggedIn>
                        <a class="btn btn-primary" href="/login/auth">Acceder</a>
                     <!--   <a class="btn btn-primary" href="/register">Registrar Candidato</a> -->
                        <a class="btn btn-primary" href="/user/create">Registrar Candidato</a>
                        <a class="btn btn-primary" href="/loginEmp">Iniciar Empresa</a>
                        <a class="btn btn-primary" href="/user/create">Registrar como empresa</a>
                    </sec:ifNotLoggedIn>
                                         
                     <!--Contactar servicio de plataforma como empresa-->
                    <a class="btn btn-primary" href="/emailSender/contacto">Contacta con nosotros</a>
                </div>
            </div>
        </nav>
     
        <div class="slider-area">
            <div class="slider">
                <div id="bg-slider" class="owl-carousel owl-theme">
                 
                  <div class="item"><asset:image src="slider-image-3.jpg" alt="slider3"/></div>
                  <div class="item"><asset:image src="slider-image-2.jpg" alt="slider2"/></div>
                  <div class="item"><asset:image src="slider-image-1.jpg" alt="slider1"/></div>
                 
                </div>
            </div>
            <div class="container slider-content">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
                        <h2>BADMASTERS OFERTAS DE TRABAJO, OPORTUNIDADES DE EMPLEO</h2>
                        <div class="search-form wow pulse" data-wow-delay="0.8s">
                            <form action="" class=" form-inline">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Job Key Word">
                                </div>
                                <div class="form-group">
                                    <select name="" id="" class="form-control">
                                        <option>Select Your City</option>
                                        <option selected>New york, CA</option>
                                        <option>New york, CA</option>
                                        <option>New york, CA</option>
                                        <option>New york, CA</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <select name="" id="" class="form-control">
                                        <option>Select Your Category</option>
                                        <option selected>Graphic Design</option>
                                        <option>Web Design</option>
                                        <option>App Design</option>
                                    </select>
                                </div>
                                <input type="submit" class="btn" value="Search">


                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer-area">
            <div class="container">
                <div class="row footer">
                    <div class="col-md-4">
                        <div class="single-footer">
                           <asset:image src="BADLogo.png" alt="BadMaster Logo"/>
                            <p>Somos una Empresa que ofrece servicio de alojamiento para promover ofertas de trabajo.</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-footer">
                            <h4>Universidad de El Salvador</h4>
                            <div class="twitter-updates">
                                <div class="single-tweets">
                                    <h5>Somos BADMASTERS</h5>
                                    <p>La mejor plataforma de bolsa de trabajo</p>
                                </div>
                                <div class="single-tweets">
                                    <h5>Servicio confiable</h5>
                                    <p>Tu información es muy importante. Nosotros nos encargamos de darte la mayor seguridad</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-footer">
                            <h4>Acceder</h4>
                            <div class="footer-links">
                                <ul class="list-unstyled">
                                    <li><a href="/login/auth">Candidato</a></li>
                                    <li><a href="/loginEmpresa/authEmp" class="active">Empresa</a></li>
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row footer-copy">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; <a href="/">BADMASTERS 2021</a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		
		
		
		
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="javascripts/vendor/jquery-1.10.2.min.js"><\/script>')</script>
         <asset:javascript src="pbootstrap.min.js"/>
         <asset:javascript src="owl.carousel.min.js"/>
         <asset:javascript src="wow.js"/>
         <asset:javascript src="main.js"/>
         <asset:javascript src="busqueda.js"/>
    </body>
</html>
