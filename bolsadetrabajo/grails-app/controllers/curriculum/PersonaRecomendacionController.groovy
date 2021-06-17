package curriculum
import seguridad.Persona

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PersonaRecomendacionController {

    PersonaRecomendacionService personaRecomendacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Long id) {
        def usu =id
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
       
        params.id = Math.min(id ?: 10, 100)
        respond personaRecomendacionService.list(params),model:[pos:pos,usu:usu, personaRecomendacionCount: personaRecomendacionService.count()]
 
    }
    
    def listar(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personaRecomendacionService.list(params), model:[personaRecomendacionCount: personaRecomendacionService.count()]
    }

    def show(Long id) {
        def str = PersonaRecomendacion.executeQuery("select persona.id from PersonaRecomendacion p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        
        respond personaRecomendacionService.get(id), model:[pos:pos]
    }

    def create(Long id) {
        def pos=id
        respond new PersonaRecomendacion(params), model:[pos:pos]
    }

    def save(PersonaRecomendacion personaRecomendacion) {
        if (personaRecomendacion == null) {
            notFound()
            return
        }

        try {
            personaRecomendacionService.save(personaRecomendacion)
        } catch (ValidationException e) {
            respond personaRecomendacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), personaRecomendacion.id])
                redirect personaRecomendacion
            }
            '*' { respond personaRecomendacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def str = PersonaRecomendacion.executeQuery("select persona.id from PersonaRecomendacion p where id ="+id)
        def pos =(str.toString().replace("[", "").replace("]", ""))
        respond personaRecomendacionService.get(id), model:[pos:pos]
    }

    def update(PersonaRecomendacion personaRecomendacion) {
        if (personaRecomendacion == null) {
            notFound()
            return
        }

        try {
            personaRecomendacionService.save(personaRecomendacion)
        } catch (ValidationException e) {
            respond personaRecomendacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), personaRecomendacion.id])
                redirect personaRecomendacion
            }
            '*'{ respond personaRecomendacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personaRecomendacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
