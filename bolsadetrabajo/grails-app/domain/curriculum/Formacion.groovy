package curriculum
import seguridad.Persona

class Formacion {
    
    Date fechaInicio
    Date fechaFin
    String tipoFormacion
    String nombreFormacion
    String institucionDeFormacion
    
    static constraints = {
        fechaInicio blank:false
        fechaFin blank:false
        tipoFormacion (inList:["titulo","diploma", "curso"]) 
        nombreFormacion maxZize:200
        institucionDeFormacion maxZize:200
    }
    static mapping ={
        id column: 'id_form'
    }
}
