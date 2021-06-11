package curriculum
import seguridad.Persona
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PublicacionController {

    PublicacionService publicacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def per =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond publicacionService.list(params), model:[usu:usu,per:per,publicacionCount: publicacionService.count()]
    }

    def show(Long id) {
        def str = Publicacion.executeQuery("select persona.id from Publicacion p where id ="+id)
        def per =(str.toString().replace("[", "").replace("]", ""))
        respond publicacionService.get(id), model:[per:per]
    }

    def create(Long id) {
        def per=id
        respond new Publicacion(params), model:[per:per]
    }

    def save(Publicacion publicacion) {
        if (publicacion == null) {
            notFound()
            return
        }

        try {
            publicacionService.save(publicacion)
        } catch (ValidationException e) {
            respond publicacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect publicacion
            }
            '*' { respond publicacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = Publicacion.executeQuery("select persona.id from Publicacion p where id ="+id)
        def per =(str.toString().replace("[", "").replace("]", ""))
        respond publicacionService.get(id), model:[per:per]
    }

    def update(Publicacion publicacion) {
        if (publicacion == null) {
            notFound()
            return
        }

        try {
            publicacionService.save(publicacion)
        } catch (ValidationException e) {
            respond publicacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect publicacion
            }
            '*'{ respond publicacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        publicacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
