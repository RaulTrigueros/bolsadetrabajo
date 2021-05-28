package curriculum

import grails.gorm.services.Service

@Service(Idioma)
interface IdiomaService {

    Idioma get(Serializable id)

    List<Idioma> list(Map args)

    Long count()

    void delete(Serializable id)

    Idioma save(Idioma idioma)

}