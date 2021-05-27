package curriculum

class Idioma {
    
    //Integer id_idioma
    //Integer id_persona
    String nombreIdioma
    String nivelIdioma    

    static constraints = {        
        nombreIdioma maxSize:20
        nivelIdioma maxSize:10
        
    }
}
