package publicaciones
import java.util.Date
class Publicaciones {
    
    Integer id
    String nombrePublicacion
    String tipoPublicacion
    Date fechaPubliacion
    String lugarPublicacion
    String edicion
    String isbn

    static constraints = {
        nombrePublicacion (nullable:true, blank:false, size:1..100)
        tipoPublicacion (nullable:true, blank:false, size:1..15)
        lugarPublicacion (nullable:true, blank:false, size:1..50)
        edicion (nullable:true, blank:false, size:1..20)
        isbn (nullable:true, blank:false, size:1..20)
    }
    
     static mapping ={
        id column: 'id_publicaciones'
    }
}
