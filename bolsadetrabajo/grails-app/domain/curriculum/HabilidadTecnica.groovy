package curriculum
import seguridad.Persona

class HabilidadTecnica {
    
    String tipoHabilidad
    String nombreHabilidad
    static belongsTo=[persona:Persona]
    static constraints = {
        tipoHabilidad maxZize:200
        nombreHabilidad maxZize:200
    }
    static mapping ={
        id column: 'id_habilidad'
    }
    String toString(){
        nombreHabilidad
    }
}
