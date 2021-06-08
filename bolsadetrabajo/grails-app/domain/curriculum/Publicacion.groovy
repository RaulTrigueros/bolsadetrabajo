package curriculum
import seguridad.*
import java.util.Date

class Publicacion {
    String nombrePublicacion
    String tipoPublicacion
    Date fechaPublicacion
    String edicion
    String isbn
    
    static belongsTo = [persona:Persona]
    
    static constraints = {
        nombrePublicacion (nullable:true, blank:false, size:1..100)
        tipoPublicacion (nullable:true, blank:false, size:1..15)
        fechaPublicacion (blank:false,validator: {
            if (it?.compareTo(new Date()) > 0)
                return false
            return true
        })
    }
    static mapping ={
        id column: 'id_publicaciones'
    }
    String toString(){
        edicion
    }
}
