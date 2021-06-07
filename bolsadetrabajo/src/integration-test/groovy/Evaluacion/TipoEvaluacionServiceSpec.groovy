package Evaluacion

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoEvaluacionServiceSpec extends Specification {

    TipoEvaluacionService tipoEvaluacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoEvaluacion(...).save(flush: true, failOnError: true)
        //new TipoEvaluacion(...).save(flush: true, failOnError: true)
        //TipoEvaluacion tipoEvaluacion = new TipoEvaluacion(...).save(flush: true, failOnError: true)
        //new TipoEvaluacion(...).save(flush: true, failOnError: true)
        //new TipoEvaluacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoEvaluacion.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoEvaluacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoEvaluacion> tipoEvaluacionList = tipoEvaluacionService.list(max: 2, offset: 2)

        then:
        tipoEvaluacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoEvaluacionService.count() == 5
    }

    void "test delete"() {
        Long tipoEvaluacionId = setupData()

        expect:
        tipoEvaluacionService.count() == 5

        when:
        tipoEvaluacionService.delete(tipoEvaluacionId)
        sessionFactory.currentSession.flush()

        then:
        tipoEvaluacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoEvaluacion tipoEvaluacion = new TipoEvaluacion()
        tipoEvaluacionService.save(tipoEvaluacion)

        then:
        tipoEvaluacion.id != null
    }
}
