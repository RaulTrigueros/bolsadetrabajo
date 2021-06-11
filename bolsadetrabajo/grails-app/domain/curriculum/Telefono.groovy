package curriculum
import seguridad.Persona

class Telefono {
        
    Integer numero
    String tipoTelefono
    static belongsTo =[persona:Persona]
    
    static constraints = {
        numero (nullable:true, blank:true, maxSize:8)
        tipoTelefono (inList:["Fijo","Celular"])     
    }

    static mapping ={
        id column:'id_telefono'
        version false
    }
}
