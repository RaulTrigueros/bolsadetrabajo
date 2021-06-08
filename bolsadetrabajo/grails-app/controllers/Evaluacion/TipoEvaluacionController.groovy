package Evaluacion

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoEvaluacionController {

    TipoEvaluacionService tipoEvaluacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoEvaluacionService.list(params), model:[tipoEvaluacionCount: tipoEvaluacionService.count()]
    }

    def show(Long id) {
        respond tipoEvaluacionService.get(id)
    }

    def create() {
        respond new TipoEvaluacion(params)
    }

    def save(TipoEvaluacion tipoEvaluacion) {
        if (tipoEvaluacion == null) {
            notFound()
            return
        }

        try {
            tipoEvaluacionService.save(tipoEvaluacion)
        } catch (ValidationException e) {
            respond tipoEvaluacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoEvaluacion.label', default: 'TipoEvaluacion'), tipoEvaluacion.id])
                redirect tipoEvaluacion
            }
            '*' { respond tipoEvaluacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoEvaluacionService.get(id)
    }

    def update(TipoEvaluacion tipoEvaluacion) {
        if (tipoEvaluacion == null) {
            notFound()
            return
        }

        try {
            tipoEvaluacionService.save(tipoEvaluacion)
        } catch (ValidationException e) {
            respond tipoEvaluacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoEvaluacion.label', default: 'TipoEvaluacion'), tipoEvaluacion.id])
                redirect tipoEvaluacion
            }
            '*'{ respond tipoEvaluacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoEvaluacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoEvaluacion.label', default: 'TipoEvaluacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoEvaluacion.label', default: 'TipoEvaluacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
