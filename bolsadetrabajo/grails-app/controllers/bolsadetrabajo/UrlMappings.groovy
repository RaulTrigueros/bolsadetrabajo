package bolsadetrabajo

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

      
       "/"(view:"/index")
       "/user"(controller:'user', action:'index')
       "/user/roles"(controller:'userRole', action:'index')
       "/crearRol"(controller:'userRole', action:'create')
       "/register"(view:"/login/register")
       "/password"(view:"/login/password")
       "/logro"(view:"/logro/index")
       "500"(view:'/error')
       "404"(view:'/notFound')
    }
}
