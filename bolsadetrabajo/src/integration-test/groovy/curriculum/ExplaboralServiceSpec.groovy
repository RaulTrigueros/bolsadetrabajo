package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExplaboralServiceSpec extends Specification {

    ExplaboralService explaboralService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Explaboral(...).save(flush: true, failOnError: true)
        //new Explaboral(...).save(flush: true, failOnError: true)
        //Explaboral explaboral = new Explaboral(...).save(flush: true, failOnError: true)
        //new Explaboral(...).save(flush: true, failOnError: true)
        //new Explaboral(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //explaboral.id
    }

    void "test get"() {
        setupData()

        expect:
        explaboralService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Explaboral> explaboralList = explaboralService.list(max: 2, offset: 2)

        then:
        explaboralList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        explaboralService.count() == 5
    }

    void "test delete"() {
        Long explaboralId = setupData()

        expect:
        explaboralService.count() == 5

        when:
        explaboralService.delete(explaboralId)
        sessionFactory.currentSession.flush()

        then:
        explaboralService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Explaboral explaboral = new Explaboral()
        explaboralService.save(explaboral)

        then:
        explaboral.id != null
    }
}
