package Evaluacion
import Evaluacion.Preguntas

class Respuestas {
    
    String descripcion
    static belongsTo=[pregunta:Preguntas]
    static constraints = {
        descripcion maxZize:200
    }
    static mapping ={
        id column: 'id_resp'
    }
}
