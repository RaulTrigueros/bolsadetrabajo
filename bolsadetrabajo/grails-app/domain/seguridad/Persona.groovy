package seguridad
import curriculum.*
import empresa.*
import publicaciones.*
import java.util.Date
class Persona {
    
    Integer id
    String nombres
    String apellidos
    String genero
    Date fechaNac
    String tipoDocumento
    String numDocumento
    String NIT
    String NUP
    String direccion
    String telFijo 
    String celular
    String correo
    String facebook
    String instagram
    String whatsapp
    String twitter
    String linkedin
    
    static hasMany = [logros:Logro, experienciasLaborales:Explaboral, certificaciones:Certificacion, idiomas:Idioma, 
                        recomendaciones:PersonaRecomendacion, publicaciones:Publicaciones]

    
    static constraints = {
        nombres (size:1..50, blank:false)
        apellidos (size:1..50, blank:false)
        genero (inList:["Masculino", "Femenino"], blank:false)
        fechaNac (blank:false)
        tipoDocumento (inList:["DUI","Pasaporte"])
        numDocumento (size:8..9, unique:true, blank:false) 
        NIT (unique:true, blank:false)
        NUP (nullable:true,unique:true, blank:true)
        direccion (blank:false)
        telFijo (nullable:true,blank:true)
        celular (blank:false)
        correo (email:true)
        facebook (nullable:true,blank:true)
        instagram (nullable:true,blank:true)
        whatsapp (nullable:true,blank:true)
        twitter (nullable:true,blank:true)
        linkedin (nullable:true,blank:true) 
       
    }
     static mapping ={
        id column: 'id_persona'
    }
}