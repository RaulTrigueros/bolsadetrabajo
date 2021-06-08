package curriculum
import seguridad.Persona
class RedSocial {
    String linkedin
    String facebook
    String twitter
    static belongsTo =[persona:Persona]
    static constraints = {
        linkedin (nullable:true, blank:true, maxSize:50)
        facebook (nullable:true, blank:true, maxSize:50)
        twitter (nullable:true, blank:true, maxSize:50)
    }
    
    static mapping ={
        id column:'id_red'
    }
    String toString(){
        "Linkedin:$linkedin, Facebook:$facebook, Twitter:$twitter"
    }
    
}
