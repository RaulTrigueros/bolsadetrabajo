package Evaluacion
import Evaluacion.Evaluacion

class Preguntas {
    Integer id
    Evaluacion idEvaluacion
    String enunciado
    String respSeleccionada
    String respCorrecta
    Float ponderacion
    
    static constraints = {
        enunciado maxZize:200
        respSeleccionada maxZize:200
        respCorrecta maxZize:200
    }
    
    static mapping ={
        id column: 'id_pregunta'
    }
}
