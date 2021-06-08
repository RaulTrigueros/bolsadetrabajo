package Evaluacion

import grails.gorm.services.Service

@Service(TipoEvaluacion)
interface TipoEvaluacionService {

    TipoEvaluacion get(Serializable id)

    List<TipoEvaluacion> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoEvaluacion save(TipoEvaluacion tipoEvaluacion)

}