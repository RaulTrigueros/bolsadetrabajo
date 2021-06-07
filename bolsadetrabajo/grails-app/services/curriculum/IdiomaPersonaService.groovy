package curriculum

import grails.gorm.services.Service

@Service(IdiomaPersona)
interface IdiomaPersonaService {

    IdiomaPersona get(Serializable id)

    List<IdiomaPersona> list(Map args)

    Long count()

    void delete(Serializable id)

    IdiomaPersona save(IdiomaPersona idiomaPersona)

}