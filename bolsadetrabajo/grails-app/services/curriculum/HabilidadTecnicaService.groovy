package curriculum

import grails.gorm.services.Service

@Service(HabilidadTecnica)
interface HabilidadTecnicaService {

    HabilidadTecnica get(Serializable id)

    List<HabilidadTecnica> list(Map args)

    Long count()

    void delete(Serializable id)

    HabilidadTecnica save(HabilidadTecnica habilidadTecnica)

}