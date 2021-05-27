package dtspersonales
import java.util.Date
class Dtspersonales {
    String primerNombre
    String segundoNombre
    String primerApellido
    String segundoApellido
    String genero
    Date fechaNac
    String DUI
    String pasaporte
    String NIT
    String NUP
    String direccion
    String telFijo 
    String celular
    String correo
    String facebook
    String instagram
    String whastapp
    String twitter
    String linkedin
    
    static constraints = {
        primerNombre (size:1..50, blank:false)
        segundoNombre (size:1..50, blank:false)
        primerApellido (size:1..50, blank:false)
        segundoApellido (size:1..50, blank:false)
        genero (inList:["Masculino", "Femenino"], blank:false)
        fechaNac (blank:false)
        DUI (size:8..9, unique:true, blank:false) 
        NIT (unique:true, blank:false)
        NUP (unique:true, blank:true)
        direccion (blank:false)
        telFijo (blank:true)
        celular (blank:false)
        correo (email:true)
    }
}
