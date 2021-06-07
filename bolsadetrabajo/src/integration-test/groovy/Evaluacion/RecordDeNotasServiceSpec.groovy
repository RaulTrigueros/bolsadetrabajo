package Evaluacion

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RecordDeNotasServiceSpec extends Specification {

    RecordDeNotasService recordDeNotasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RecordDeNotas(...).save(flush: true, failOnError: true)
        //new RecordDeNotas(...).save(flush: true, failOnError: true)
        //RecordDeNotas recordDeNotas = new RecordDeNotas(...).save(flush: true, failOnError: true)
        //new RecordDeNotas(...).save(flush: true, failOnError: true)
        //new RecordDeNotas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //recordDeNotas.id
    }

    void "test get"() {
        setupData()

        expect:
        recordDeNotasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RecordDeNotas> recordDeNotasList = recordDeNotasService.list(max: 2, offset: 2)

        then:
        recordDeNotasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        recordDeNotasService.count() == 5
    }

    void "test delete"() {
        Long recordDeNotasId = setupData()

        expect:
        recordDeNotasService.count() == 5

        when:
        recordDeNotasService.delete(recordDeNotasId)
        sessionFactory.currentSession.flush()

        then:
        recordDeNotasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RecordDeNotas recordDeNotas = new RecordDeNotas()
        recordDeNotasService.save(recordDeNotas)

        then:
        recordDeNotas.id != null
    }
}
