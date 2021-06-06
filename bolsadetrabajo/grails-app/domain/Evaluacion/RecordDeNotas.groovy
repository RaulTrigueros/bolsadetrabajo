package Evaluacion
import seguridad.Persona
import Evaluacion.Evaluacion

class RecordDeNotas {
    Integer id
    Persona idPersona
    Evaluacion idEvaluacion
    Float nota
    Boolean estado
    
    static constraints = {
    }
    
    static mapping ={
        id column: 'id_record'
    }
}
