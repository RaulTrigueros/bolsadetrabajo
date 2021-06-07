package Evaluacion

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PreguntasController {

    PreguntasService preguntasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond preguntasService.list(params), model:[preguntasCount: preguntasService.count()]
    }

    def show(Long id) {
        respond preguntasService.get(id)
    }

    def create() {
        respond new Preguntas(params)
    }

    def save(Preguntas preguntas) {
        if (preguntas == null) {
            notFound()
            return
        }

        try {
            preguntasService.save(preguntas)
        } catch (ValidationException e) {
            respond preguntas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'preguntas.label', default: 'Preguntas'), preguntas.id])
                redirect preguntas
            }
            '*' { respond preguntas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond preguntasService.get(id)
    }

    def update(Preguntas preguntas) {
        if (preguntas == null) {
            notFound()
            return
        }

        try {
            preguntasService.save(preguntas)
        } catch (ValidationException e) {
            respond preguntas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'preguntas.label', default: 'Preguntas'), preguntas.id])
                redirect preguntas
            }
            '*'{ respond preguntas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        preguntasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'preguntas.label', default: 'Preguntas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'preguntas.label', default: 'Preguntas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
