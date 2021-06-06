package Evaluacion

class TipoEvaluacion {
    Integer id
    String nombre
    
    static constraints = {
    nombre (inList:["Conocimiento", "Tecnica", "Actitudes"])
    }
    
    static mapping ={
        id column: 'id_tipo_evaluacion'
    }
}
