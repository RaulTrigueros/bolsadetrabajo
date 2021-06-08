package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ParticipacionEventoController {

    ParticipacionEventoService participacionEventoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond participacionEventoService.list(params), model:[participacionEventoCount: participacionEventoService.count()]
    }

    def show(Long id) {
        respond participacionEventoService.get(id)
    }

    def create() {
        respond new ParticipacionEvento(params)
    }

    def save(ParticipacionEvento participacionEvento) {
        if (participacionEvento == null) {
            notFound()
            return
        }

        try {
            participacionEventoService.save(participacionEvento)
        } catch (ValidationException e) {
            respond participacionEvento.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'participacionEvento.label', default: 'ParticipacionEvento'), participacionEvento.id])
                redirect participacionEvento
            }
            '*' { respond participacionEvento, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond participacionEventoService.get(id)
    }

    def update(ParticipacionEvento participacionEvento) {
        if (participacionEvento == null) {
            notFound()
            return
        }

        try {
            participacionEventoService.save(participacionEvento)
        } catch (ValidationException e) {
            respond participacionEvento.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'participacionEvento.label', default: 'ParticipacionEvento'), participacionEvento.id])
                redirect participacionEvento
            }
            '*'{ respond participacionEvento, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        participacionEventoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'participacionEvento.label', default: 'ParticipacionEvento'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'participacionEvento.label', default: 'ParticipacionEvento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
