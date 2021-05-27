package curriculum

import grails.gorm.services.Service

@Service(Logro)
interface LogroService {

    Logro get(Serializable id)

    List<Logro> list(Map args)

    Long count()

    void delete(Serializable id)

    Logro save(Logro logro)

}