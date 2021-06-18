package seguridad

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import empresa.PerfilPuesto

class PersonaController {

    PersonaService personaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Long id) {
        def str = Persona.executeQuery("select id from Persona p where p.usuarios.id ="+id)
        def pos = str.toString().replace("[", "").replace("]", "")

        def perfiles = PerfilPuesto.executeQuery("from PerfilPuesto")
        [pos:pos, perfiles:perfiles]
    }
    
    def listar(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personaService.list(params), model:[personaCount: personaService.count()]
    }

    def show(Long id) {
        if (id){
            def pos = id
            respond personaService.get(id),model:[pos:pos]

        }else {redirect action:"create"}
    }

    def create() {
        respond new Persona(params)
    }

    def save(Persona persona) {
        if (persona == null) {
            notFound()
            return
        }

        try {
            personaService.save(persona)
        } catch (ValidationException e) {
            respond persona.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'persona.label', default: 'Persona'), persona.id])
                redirect persona
            }
            '*' { respond persona, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def pos = id
        respond personaService.get(id),model:[pos:pos]
    }

    def update(Persona persona) {
        if (persona == null) {
            notFound()
            return
        }

        try {
            personaService.save(persona)
        } catch (ValidationException e) {
            respond persona.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'persona.label', default: 'Persona'), persona.id])
                redirect persona
            }
            '*'{ respond persona, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'persona.label', default: 'Persona'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'persona.label', default: 'Persona'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}