package Evaluacion

import grails.gorm.services.Service

@Service(Preguntas)
interface PreguntasService {

    Preguntas get(Serializable id)

    List<Preguntas> list(Map args)

    Long count()

    void delete(Serializable id)

    Preguntas save(Preguntas preguntas)

}