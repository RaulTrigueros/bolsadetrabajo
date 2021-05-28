package curriculum

import grails.gorm.services.Service

@Service(Certificacion)
interface CertificacionService {

    Certificacion get(Serializable id)

    List<Certificacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Certificacion save(Certificacion certificacion)

}