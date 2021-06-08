package curriculum
import seguridad.Persona
import java.util.Date
class Explaboral {
    
    String organizacionDeExperiencia
    String contactoOrganizacion
    String puestoTrabajo
    Date fechaInicio
    Date fechaFin
    String funcionesDesempenadas
    
    static belongsTo = [persona:Persona]

    static constraints = {
        organizacionDeExperiencia (blank:false, masSize:200)
        contactoOrganizacion (blank:false, masSize:50)
        puestoTrabajo (blank:false, masSize:100)
        funcionesDesempenadas (blank:false, masSize:150)
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
        id column: 'id_xp'
        version false
    }
    String toString(){
        organizacionDeExperiencia
    }
}
