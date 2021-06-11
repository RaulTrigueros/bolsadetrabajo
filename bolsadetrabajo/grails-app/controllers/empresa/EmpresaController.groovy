package empresa
import  java.util.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmpresaController {

    EmpresaService empresaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def listar(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empresaService.list(params), model:[empresaCount: empresaService.count()]
    }

    def index(Long id) {
        def str = Empresa.executeQuery("select id from Empresa e where e.usuarios.id ="+id)
        def emp = str.toString().replace("[", "").replace("]", "")
        [emp:emp]
    }

    def show(Long id) {
        if (id){
            respond empresaService.get(id)
        }else {redirect action:"create"}
        
    }

    def create() {
        respond new Empresa(params)
    }

    def save(Empresa empresa) {
        if (empresa == null) {
            notFound()
            return
        }

        try {
            empresaService.save(empresa)
        } catch (ValidationException e) {
            respond empresa.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empresa.label', default: 'Empresa'), empresa.id])
                redirect empresa
            }
            '*' { respond empresa, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond empresaService.get(id)
    }

    def update(Empresa empresa) {
        if (empresa == null) {
            notFound()
            return
        }

        try {
            empresaService.save(empresa)
        } catch (ValidationException e) {
            respond empresa.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'empresa.label', default: 'Empresa'), empresa.id])
                redirect empresa
            }
            '*'{ respond empresa, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        empresaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'empresa.label', default: 'Empresa'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empresa.label', default: 'Empresa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
