<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Iniciar sesión</title>
        <asset:stylesheet src="principal.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div class = "navbar-nav mr-auto">
            <a class="navbar-brand" href="/"><asset:image src="BADLogo.png" alt="BadMaster Logo"/></a>
        </div> 
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                        <form class="form-signin" action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" autocomplete="on">
                                            <div class="form-group">
                                                <label for="username">Usuario</label>
                                                <input type="text" class="form-control" name="${usernameParameter ?: 'username'}" id="username" autocapitalize="none"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="password">Contraseña</label>
                                                <input type="password" class="form-control" name="${passwordParameter ?: 'password'}" id="password"/>
                                               
                                            </div>
                                            <div class="form-check mb-3">
                                                <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                                                <label class="form-check-label" for="inputRememberPassword">Recordar contraseña</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="/password">¿Has olvidado tu contraseña?</a>
                                                <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Acceder</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="/register">¿Necesitas una cuenta? ¡Inscribirse!</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; BADMASTERS 2021</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <asset:javascript src="principal.js"/>
    </body>
</html>
