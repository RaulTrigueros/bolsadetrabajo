package curriculum
import curriculum.TipoEvento
import seguridad.Persona

class ParticipacionEvento {
    Integer id
    Persona idPersona
    TipoEvento idTipoEvento
    String nombreEvento
    Date fechaInicio
    Date fechaFin
    String institucionAnfitriona
    
    static constraints = {
        nombreEvento maxZize:100
        institucionAnfitriona maxZize:100
    }
    static mapping ={
        id column: 'id_participacion'
    }
}
