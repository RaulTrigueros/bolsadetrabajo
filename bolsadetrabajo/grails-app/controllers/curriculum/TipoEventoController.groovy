package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoEventoController {

    TipoEventoService tipoEventoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoEventoService.list(params), model:[tipoEventoCount: tipoEventoService.count()]
    }

    def show(Long id) {
        respond tipoEventoService.get(id)
    }

    def create() {
        respond new TipoEvento(params)
    }

    def save(TipoEvento tipoEvento) {
        if (tipoEvento == null) {
            notFound()
            return
        }

        try {
            tipoEventoService.save(tipoEvento)
        } catch (ValidationException e) {
            respond tipoEvento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoEvento.label', default: 'TipoEvento'), tipoEvento.id])
                redirect tipoEvento
            }
            '*' { respond tipoEvento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoEventoService.get(id)
    }

    def update(TipoEvento tipoEvento) {
        if (tipoEvento == null) {
            notFound()
            return
        }

        try {
            tipoEventoService.save(tipoEvento)
        } catch (ValidationException e) {
            respond tipoEvento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoEvento.label', default: 'TipoEvento'), tipoEvento.id])
                redirect tipoEvento
            }
            '*'{ respond tipoEvento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoEventoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoEvento.label', default: 'TipoEvento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoEvento.label', default: 'TipoEvento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
