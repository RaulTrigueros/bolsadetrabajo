package curriculum
import seguridad.Persona

class Logro {
    
    Integer id
    String tipo_logro
    String nombre_logro
    Date fecha_logro

    static belongsTo = [Persona]
    
    static constraints = {
     tipo_logro (inList:["Condecoración","Concurso", "Meta"]) 
     nombre_logro (size:1..50, blank:false)
     fecha_logro (blank:false)
    }
    
     static mapping ={
        id column: 'id_logro'
    }
}
