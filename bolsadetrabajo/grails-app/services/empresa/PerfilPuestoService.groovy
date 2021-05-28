package empresa

import grails.gorm.services.Service

@Service(PerfilPuesto)
interface PerfilPuestoService {

    PerfilPuesto get(Serializable id)

    List<PerfilPuesto> list(Map args)

    Long count()

    void delete(Serializable id)

    PerfilPuesto save(PerfilPuesto perfilPuesto)

}