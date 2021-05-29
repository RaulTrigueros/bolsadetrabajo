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
    }
     static mapping ={
        id column: 'id_xp'
    }
}
