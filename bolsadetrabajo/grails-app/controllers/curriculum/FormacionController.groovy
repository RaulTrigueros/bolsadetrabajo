package curriculum
import seguridad.Persona

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FormacionController {

    FormacionService formacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond formacionService.list(params), model:[usu:usu,pos:pos,formacionCount: formacionService.count()]
    }

    def show(Long id) {
        def str = Formacion.executeQuery("select persona.id from Formacion p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond formacionService.get(id),model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new Formacion(params),model:[pos,pos]
    }

    def save(Formacion formacion) {
        if (formacion == null) {
            notFound()
            return
        }

        try {
            formacionService.save(formacion)
        } catch (ValidationException e) {
            respond formacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'formacion.label', default: 'Formacion'), formacion.id])
                redirect formacion
            }
            '*' { respond formacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = Formacion.executeQuery("select persona.id from Formacion p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond formacionService.get(id),model:[pos:pos]
    }

    def update(Formacion formacion) {
        if (formacion == null) {
            notFound()
            return
        }

        try {
            formacionService.save(formacion)
        } catch (ValidationException e) {
            respond formacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'formacion.label', default: 'Formacion'), formacion.id])
                redirect formacion
            }
            '*'{ respond formacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        formacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'formacion.label', default: 'Formacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'formacion.label', default: 'Formacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
