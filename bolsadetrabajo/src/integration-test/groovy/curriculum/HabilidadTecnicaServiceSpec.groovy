package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HabilidadTecnicaServiceSpec extends Specification {

    HabilidadTecnicaService habilidadTecnicaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HabilidadTecnica(...).save(flush: true, failOnError: true)
        //new HabilidadTecnica(...).save(flush: true, failOnError: true)
        //HabilidadTecnica habilidadTecnica = new HabilidadTecnica(...).save(flush: true, failOnError: true)
        //new HabilidadTecnica(...).save(flush: true, failOnError: true)
        //new HabilidadTecnica(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //habilidadTecnica.id
    }

    void "test get"() {
        setupData()

        expect:
        habilidadTecnicaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HabilidadTecnica> habilidadTecnicaList = habilidadTecnicaService.list(max: 2, offset: 2)

        then:
        habilidadTecnicaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        habilidadTecnicaService.count() == 5
    }

    void "test delete"() {
        Long habilidadTecnicaId = setupData()

        expect:
        habilidadTecnicaService.count() == 5

        when:
        habilidadTecnicaService.delete(habilidadTecnicaId)
        sessionFactory.currentSession.flush()

        then:
        habilidadTecnicaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HabilidadTecnica habilidadTecnica = new HabilidadTecnica()
        habilidadTecnicaService.save(habilidadTecnica)

        then:
        habilidadTecnica.id != null
    }
}
