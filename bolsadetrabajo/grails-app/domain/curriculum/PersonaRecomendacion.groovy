package curriculum
import seguridad.Persona

class PersonaRecomendacion {

    String nombreRecomendacion
    String telefonoRecomendador
    String correoRecomendador
    String institucionRecomendacion
    
    static belongsTo = [persona:Persona]
    
    static constraints = {
        nombreRecomendacion (size:1..50, blank:false)
        telefonoRecomendador (blank:false, masSize:9)
        correoRecomendador (size:1..50, blank:false, email:true)
        institucionRecomendacion (size:1..50, blank:false)
    }
    
    static mapping ={
        id column: 'id_recom'
        version false
    }
    String toString(){
        nombreRecomendacion
    }
}
