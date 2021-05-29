package curriculum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RedSocialServiceSpec extends Specification {

    RedSocialService redSocialService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RedSocial(...).save(flush: true, failOnError: true)
        //new RedSocial(...).save(flush: true, failOnError: true)
        //RedSocial redSocial = new RedSocial(...).save(flush: true, failOnError: true)
        //new RedSocial(...).save(flush: true, failOnError: true)
        //new RedSocial(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //redSocial.id
    }

    void "test get"() {
        setupData()

        expect:
        redSocialService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RedSocial> redSocialList = redSocialService.list(max: 2, offset: 2)

        then:
        redSocialList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        redSocialService.count() == 5
    }

    void "test delete"() {
        Long redSocialId = setupData()

        expect:
        redSocialService.count() == 5

        when:
        redSocialService.delete(redSocialId)
        sessionFactory.currentSession.flush()

        then:
        redSocialService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RedSocial redSocial = new RedSocial()
        redSocialService.save(redSocial)

        then:
        redSocial.id != null
    }
}
