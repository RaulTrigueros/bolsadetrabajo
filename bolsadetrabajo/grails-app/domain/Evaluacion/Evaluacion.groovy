package Evaluacion
import empresa.PerfilPuesto
import Evaluacion.TipoEvaluacion

class Evaluacion {
    
    String titulo
    
    static belongsTo = [tipoEvaluaciones:TipoEvaluacion, perfilPuesto:PerfilPuesto]
    static hasMany = [recordDeNotas:RecordDeNotas, preguntas:Preguntas]
    static constraints = {
    titulo maxZize:200
    }
    
    static mapping ={
        id column: 'id_eval'
    }
}
