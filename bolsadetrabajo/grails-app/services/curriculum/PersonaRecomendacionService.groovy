package curriculum

import grails.gorm.services.Service

@Service(PersonaRecomendacion)
interface PersonaRecomendacionService {

    PersonaRecomendacion get(Serializable id)

    List<PersonaRecomendacion> list(Map args)

    Long count()

    void delete(Serializable id)

    PersonaRecomendacion save(PersonaRecomendacion personaRecomendacion)

}