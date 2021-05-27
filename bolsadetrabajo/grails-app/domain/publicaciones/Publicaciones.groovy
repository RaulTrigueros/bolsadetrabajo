package publicaciones
import java.util.Date
class Publicaciones {
    
    String nombrePublicacion
    String tipoPublicacion
    Date fechaPubliacion
    String lugarPublicacion
    String edicion
    String isbn

    static constraints = {
        nombrePublicacion (nulleable:true, blank:false, size:1..100)
        tipoPublicacion (nulleable:true, blank:false, size:1..15)
        lugarPublicacion (nulleable:true, blank:false, size:1..50)
        edicion (nulleable:true, blank:false, size:1..20)
        isbn (nulleable:true, blank:false, size:1..20)
    }
}
