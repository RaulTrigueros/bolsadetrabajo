package seguridad
import curriculum.*
import empresa.*
import publicaciones.*
import java.util.Date
class Persona {
    
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
    
    
    static hasMany = [logros:Logro, redes:RedSocial, experienciasLaborales:Explaboral, certificaciones:Certificacion, idiomas:Idioma, 
                        recomendaciones:PersonaRecomendacion, publicaciones:Publicaciones]

    
    static constraints = {
        nombres (size:1..50, blank:false)
        apellidos (size:1..50, blank:false)
        genero (inList:["Masculino", "Femenino"], blank:false)
        fechaNac (blank:false)
        tipoDocumento (inList:["DUI","Pasaporte"])
        numDocumento (size:8..9, unique:true, blank:false) 
        NIT (maxSize: 14, unique:true, blank:false)
        NUP (nullable:true,unique:true, blank:true)
        direccion (blank:false)
        telFijo (maxSize:9, nullable:true,blank:true)
        celular (maxSize:8, blank:false)
        correo (email:true)
       
       
    }
     static mapping ={
        id column: 'id_per'
    }
}