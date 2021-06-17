package curriculum
import seguridad.Persona

class Idioma {
   
    String nombreIdioma
    static hasMany=[idiomaPersona:IdiomaPersona]
    static constraints = {        
        nombreIdioma (nullable:true, blank:false, size:1..100)
        
    }
     static mapping ={
        id column: 'id_idioma'
        version false
    }
    String toString(){
        nombreIdioma
    }

}
