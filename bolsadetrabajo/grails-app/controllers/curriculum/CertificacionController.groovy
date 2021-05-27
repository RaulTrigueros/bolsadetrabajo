package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CertificacionController {

    CertificacionService certificacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond certificacionService.list(params), model:[certificacionCount: certificacionService.count()]
    }

    def show(Long id) {
        respond certificacionService.get(id)
    }

    def create() {
        respond new Certificacion(params)
    }

    def save(Certificacion certificacion) {
        if (certificacion == null) {
            notFound()
            return
        }

        try {
            certificacionService.save(certificacion)
        } catch (ValidationException e) {
            respond certificacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), certificacion.id])
                redirect certificacion
            }
            '*' { respond certificacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond certificacionService.get(id)
    }

    def update(Certificacion certificacion) {
        if (certificacion == null) {
            notFound()
            return
        }

        try {
            certificacionService.save(certificacion)
        } catch (ValidationException e) {
            respond certificacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), certificacion.id])
                redirect certificacion
            }
            '*'{ respond certificacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        certificacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
