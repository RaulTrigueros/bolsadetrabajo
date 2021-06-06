package Evaluacion
import Evaluacion.Preguntas

class Respuestas {
    Integer id
    Preguntas idPregunta
    String descripcion
    
    static constraints = {
        descripcion maxZize:200
    }
    static mapping ={
        id column: 'id_respuesta'
    }
}
