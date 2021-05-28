package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PersonaRecomendacionServiceSpec extends Specification {

    PersonaRecomendacionService personaRecomendacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PersonaRecomendacion(...).save(flush: true, failOnError: true)
        //new PersonaRecomendacion(...).save(flush: true, failOnError: true)
        //PersonaRecomendacion personaRecomendacion = new PersonaRecomendacion(...).save(flush: true, failOnError: true)
        //new PersonaRecomendacion(...).save(flush: true, failOnError: true)
        //new PersonaRecomendacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //personaRecomendacion.id
    }

    void "test get"() {
        setupData()

        expect:
        personaRecomendacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PersonaRecomendacion> personaRecomendacionList = personaRecomendacionService.list(max: 2, offset: 2)

        then:
        personaRecomendacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        personaRecomendacionService.count() == 5
    }

    void "test delete"() {
        Long personaRecomendacionId = setupData()

        expect:
        personaRecomendacionService.count() == 5

        when:
        personaRecomendacionService.delete(personaRecomendacionId)
        sessionFactory.currentSession.flush()

        then:
        personaRecomendacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PersonaRecomendacion personaRecomendacion = new PersonaRecomendacion()
        personaRecomendacionService.save(personaRecomendacion)

        then:
        personaRecomendacion.id != null
    }
}
