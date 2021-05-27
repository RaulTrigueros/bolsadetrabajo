package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IdiomaController {

    IdiomaService idiomaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond idiomaService.list(params), model:[idiomaCount: idiomaService.count()]
    }

    def show(Long id) {
        respond idiomaService.get(id)
    }

    def create() {
        respond new Idioma(params)
    }

    def save(Idioma idioma) {
        if (idioma == null) {
            notFound()
            return
        }

        try {
            idiomaService.save(idioma)
        } catch (ValidationException e) {
            respond idioma.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'idioma.label', default: 'Idioma'), idioma.id])
                redirect idioma
            }
            '*' { respond idioma, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond idiomaService.get(id)
    }

    def update(Idioma idioma) {
        if (idioma == null) {
            notFound()
            return
        }

        try {
            idiomaService.save(idioma)
        } catch (ValidationException e) {
            respond idioma.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'idioma.label', default: 'Idioma'), idioma.id])
                redirect idioma
            }
            '*'{ respond idioma, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        idiomaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'idioma.label', default: 'Idioma'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'idioma.label', default: 'Idioma'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
