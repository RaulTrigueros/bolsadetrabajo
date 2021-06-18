package empresa

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PerfilPuestoController {

    PerfilPuestoService perfilPuestoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Long id) {
        //def str = Empresa.executeQuery("select id from Empresa e where e.usuarios.id ="+id)
        def emp = id//str.toString().replace("[", "").replace("]", "")
        params.id = Math.min(id ?: 10, 100)
        respond perfilPuestoService.list(params), model:[emp:emp, perfilPuestoCount: perfilPuestoService.count()]
    }

    def show(Long id) {
        def str = PerfilPuesto.executeQuery("select empresa from PerfilPuesto e where e.empresa ="+id)
        def emp = str.toString().replace("[", "").replace("]", "")
        println(emp)
        respond perfilPuestoService.get(id),model:[emp:emp]
    }

    def create(long id) {
        def str = Empresa.executeQuery("select id from Empresa e where e.usuarios.id ="+id)
        def emp = str.toString().replace("[", "").replace("]", "")
        respond new PerfilPuesto(params),model:[emp:emp]
    }

    def save(PerfilPuesto perfilPuesto) {
        if (perfilPuesto == null) {
            notFound()
            return
        }

        try {
            perfilPuestoService.save(perfilPuesto)
        } catch (ValidationException e) {
            respond perfilPuesto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'perfilPuesto.label', default: 'PerfilPuesto'), perfilPuesto.id])
                redirect perfilPuesto
            }
            '*' { respond perfilPuesto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond perfilPuestoService.get(id)
    }

    def update(PerfilPuesto perfilPuesto) {
        if (perfilPuesto == null) {
            notFound()
            return
        }

        try {
            perfilPuestoService.save(perfilPuesto)
        } catch (ValidationException e) {
            respond perfilPuesto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'perfilPuesto.label', default: 'PerfilPuesto'), perfilPuesto.id])
                redirect perfilPuesto
            }
            '*'{ respond perfilPuesto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        perfilPuestoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'perfilPuesto.label', default: 'PerfilPuesto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfilPuesto.label', default: 'PerfilPuesto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
