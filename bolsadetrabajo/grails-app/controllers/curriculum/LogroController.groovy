package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LogroController {

    LogroService logroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond logroService.list(params), model:[logroCount: logroService.count()]
    }

    def show(Long id) {
        respond logroService.get(id)
    }

    def create() {
        respond new Logro(params)
    }

    def save(Logro logro) {
        if (logro == null) {
            notFound()
            return
        }

        try {
            logroService.save(logro)
        } catch (ValidationException e) {
            respond logro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logro.label', default: 'Logro'), logro.id])
                redirect logro
            }
            '*' { respond logro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond logroService.get(id)
    }

    def update(Logro logro) {
        if (logro == null) {
            notFound()
            return
        }

        try {
            logroService.save(logro)
        } catch (ValidationException e) {
            respond logro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'logro.label', default: 'Logro'), logro.id])
                redirect logro
            }
            '*'{ respond logro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        logroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'logro.label', default: 'Logro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logro.label', default: 'Logro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
