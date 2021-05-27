package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LogroServiceSpec extends Specification {

    LogroService logroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Logro(...).save(flush: true, failOnError: true)
        //new Logro(...).save(flush: true, failOnError: true)
        //Logro logro = new Logro(...).save(flush: true, failOnError: true)
        //new Logro(...).save(flush: true, failOnError: true)
        //new Logro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //logro.id
    }

    void "test get"() {
        setupData()

        expect:
        logroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Logro> logroList = logroService.list(max: 2, offset: 2)

        then:
        logroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        logroService.count() == 5
    }

    void "test delete"() {
        Long logroId = setupData()

        expect:
        logroService.count() == 5

        when:
        logroService.delete(logroId)
        sessionFactory.currentSession.flush()

        then:
        logroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Logro logro = new Logro()
        logroService.save(logro)

        then:
        logro.id != null
    }
}
