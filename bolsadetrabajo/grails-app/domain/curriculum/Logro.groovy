package curriculum
import seguridad.Persona

class Logro {
    
    String tipoLogro
    String nombreLogro
    Date fechaLogro

    static belongsTo = [persona:Persona]
    
    static constraints = {
     tipoLogro (inList:["Condecoración","Concurso", "Meta"]) 
     nombreLogro (size:1..50, blank:false)
     fechaLogro (blank:false,
            validator: {
                if (it?.compareTo(new Date()) > 0)
                    return false
                return true
            })
        
    }
    
     static mapping ={
        id column: 'id_logro'
    }
    String toString(){
        nombreLogro
    }
}
