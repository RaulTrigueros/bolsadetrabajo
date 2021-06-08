package curriculum
import curriculum.TipoEvento
import seguridad.Persona

class ParticipacionEvento {
    
    String nombreEvento
    Date fechaInicio
    Date fechaFin
    String institucionAnfitriona
    static belongsTo =[tipoEvento:TipoEvento, persona:Persona]
    static constraints = {
        nombreEvento maxZize:100
        institucionAnfitriona maxZize:100
    }
    static mapping ={
        id column: 'id_participacion'
    }
}
