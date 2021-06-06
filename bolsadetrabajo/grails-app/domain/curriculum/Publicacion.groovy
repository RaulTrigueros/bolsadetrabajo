package curriculum
import seguridad.*
import java.util.Date

class Publicacion {
    
    String edicion
    String isbn
    
    static belongsTo = [persona:Persona]
    
    static constraints = {
        nombrePublicacion (nullable:true, blank:false, size:1..100)
        tipoPublicacion (nullable:true, blank:false, size:1..15)
    }
    static mapping ={
        id column: 'id_publicaciones'
    }
}
