package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PublicacionController {

    PublicacionService publicacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond publicacionService.list(params), model:[publicacionCount: publicacionService.count()]
    }

    def show(Long id) {
        respond publicacionService.get(id)
    }

    def create() {
        respond new Publicacion(params)
    }

    def save(Publicacion publicacion) {
        if (publicacion == null) {
            notFound()
            return
        }

        try {
            publicacionService.save(publicacion)
        } catch (ValidationException e) {
            respond publicacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect publicacion
            }
            '*' { respond publicacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond publicacionService.get(id)
    }

    def update(Publicacion publicacion) {
        if (publicacion == null) {
            notFound()
            return
        }

        try {
            publicacionService.save(publicacion)
        } catch (ValidationException e) {
            respond publicacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), publicacion.id])
                redirect publicacion
            }
            '*'{ respond publicacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        publicacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicacion.label', default: 'Publicacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
