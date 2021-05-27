package publicaciones

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PublicacionesServiceSpec extends Specification {

    PublicacionesService publicacionesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Publicaciones(...).save(flush: true, failOnError: true)
        //new Publicaciones(...).save(flush: true, failOnError: true)
        //Publicaciones publicaciones = new Publicaciones(...).save(flush: true, failOnError: true)
        //new Publicaciones(...).save(flush: true, failOnError: true)
        //new Publicaciones(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //publicaciones.id
    }

    void "test get"() {
        setupData()

        expect:
        publicacionesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Publicaciones> publicacionesList = publicacionesService.list(max: 2, offset: 2)

        then:
        publicacionesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        publicacionesService.count() == 5
    }

    void "test delete"() {
        Long publicacionesId = setupData()

        expect:
        publicacionesService.count() == 5

        when:
        publicacionesService.delete(publicacionesId)
        sessionFactory.currentSession.flush()

        then:
        publicacionesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Publicaciones publicaciones = new Publicaciones()
        publicacionesService.save(publicaciones)

        then:
        publicaciones.id != null
    }
}
