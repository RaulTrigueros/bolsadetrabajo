package Evaluacion

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RespuestasController {

    RespuestasService respuestasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond respuestasService.list(params), model:[respuestasCount: respuestasService.count()]
    }

    def show(Long id) {
        respond respuestasService.get(id)
    }

    def create() {
        respond new Respuestas(params)
    }

    def save(Respuestas respuestas) {
        if (respuestas == null) {
            notFound()
            return
        }

        try {
            respuestasService.save(respuestas)
        } catch (ValidationException e) {
            respond respuestas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'respuestas.label', default: 'Respuestas'), respuestas.id])
                redirect respuestas
            }
            '*' { respond respuestas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond respuestasService.get(id)
    }

    def update(Respuestas respuestas) {
        if (respuestas == null) {
            notFound()
            return
        }

        try {
            respuestasService.save(respuestas)
        } catch (ValidationException e) {
            respond respuestas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'respuestas.label', default: 'Respuestas'), respuestas.id])
                redirect respuestas
            }
            '*'{ respond respuestas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        respuestasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'respuestas.label', default: 'Respuestas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'respuestas.label', default: 'Respuestas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
