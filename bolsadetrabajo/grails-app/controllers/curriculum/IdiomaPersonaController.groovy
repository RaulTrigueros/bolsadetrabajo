package curriculum
import seguridad.Persona
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IdiomaPersonaController {

    IdiomaPersonaService idiomaPersonaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond idiomaPersonaService.list(params), model:[usu:usu,pos:pos,idiomaPersonaCount: idiomaPersonaService.count()]
    }

    def show(Long id) {
        def str = IdiomaPersona.executeQuery("select persona.id from IdiomaPersona p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond idiomaPersonaService.get(id),model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new IdiomaPersona(params),model:[pos:pos]
    }

    def save(IdiomaPersona idiomaPersona) {
        if (idiomaPersona == null) {
            notFound()
            return
        }

        try {
            idiomaPersonaService.save(idiomaPersona)
        } catch (ValidationException e) {
            respond idiomaPersona.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), idiomaPersona.id])
                redirect idiomaPersona
            }
            '*' { respond idiomaPersona, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = IdiomaPersona.executeQuery("select persona.id from IdiomaPersona p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond idiomaPersonaService.get(id), model:[pos:pos]
    }

    def update(IdiomaPersona idiomaPersona) {
        if (idiomaPersona == null) {
            notFound()
            return
        }

        try {
            idiomaPersonaService.save(idiomaPersona)
        } catch (ValidationException e) {
            respond idiomaPersona.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), idiomaPersona.id])
                redirect idiomaPersona
            }
            '*'{ respond idiomaPersona, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        idiomaPersonaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'idiomaPersona.label', default: 'IdiomaPersona'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
