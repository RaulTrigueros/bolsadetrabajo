package curriculum
import seguridad.Persona
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExplaboralController {

    ExplaboralService explaboralService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Long id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond explaboralService.list(params), model:[usu:usu,pos:pos,explaboralCount: explaboralService.count()]
    }

    def show(Long id) {
        def str = Explaboral.executeQuery("select persona.id from Explaboral p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond explaboralService.get(id), main:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new Explaboral(params),model:[pos:pos]
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
        def str = Explaboral.executeQuery("select persona.id from Explaboral p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond explaboralService.get(id), model:[pos:pos]
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
