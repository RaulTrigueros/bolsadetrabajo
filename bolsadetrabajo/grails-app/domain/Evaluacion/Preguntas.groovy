package Evaluacion
import Evaluacion.Evaluacion

class Preguntas {
   
    String enunciado
    String respSeleccionada
    String respCorrecta
    Float ponderacion
    
    static belongsTo =[evaluacion:Evaluacion]
    static hasMany =[respuestas:Respuestas]
    static constraints = {
        enunciado maxZize:200
        respSeleccionada maxZize:200
        respCorrecta maxZize:200
    }
    
    static mapping ={
        id column: 'id_preg'
        version false
    }
    
}
