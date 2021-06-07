package curriculum

import grails.gorm.services.Service

@Service(ParticipacionEvento)
interface ParticipacionEventoService {

    ParticipacionEvento get(Serializable id)

    List<ParticipacionEvento> list(Map args)

    Long count()

    void delete(Serializable id)

    ParticipacionEvento save(ParticipacionEvento participacionEvento)

}