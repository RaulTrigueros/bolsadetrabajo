package curriculum
import seguridad.Persona
import curriculum.Idioma
class IdiomaPersona {
    
    String nivel
    static belongsTo=[persona:Persona, idioma:Idioma]
    static constraints = {
        nivel (inList:["Basico", "Intermedio", "Avanzado"])
    }
    static mapping ={
        id column: 'id_idioma_persona'
    }
}
