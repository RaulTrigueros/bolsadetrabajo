package dtspersonales

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DtspersonalesServiceSpec extends Specification {

    DtspersonalesService dtspersonalesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Dtspersonales(...).save(flush: true, failOnError: true)
        //new Dtspersonales(...).save(flush: true, failOnError: true)
        //Dtspersonales dtspersonales = new Dtspersonales(...).save(flush: true, failOnError: true)
        //new Dtspersonales(...).save(flush: true, failOnError: true)
        //new Dtspersonales(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //dtspersonales.id
    }

    void "test get"() {
        setupData()

        expect:
        dtspersonalesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Dtspersonales> dtspersonalesList = dtspersonalesService.list(max: 2, offset: 2)

        then:
        dtspersonalesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        dtspersonalesService.count() == 5
    }

    void "test delete"() {
        Long dtspersonalesId = setupData()

        expect:
        dtspersonalesService.count() == 5

        when:
        dtspersonalesService.delete(dtspersonalesId)
        sessionFactory.currentSession.flush()

        then:
        dtspersonalesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Dtspersonales dtspersonales = new Dtspersonales()
        dtspersonalesService.save(dtspersonales)

        then:
        dtspersonales.id != null
    }
}
