package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TelefonoController {

    TelefonoService telefonoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond telefonoService.list(params), model:[telefonoCount: telefonoService.count()]
    }

    def show(Long id) {
        respond telefonoService.get(id)
    }

    def create() {
        respond new Telefono(params)
    }

    def save(Telefono telefono) {
        if (telefono == null) {
            notFound()
            return
        }

        try {
            telefonoService.save(telefono)
        } catch (ValidationException e) {
            respond telefono.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'telefono.label', default: 'Telefono'), telefono.id])
                redirect telefono
            }
            '*' { respond telefono, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond telefonoService.get(id)
    }

    def update(Telefono telefono) {
        if (telefono == null) {
            notFound()
            return
        }

        try {
            telefonoService.save(telefono)
        } catch (ValidationException e) {
            respond telefono.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'telefono.label', default: 'Telefono'), telefono.id])
                redirect telefono
            }
            '*'{ respond telefono, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        telefonoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'telefono.label', default: 'Telefono'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'telefono.label', default: 'Telefono'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
