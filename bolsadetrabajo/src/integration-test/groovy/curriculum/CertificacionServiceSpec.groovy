package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CertificacionServiceSpec extends Specification {

    CertificacionService certificacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Certificacion(...).save(flush: true, failOnError: true)
        //new Certificacion(...).save(flush: true, failOnError: true)
        //Certificacion certificacion = new Certificacion(...).save(flush: true, failOnError: true)
        //new Certificacion(...).save(flush: true, failOnError: true)
        //new Certificacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //certificacion.id
    }

    void "test get"() {
        setupData()

        expect:
        certificacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Certificacion> certificacionList = certificacionService.list(max: 2, offset: 2)

        then:
        certificacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        certificacionService.count() == 5
    }

    void "test delete"() {
        Long certificacionId = setupData()

        expect:
        certificacionService.count() == 5

        when:
        certificacionService.delete(certificacionId)
        sessionFactory.currentSession.flush()

        then:
        certificacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Certificacion certificacion = new Certificacion()
        certificacionService.save(certificacion)

        then:
        certificacion.id != null
    }
}
