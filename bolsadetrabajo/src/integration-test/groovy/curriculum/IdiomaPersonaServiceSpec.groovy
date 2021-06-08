package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IdiomaPersonaServiceSpec extends Specification {

    IdiomaPersonaService idiomaPersonaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new IdiomaPersona(...).save(flush: true, failOnError: true)
        //new IdiomaPersona(...).save(flush: true, failOnError: true)
        //IdiomaPersona idiomaPersona = new IdiomaPersona(...).save(flush: true, failOnError: true)
        //new IdiomaPersona(...).save(flush: true, failOnError: true)
        //new IdiomaPersona(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //idiomaPersona.id
    }

    void "test get"() {
        setupData()

        expect:
        idiomaPersonaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<IdiomaPersona> idiomaPersonaList = idiomaPersonaService.list(max: 2, offset: 2)

        then:
        idiomaPersonaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        idiomaPersonaService.count() == 5
    }

    void "test delete"() {
        Long idiomaPersonaId = setupData()

        expect:
        idiomaPersonaService.count() == 5

        when:
        idiomaPersonaService.delete(idiomaPersonaId)
        sessionFactory.currentSession.flush()

        then:
        idiomaPersonaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        IdiomaPersona idiomaPersona = new IdiomaPersona()
        idiomaPersonaService.save(idiomaPersona)

        then:
        idiomaPersona.id != null
    }
}
