package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ParticipacionEventoServiceSpec extends Specification {

    ParticipacionEventoService participacionEventoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ParticipacionEvento(...).save(flush: true, failOnError: true)
        //new ParticipacionEvento(...).save(flush: true, failOnError: true)
        //ParticipacionEvento participacionEvento = new ParticipacionEvento(...).save(flush: true, failOnError: true)
        //new ParticipacionEvento(...).save(flush: true, failOnError: true)
        //new ParticipacionEvento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //participacionEvento.id
    }

    void "test get"() {
        setupData()

        expect:
        participacionEventoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ParticipacionEvento> participacionEventoList = participacionEventoService.list(max: 2, offset: 2)

        then:
        participacionEventoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        participacionEventoService.count() == 5
    }

    void "test delete"() {
        Long participacionEventoId = setupData()

        expect:
        participacionEventoService.count() == 5

        when:
        participacionEventoService.delete(participacionEventoId)
        sessionFactory.currentSession.flush()

        then:
        participacionEventoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ParticipacionEvento participacionEvento = new ParticipacionEvento()
        participacionEventoService.save(participacionEvento)

        then:
        participacionEvento.id != null
    }
}
