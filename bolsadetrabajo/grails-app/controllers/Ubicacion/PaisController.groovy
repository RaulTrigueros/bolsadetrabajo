package Ubicacion

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PaisController {

    PaisService paisService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paisService.list(params), model:[paisCount: paisService.count()]
    }

    def show(Long id) {
        respond paisService.get(id)
    }

    def create() {
        respond new Pais(params)
    }

    def save(Pais pais) {
        if (pais == null) {
            notFound()
            return
        }

        try {
            paisService.save(pais)
        } catch (ValidationException e) {
            respond pais.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pais.label', default: 'Pais'), pais.id])
                redirect pais
            }
            '*' { respond pais, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond paisService.get(id)
    }

    def update(Pais pais) {
        if (pais == null) {
            notFound()
            return
        }

        try {
            paisService.save(pais)
        } catch (ValidationException e) {
            respond pais.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pais.label', default: 'Pais'), pais.id])
                redirect pais
            }
            '*'{ respond pais, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        paisService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pais.label', default: 'Pais'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pais.label', default: 'Pais'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
