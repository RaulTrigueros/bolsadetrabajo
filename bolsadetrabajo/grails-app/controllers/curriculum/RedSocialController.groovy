package curriculum
import seguridad.Persona

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RedSocialController {

    RedSocialService redSocialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        
        params.id = Math.min(id ?: 10, 100)
        respond redSocialService.list(params), model:[usu:usu, pos:pos, redSocialCount: redSocialService.count()]
    }

    def show(Long id) {

        def str = RedSocial.executeQuery("select persona.id from RedSocial p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond redSocialService.get(id), model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new RedSocial(params), model:[pos:pos]
    }

    def save(RedSocial redSocial) {
        if (redSocial == null) {
            notFound()
            return
        }

        try {
            redSocialService.save(redSocial)
        } catch (ValidationException e) {
            respond redSocial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), redSocial.id])
                redirect redSocial
            }
            '*' { respond redSocial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = RedSocial.executeQuery("select persona.id from RedSocial p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond redSocialService.get(id), model:[pos:pos]
    }

    def update(RedSocial redSocial) {
        if (redSocial == null) {
            notFound()
            return
        }

        try {
            redSocialService.save(redSocial)
        } catch (ValidationException e) {
            respond redSocial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), redSocial.id])
                redirect redSocial
            }
            '*'{ respond redSocial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        redSocialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
