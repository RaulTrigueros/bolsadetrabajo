package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FormacionController {

    FormacionService formacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond formacionService.list(params), model:[formacionCount: formacionService.count()]
    }

    def show(Long id) {
        respond formacionService.get(id)
    }

    def create() {
        respond new Formacion(params)
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
        respond formacionService.get(id)
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
