package curriculum
import seguridad.Persona

class Idioma {
   
    String nombreIdioma
    static hasMany=[idiomaPersona:IdiomaPersona]
    static constraints = {        
        nombreIdioma (inList:["Ingles", "Francés", "Portugues","Alemán","Japonés","Chino","Vietnamita","Ruso","Mandarin","Hindi","Arabe","Nahuatl"])
        
    }
     static mapping ={
        id column: 'id_idioma'
        version false
    }
    String toString(){
        nombreIdioma
    }
}
