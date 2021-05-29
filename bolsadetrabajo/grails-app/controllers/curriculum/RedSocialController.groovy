package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RedSocialController {

    RedSocialService redSocialService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond redSocialService.list(params), model:[redSocialCount: redSocialService.count()]
    }

    def show(Long id) {
        respond redSocialService.get(id)
    }

    def create() {
        respond new RedSocial(params)
    }

    def save(RedSocial redSocial) {
        if (redSocial == null) {
            notFound()
            return
        }

        try {
            redSocialService.save(redSocial)
        } catch (ValidationException e) {
            respond redSocial.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), redSocial.id])
                redirect redSocial
            }
            '*' { respond redSocial, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond redSocialService.get(id)
    }

    def update(RedSocial redSocial) {
        if (redSocial == null) {
            notFound()
            return
        }

        try {
            redSocialService.save(redSocial)
        } catch (ValidationException e) {
            respond redSocial.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), redSocial.id])
                redirect redSocial
            }
            '*'{ respond redSocial, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        redSocialService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'redSocial.label', default: 'RedSocial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
