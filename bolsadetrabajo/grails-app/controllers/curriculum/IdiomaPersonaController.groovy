package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IdiomaPersonaController {

    IdiomaPersonaService idiomaPersonaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond idiomaPersonaService.list(params), model:[idiomaPersonaCount: idiomaPersonaService.count()]
    }

    def show(Long id) {
        respond idiomaPersonaService.get(id)
    }

    def create() {
        respond new IdiomaPersona(params)
    }

    def save(IdiomaPersona idiomaPersona) {
        if (idiomaPersona == null) {
            notFound()
            return
        }

        try {
            idiomaPersonaService.save(idiomaPersona)
        } catch (ValidationException e) {
            respond idiomaPersona.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), idiomaPersona.id])
                redirect idiomaPersona
            }
            '*' { respond idiomaPersona, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond idiomaPersonaService.get(id)
    }

    def update(IdiomaPersona idiomaPersona) {
        if (idiomaPersona == null) {
            notFound()
            return
        }

        try {
            idiomaPersonaService.save(idiomaPersona)
        } catch (ValidationException e) {
            respond idiomaPersona.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), idiomaPersona.id])
                redirect idiomaPersona
            }
            '*'{ respond idiomaPersona, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        idiomaPersonaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
