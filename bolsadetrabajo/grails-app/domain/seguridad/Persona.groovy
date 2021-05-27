package seguridad
import java.util.Date
class Persona {
    //Integer idPersona
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
    
    static constraints = {
        //idPersona (nulleable:false, blank:false, unique:true, generator: 'auto-increment')
        nombres (size:1..50, blank:false)
        apellidos (size:1..50, blank:false)
        genero (inList:["Masculino", "Femenino"], blank:false)
        fechaNac (blank:false)
        tipoDocumento (inList:["DUI","Pasaporte"])
        numDocumento (size:8..9, unique:true, blank:false) 
        NIT (unique:true, blank:false)
        NUP (nulleable:true,unique:true, blank:true)
        direccion (blank:false)
        telFijo (nulleable:true,blank:true)
        celular (blank:false)
        correo (email:true)
        facebook (nulleable:true,blank:true)
        instagram (nulleable:true,blank:true)
        whatsapp (nulleable:true,blank:true)
        twitter (nulleable:false,blank:true)
        linkedin (nulleable:true,blank:true)
        telFijo (nulleable:true,blank:true)
    }
}