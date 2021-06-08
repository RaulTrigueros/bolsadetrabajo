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
        fechaInicio (blank:false,validator: {
            if (it?.compareTo(new Date()) > 0)
                return false
            return true
        })
        fechaFin (blank:false,validator: {
            if (it?.compareTo(new Date()) > 0)
                return false
            return true
        })
    }
    static mapping ={
        id column: 'id_participacion'
    }
    String toString(){
        nombreEvento
    }
}
