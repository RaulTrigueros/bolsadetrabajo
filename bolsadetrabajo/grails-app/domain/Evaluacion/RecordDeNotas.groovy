package Evaluacion
import seguridad.Persona
import Evaluacion.Evaluacion

class RecordDeNotas {
    
    Float nota
    Boolean estado
    static belongsTo=[evaluacion:Evaluacion, persona:Persona]
    static constraints = {
    }
    
    static mapping ={
        id column: 'id_record'
        version false
    }
}
