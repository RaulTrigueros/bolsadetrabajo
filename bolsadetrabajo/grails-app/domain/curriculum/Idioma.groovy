package curriculum

class Idioma {
    
    Integer id
    String nombreIdioma
    String nivelIdioma    

    static constraints = {        
        nombreIdioma maxSize:20
        nivelIdioma maxSize:10
    }
     static mapping ={
        id column: 'id_idioma'
    }
}
