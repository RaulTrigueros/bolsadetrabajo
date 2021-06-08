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
     fechaInicio (blank:false)
     fechaFin (blank:false)
     tipoCertificacion (size:1..50, blank:false)
     institucionDeCertificacion (size:1..50, blank:false)
        
    }
    static mapping ={
        id column: 'id_cer'
    }
}
