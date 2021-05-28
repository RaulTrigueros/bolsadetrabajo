package empresa

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PerfilPuestoServiceSpec extends Specification {

    PerfilPuestoService perfilPuestoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PerfilPuesto(...).save(flush: true, failOnError: true)
        //new PerfilPuesto(...).save(flush: true, failOnError: true)
        //PerfilPuesto perfilPuesto = new PerfilPuesto(...).save(flush: true, failOnError: true)
        //new PerfilPuesto(...).save(flush: true, failOnError: true)
        //new PerfilPuesto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //perfilPuesto.id
    }

    void "test get"() {
        setupData()

        expect:
        perfilPuestoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PerfilPuesto> perfilPuestoList = perfilPuestoService.list(max: 2, offset: 2)

        then:
        perfilPuestoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        perfilPuestoService.count() == 5
    }

    void "test delete"() {
        Long perfilPuestoId = setupData()

        expect:
        perfilPuestoService.count() == 5

        when:
        perfilPuestoService.delete(perfilPuestoId)
        sessionFactory.currentSession.flush()

        then:
        perfilPuestoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PerfilPuesto perfilPuesto = new PerfilPuesto()
        perfilPuestoService.save(perfilPuesto)

        then:
        perfilPuesto.id != null
    }
}
