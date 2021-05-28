package curriculum

import grails.gorm.services.Service

@Service(Explaboral)
interface ExplaboralService {

    Explaboral get(Serializable id)

    List<Explaboral> list(Map args)

    Long count()

    void delete(Serializable id)

    Explaboral save(Explaboral explaboral)

}