package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IdiomaServiceSpec extends Specification {

    IdiomaService idiomaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Idioma(...).save(flush: true, failOnError: true)
        //new Idioma(...).save(flush: true, failOnError: true)
        //Idioma idioma = new Idioma(...).save(flush: true, failOnError: true)
        //new Idioma(...).save(flush: true, failOnError: true)
        //new Idioma(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //idioma.id
    }

    void "test get"() {
        setupData()

        expect:
        idiomaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Idioma> idiomaList = idiomaService.list(max: 2, offset: 2)

        then:
        idiomaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        idiomaService.count() == 5
    }

    void "test delete"() {
        Long idiomaId = setupData()

        expect:
        idiomaService.count() == 5

        when:
        idiomaService.delete(idiomaId)
        sessionFactory.currentSession.flush()

        then:
        idiomaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Idioma idioma = new Idioma()
        idiomaService.save(idioma)

        then:
        idioma.id != null
    }
}
