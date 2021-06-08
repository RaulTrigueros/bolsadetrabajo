package Evaluacion

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RespuestasServiceSpec extends Specification {

    RespuestasService respuestasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Respuestas(...).save(flush: true, failOnError: true)
        //new Respuestas(...).save(flush: true, failOnError: true)
        //Respuestas respuestas = new Respuestas(...).save(flush: true, failOnError: true)
        //new Respuestas(...).save(flush: true, failOnError: true)
        //new Respuestas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //respuestas.id
    }

    void "test get"() {
        setupData()

        expect:
        respuestasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Respuestas> respuestasList = respuestasService.list(max: 2, offset: 2)

        then:
        respuestasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        respuestasService.count() == 5
    }

    void "test delete"() {
        Long respuestasId = setupData()

        expect:
        respuestasService.count() == 5

        when:
        respuestasService.delete(respuestasId)
        sessionFactory.currentSession.flush()

        then:
        respuestasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Respuestas respuestas = new Respuestas()
        respuestasService.save(respuestas)

        then:
        respuestas.id != null
    }
}
