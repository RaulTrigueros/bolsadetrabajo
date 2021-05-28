package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PersonaRecomendacionController {

    PersonaRecomendacionService personaRecomendacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personaRecomendacionService.list(params), model:[personaRecomendacionCount: personaRecomendacionService.count()]
    }

    def show(Long id) {
        respond personaRecomendacionService.get(id)
    }

    def create() {
        respond new PersonaRecomendacion(params)
    }

    def save(PersonaRecomendacion personaRecomendacion) {
        if (personaRecomendacion == null) {
            notFound()
            return
        }

        try {
            personaRecomendacionService.save(personaRecomendacion)
        } catch (ValidationException e) {
            respond personaRecomendacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), personaRecomendacion.id])
                redirect personaRecomendacion
            }
            '*' { respond personaRecomendacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond personaRecomendacionService.get(id)
    }

    def update(PersonaRecomendacion personaRecomendacion) {
        if (personaRecomendacion == null) {
            notFound()
            return
        }

        try {
            personaRecomendacionService.save(personaRecomendacion)
        } catch (ValidationException e) {
            respond personaRecomendacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), personaRecomendacion.id])
                redirect personaRecomendacion
            }
            '*'{ respond personaRecomendacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personaRecomendacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
