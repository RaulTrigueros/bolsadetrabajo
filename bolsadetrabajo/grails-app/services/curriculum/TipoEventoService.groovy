package curriculum

import grails.gorm.services.Service

@Service(TipoEvento)
interface TipoEventoService {

    TipoEvento get(Serializable id)

    List<TipoEvento> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoEvento save(TipoEvento tipoEvento)

}