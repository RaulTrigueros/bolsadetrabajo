package curriculum
import seguridad.Persona

class Certificacion {
    
    String nombreCertificacion;
    String codigoCertificacion;
    Date fechaInicio;
    Date fechaFin;
    String tipoCertificacion;
    String institucionDeCertificacion
    
    static belongsTo = [persona:Persona]
    
    static constraints = {
       
     nombreCertificacion (size:1..50, blank:false)
     codigoCertificacion (size:1..50, blank:false)
     fechaInicio (blank:false,validator: {
            if (it?.compareTo(new Date()) > 0)
                return false
            return true
        })
     fechaFin (blank:false,validator: {
            if (it?.compareTo(new Date()) > $fechaInicio)
                return false
            return true
        })
     tipoCertificacion (size:1..50, blank:false)
     institucionDeCertificacion (size:1..50, blank:false)
        
    }
    static mapping ={
        id column: 'id_cer'
    }
    String toString(){
        nombreCertificacion
    }
}
