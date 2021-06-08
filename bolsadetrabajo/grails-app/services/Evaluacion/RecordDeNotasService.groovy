package Evaluacion

import grails.gorm.services.Service

@Service(RecordDeNotas)
interface RecordDeNotasService {

    RecordDeNotas get(Serializable id)

    List<RecordDeNotas> list(Map args)

    Long count()

    void delete(Serializable id)

    RecordDeNotas save(RecordDeNotas recordDeNotas)

}