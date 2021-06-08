package curriculum
import seguridad.Persona

class Formacion {
    
    Date fechaInicio
    Date fechaFin
    String tipoFormacion
    String nombreFormacion
    String institucionDeFormacion
    
    static constraints = {
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
        tipoFormacion (inList:["titulo","diploma", "curso"]) 
        nombreFormacion maxZize:200
        institucionDeFormacion maxZize:200
    }
    static mapping ={
        id column: 'id_form'
        version false
    }
    String toString(){
        nombreFormacion
    }
}
