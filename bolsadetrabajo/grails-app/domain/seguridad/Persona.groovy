package seguridad
import curriculum.*
import empresa.*
import Ubicacion.Pais
import java.util.Date
class Persona {
    
    String nombres
    String apellidos
    String genero
    Date fechaNac
    Integer edad
    String tipoDocumento
    String numDocumento
    String NIT
    String NUP
    String direccion
    String correo

    static belongsTo = [usuarios:User, pais:Pais]

 
    static hasMany = [logros:Logro, redes:RedSocial, experienciasLaborales:Explaboral, certificaciones:Certificacion, idiomas:Idioma, 
                        recomendaciones:PersonaRecomendacion, publicacion:Publicacion, telefono:Telefono]
    
    static constraints = {
        nombres (size:1..50, blank:false)
        apellidos (size:1..50, blank:false)
        genero (inList:["Masculino", "Femenino"], blank:false)
        fechaNac (blank:false,
            validator: {
                if (it?.compareTo(new Date()) > 0)
                return false
                return true
            })
        edad (nullable:true)
        tipoDocumento (inList:["DUI","Pasaporte"])
        numDocumento (size:8..9, unique:true, blank:false) 
        NIT (maxSize: 14, unique:true, blank:false)
        NUP (nullable:true,unique:true, blank:true)
        direccion (blank:false)
        correo (email:true)
       
    }
     static mapping ={
        id column: 'id_per'
        version false
    }
    String toString(){
       "$nombres $apellidos" //aparecen concatenados los nombres y apellidos 
    }
}