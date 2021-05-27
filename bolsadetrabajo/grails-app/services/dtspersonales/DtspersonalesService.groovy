package dtspersonales

import grails.gorm.services.Service

@Service(Dtspersonales)
interface DtspersonalesService {

    Dtspersonales get(Serializable id)

    List<Dtspersonales> list(Map args)

    Long count()

    void delete(Serializable id)

    Dtspersonales save(Dtspersonales dtspersonales)

}