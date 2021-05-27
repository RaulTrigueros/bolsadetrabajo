package publicaciones

import grails.gorm.services.Service

@Service(Publicaciones)
interface PublicacionesService {

    Publicaciones get(Serializable id)

    List<Publicaciones> list(Map args)

    Long count()

    void delete(Serializable id)

    Publicaciones save(Publicaciones publicaciones)

}