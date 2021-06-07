package curriculum
import seguridad.Persona

class Idioma {
    
    Integer id
    String nombreIdioma
    
    static constraints = {        
        nombreIdioma maxSize:20
    }
     static mapping ={
        id column: 'id_idioma'
    }
}
