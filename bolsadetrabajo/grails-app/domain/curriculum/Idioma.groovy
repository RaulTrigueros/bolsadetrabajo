package curriculum
import seguridad.Persona

class Idioma {
    
   
    String nombreIdioma
    static hasMany=[idiomaPersona:IdiomaPersona]
    static constraints = {        
        nombreIdioma maxSize:20
    }
     static mapping ={
        id column: 'id_idioma'
    }
}
