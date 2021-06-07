package Evaluacion

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RecordDeNotasController {

    RecordDeNotasService recordDeNotasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond recordDeNotasService.list(params), model:[recordDeNotasCount: recordDeNotasService.count()]
    }

    def show(Long id) {
        respond recordDeNotasService.get(id)
    }

    def create() {
        respond new RecordDeNotas(params)
    }

    def save(RecordDeNotas recordDeNotas) {
        if (recordDeNotas == null) {
            notFound()
            return
        }

        try {
            recordDeNotasService.save(recordDeNotas)
        } catch (ValidationException e) {
            respond recordDeNotas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'recordDeNotas.label', default: 'RecordDeNotas'), recordDeNotas.id])
                redirect recordDeNotas
            }
            '*' { respond recordDeNotas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond recordDeNotasService.get(id)
    }

    def update(RecordDeNotas recordDeNotas) {
        if (recordDeNotas == null) {
            notFound()
            return
        }

        try {
            recordDeNotasService.save(recordDeNotas)
        } catch (ValidationException e) {
            respond recordDeNotas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'recordDeNotas.label', default: 'RecordDeNotas'), recordDeNotas.id])
                redirect recordDeNotas
            }
            '*'{ respond recordDeNotas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        recordDeNotasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'recordDeNotas.label', default: 'RecordDeNotas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recordDeNotas.label', default: 'RecordDeNotas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
