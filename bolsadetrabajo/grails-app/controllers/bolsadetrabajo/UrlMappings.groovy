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
       "/empresa"(controller:'empresa', action:'index')
       "/user/roles"(controller:'userRole', action:'index')
       "/crearRol"(controller:'userRole', action:'create')
       "/register"(view:"/login/register")
       "/password"(view:"/login/password")
       "/registerEmp"(view:"/loginEmpresa/register")
       "/passwordEmp"(view:"/loginEmpresa/password")
       "/loginEmp"(view:"/loginEmpresa/authEmp")
       "/logro"(view:"/logro/index")
       "500"(view:'/error')
       "404"(view:'/notFound')
    }
}
