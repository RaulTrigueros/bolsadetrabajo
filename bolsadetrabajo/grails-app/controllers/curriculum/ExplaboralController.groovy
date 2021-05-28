package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExplaboralController {

    ExplaboralService explaboralService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond explaboralService.list(params), model:[explaboralCount: explaboralService.count()]
    }

    def show(Long id) {
        respond explaboralService.get(id)
    }

    def create() {
        respond new Explaboral(params)
    }

    def save(Explaboral explaboral) {
        if (explaboral == null) {
            notFound()
            return
        }

        try {
            explaboralService.save(explaboral)
        } catch (ValidationException e) {
            respond explaboral.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'explaboral.label', default: 'Explaboral'), explaboral.id])
                redirect explaboral
            }
            '*' { respond explaboral, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond explaboralService.get(id)
    }

    def update(Explaboral explaboral) {
        if (explaboral == null) {
            notFound()
            return
        }

        try {
            explaboralService.save(explaboral)
        } catch (ValidationException e) {
            respond explaboral.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'explaboral.label', default: 'Explaboral'), explaboral.id])
                redirect explaboral
            }
            '*'{ respond explaboral, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        explaboralService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'explaboral.label', default: 'Explaboral'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'explaboral.label', default: 'Explaboral'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
