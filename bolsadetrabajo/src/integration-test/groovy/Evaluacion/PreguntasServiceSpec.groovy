package Evaluacion

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PreguntasServiceSpec extends Specification {

    PreguntasService preguntasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Preguntas(...).save(flush: true, failOnError: true)
        //new Preguntas(...).save(flush: true, failOnError: true)
        //Preguntas preguntas = new Preguntas(...).save(flush: true, failOnError: true)
        //new Preguntas(...).save(flush: true, failOnError: true)
        //new Preguntas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //preguntas.id
    }

    void "test get"() {
        setupData()

        expect:
        preguntasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Preguntas> preguntasList = preguntasService.list(max: 2, offset: 2)

        then:
        preguntasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        preguntasService.count() == 5
    }

    void "test delete"() {
        Long preguntasId = setupData()

        expect:
        preguntasService.count() == 5

        when:
        preguntasService.delete(preguntasId)
        sessionFactory.currentSession.flush()

        then:
        preguntasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Preguntas preguntas = new Preguntas()
        preguntasService.save(preguntas)

        then:
        preguntas.id != null
    }
}
