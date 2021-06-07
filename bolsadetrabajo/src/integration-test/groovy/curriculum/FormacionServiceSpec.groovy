package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FormacionServiceSpec extends Specification {

    FormacionService formacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Formacion(...).save(flush: true, failOnError: true)
        //new Formacion(...).save(flush: true, failOnError: true)
        //Formacion formacion = new Formacion(...).save(flush: true, failOnError: true)
        //new Formacion(...).save(flush: true, failOnError: true)
        //new Formacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //formacion.id
    }

    void "test get"() {
        setupData()

        expect:
        formacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Formacion> formacionList = formacionService.list(max: 2, offset: 2)

        then:
        formacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        formacionService.count() == 5
    }

    void "test delete"() {
        Long formacionId = setupData()

        expect:
        formacionService.count() == 5

        when:
        formacionService.delete(formacionId)
        sessionFactory.currentSession.flush()

        then:
        formacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Formacion formacion = new Formacion()
        formacionService.save(formacion)

        then:
        formacion.id != null
    }
}
