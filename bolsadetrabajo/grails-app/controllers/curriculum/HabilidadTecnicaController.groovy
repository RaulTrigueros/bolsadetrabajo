package curriculum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HabilidadTecnicaController {

    HabilidadTecnicaService habilidadTecnicaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond habilidadTecnicaService.list(params), model:[habilidadTecnicaCount: habilidadTecnicaService.count()]
    }

    def show(Long id) {
        respond habilidadTecnicaService.get(id)
    }

    def create() {
        respond new HabilidadTecnica(params)
    }

    def save(HabilidadTecnica habilidadTecnica) {
        if (habilidadTecnica == null) {
            notFound()
            return
        }

        try {
            habilidadTecnicaService.save(habilidadTecnica)
        } catch (ValidationException e) {
            respond habilidadTecnica.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'habilidadTecnica.label', default: 'HabilidadTecnica'), habilidadTecnica.id])
                redirect habilidadTecnica
            }
            '*' { respond habilidadTecnica, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond habilidadTecnicaService.get(id)
    }

    def update(HabilidadTecnica habilidadTecnica) {
        if (habilidadTecnica == null) {
            notFound()
            return
        }

        try {
            habilidadTecnicaService.save(habilidadTecnica)
        } catch (ValidationException e) {
            respond habilidadTecnica.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'habilidadTecnica.label', default: 'HabilidadTecnica'), habilidadTecnica.id])
                redirect habilidadTecnica
            }
            '*'{ respond habilidadTecnica, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        habilidadTecnicaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'habilidadTecnica.label', default: 'HabilidadTecnica'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'habilidadTecnica.label', default: 'HabilidadTecnica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
