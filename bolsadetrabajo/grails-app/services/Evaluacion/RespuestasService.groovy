package Evaluacion

import grails.gorm.services.Service

@Service(Respuestas)
interface RespuestasService {

    Respuestas get(Serializable id)

    List<Respuestas> list(Map args)

    Long count()

    void delete(Serializable id)

    Respuestas save(Respuestas respuestas)

}