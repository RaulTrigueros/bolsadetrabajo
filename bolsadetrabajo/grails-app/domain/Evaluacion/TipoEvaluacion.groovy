package Evaluacion

class TipoEvaluacion {
   
    String nombre
    static hasMany =[evaluaciones:Evaluacion]
    static constraints = {
    nombre (inList:["Conocimiento", "Tecnica", "Actitudes"])
    }
    
    static mapping ={
        id column: 'id_tipo_eval'
    }
}
