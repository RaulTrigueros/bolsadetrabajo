package curriculum

import grails.gorm.services.Service

@Service(RedSocial)
interface RedSocialService {

    RedSocial get(Serializable id)

    List<RedSocial> list(Map args)

    Long count()

    void delete(Serializable id)

    RedSocial save(RedSocial redSocial)

}