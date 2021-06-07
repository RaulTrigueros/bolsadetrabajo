package curriculum

import grails.gorm.services.Service

@Service(Publicacion)
interface PublicacionService {

    Publicacion get(Serializable id)

    List<Publicacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Publicacion save(Publicacion publicacion)

}