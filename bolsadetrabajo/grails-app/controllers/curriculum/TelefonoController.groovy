package curriculum
import seguridad.Persona

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TelefonoController {

    TelefonoService telefonoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Long id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond telefonoService.list(params), model:[usu:usu,pos:pos,telefonoCount: telefonoService.count()]
    }

    def show(Long id) {
        def str = Telefono.executeQuery("select persona.id from Telefono p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        
        respond telefonoService.get(id), model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new Telefono(params),model:[pos:pos]
    }

    def save(Telefono telefono) {
        if (telefono == null) {
            notFound()
            return
        }

        try {
            telefonoService.save(telefono)
        } catch (ValidationException e) {
            respond telefono.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'telefono.label', default: 'Telefono'), telefono.id])
                redirect telefono
            }
            '*' { respond telefono, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = Telefono.executeQuery("select persona.id from Telefono p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond telefonoService.get(id),model:[pos:pos]
    }

    def update(Telefono telefono) {
        if (telefono == null) {
            notFound()
            return
        }

        try {
            telefonoService.save(telefono)
        } catch (ValidationException e) {
            respond telefono.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'telefono.label', default: 'Telefono'), telefono.id])
                redirect telefono
            }
            '*'{ respond telefono, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        telefonoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'telefono.label', default: 'Telefono'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'telefono.label', default: 'Telefono'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
