package curriculum
import seguridad.Persona

class HabilidadTecnica {
    Integer id
    Persona idPersona
    String tipoHabilidad
    String nombreHabilidad
    
    static constraints = {
        tipoHabilidad maxZize:200
        nombreHabilidad maxZize:200
    }
    static mapping ={
        id column: 'id_habilidad'
    }
}
