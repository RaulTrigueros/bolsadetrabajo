package Evaluacion
import empresa.PerfilPuesto
import Evaluacion.TipoEvaluacion

class Evaluacion {
    Integer id
    TipoEvaluacion idEvaluacion
    PerfilPuesto idPerfilPuesto
    String titulo
    
    static constraints = {
    titulo maxZize:200
    }
    
    static mapping ={
        id column: 'id_evaluacion'
    }
}
