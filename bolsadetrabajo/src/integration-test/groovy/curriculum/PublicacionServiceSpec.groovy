package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PublicacionServiceSpec extends Specification {

    PublicacionService publicacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Publicacion(...).save(flush: true, failOnError: true)
        //new Publicacion(...).save(flush: true, failOnError: true)
        //Publicacion publicacion = new Publicacion(...).save(flush: true, failOnError: true)
        //new Publicacion(...).save(flush: true, failOnError: true)
        //new Publicacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //publicacion.id
    }

    void "test get"() {
        setupData()

        expect:
        publicacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Publicacion> publicacionList = publicacionService.list(max: 2, offset: 2)

        then:
        publicacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        publicacionService.count() == 5
    }

    void "test delete"() {
        Long publicacionId = setupData()

        expect:
        publicacionService.count() == 5

        when:
        publicacionService.delete(publicacionId)
        sessionFactory.currentSession.flush()

        then:
        publicacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Publicacion publicacion = new Publicacion()
        publicacionService.save(publicacion)

        then:
        publicacion.id != null
    }
}
