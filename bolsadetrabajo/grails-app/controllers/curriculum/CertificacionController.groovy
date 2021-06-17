package curriculum
import seguridad.Persona
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CertificacionController {

    CertificacionService certificacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer id) {
        def usu=id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        params.id = Math.min(id ?: 10, 100)
        respond certificacionService.list(params), model:[usu:usu,pos:pos,certificacionCount: certificacionService.count()]
    }

    def show(Long id) {
        def str = Certificacion.executeQuery("select persona.id from Certificacion p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond certificacionService.get(id),model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new Certificacion(params),model:[pos:pos]
    }

    def save(Certificacion certificacion) {
        if (certificacion == null) {
            notFound()
            return
        }

        try {
            certificacionService.save(certificacion)
        } catch (ValidationException e) {
            respond certificacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), certificacion.id])
                redirect certificacion
            }
            '*' { respond certificacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = Certificacion.executeQuery("select persona.id from Certificacion p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond certificacionService.get(id),model:[pos:pos]
    }

    def update(Certificacion certificacion) {
        if (certificacion == null) {
            notFound()
            return
        }

        try {
            certificacionService.save(certificacion)
        } catch (ValidationException e) {
            respond certificacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), certificacion.id])
                redirect certificacion
            }
            '*'{ respond certificacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        certificacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'certificacion.label', default: 'Certificacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
