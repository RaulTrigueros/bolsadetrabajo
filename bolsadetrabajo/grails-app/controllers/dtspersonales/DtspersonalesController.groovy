package dtspersonales
import dtspersonales.Dtspersonales
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DtspersonalesController {

    DtspersonalesService dtspersonalesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dtspersonalesService.list(params), model:[dtspersonalesCount: dtspersonalesService.count()]
    }

    def show(Long id) {
        respond dtspersonalesService.get(id)
    }

    def create() {
        respond new Dtspersonales(params)
    }

    def save(Dtspersonales dtspersonales) {
        if (dtspersonales == null) {
            notFound()
            return
        }

        try {
            dtspersonalesService.save(dtspersonales)
        } catch (ValidationException e) {
            respond dtspersonales.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dtspersonales.label', default: 'Dtspersonales'), dtspersonales.id])
                redirect dtspersonales
            }
            '*' { respond dtspersonales, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond dtspersonalesService.get(id)
    }

    def update(Dtspersonales dtspersonales) {
        if (dtspersonales == null) {
            notFound()
            return
        }

        try {
            dtspersonalesService.save(dtspersonales)
        } catch (ValidationException e) {
            respond dtspersonales.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dtspersonales.label', default: 'Dtspersonales'), dtspersonales.id])
                redirect dtspersonales
            }
            '*'{ respond dtspersonales, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dtspersonalesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dtspersonales.label', default: 'Dtspersonales'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dtspersonales.label', default: 'Dtspersonales'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
