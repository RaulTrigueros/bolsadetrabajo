package curriculum

import grails.gorm.services.Service

@Service(Formacion)
interface FormacionService {

    Formacion get(Serializable id)

    List<Formacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Formacion save(Formacion formacion)

}