package publicaciones

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PublicacionesController {

    PublicacionesService publicacionesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond publicacionesService.list(params), model:[publicacionesCount: publicacionesService.count()]
    }

    def show(Long id) {
        respond publicacionesService.get(id)
    }

    def create() {
        respond new Publicaciones(params)
    }

    def save(Publicaciones publicaciones) {
        if (publicaciones == null) {
            notFound()
            return
        }

        try {
            publicacionesService.save(publicaciones)
        } catch (ValidationException e) {
            respond publicaciones.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publicaciones.label', default: 'Publicaciones'), publicaciones.id])
                redirect publicaciones
            }
            '*' { respond publicaciones, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond publicacionesService.get(id)
    }

    def update(Publicaciones publicaciones) {
        if (publicaciones == null) {
            notFound()
            return
        }

        try {
            publicacionesService.save(publicaciones)
        } catch (ValidationException e) {
            respond publicaciones.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publicaciones.label', default: 'Publicaciones'), publicaciones.id])
                redirect publicaciones
            }
            '*'{ respond publicaciones, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        publicacionesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicaciones.label', default: 'Publicaciones'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicaciones.label', default: 'Publicaciones'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
