package curriculum
import seguridad.Persona
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LogroController {

    LogroService logroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond logroService.list(params), model:[usu:usu, pos:pos, logroCount: logroService.count()]
    }

    def show(Long id) {
        def str = Logro.executeQuery("select persona.id from Logro p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond logroService.get(id),model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new Logro(params),model:[pos:pos]
    }

    def save(Logro logro) {
        if (logro == null) {
            notFound()
            return
        }

        try {
            logroService.save(logro)
        } catch (ValidationException e) {
            respond logro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logro.label', default: 'Logro'), logro.id])
                redirect logro
            }
            '*' { respond logro, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = Logro.executeQuery("select persona.id from Logro p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond logroService.get(id),model:[per:pos]
    }

    def update(Logro logro) {
        if (logro == null) {
            notFound()
            return
        }

        try {
            logroService.save(logro)
        } catch (ValidationException e) {
            respond logro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'logro.label', default: 'Logro'), logro.id])
                redirect logro
            }
            '*'{ respond logro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        logroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'logro.label', default: 'Logro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logro.label', default: 'Logro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
