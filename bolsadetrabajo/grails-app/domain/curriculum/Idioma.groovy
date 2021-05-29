package curriculum
import seguridad.Persona

class Idioma {
    
    Integer id
    Persona idPersona
    String nombreIdioma
    String nivelIdioma    

    static belongsTo = [persona:Persona]
    
    static constraints = {        
        nombreIdioma maxSize:20
        nivelIdioma maxSize:10
        nivelIdioma (inList:["Basico", "Intermedio", "Avanzado"])
    }
     static mapping ={
        id column: 'id_idi'
    }
}
