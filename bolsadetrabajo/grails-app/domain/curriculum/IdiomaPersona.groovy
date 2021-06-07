package curriculum
import seguridad.Persona
import curriculum.Idioma
class IdiomaPersona {
    Integer id
    Idioma id_idioma
    Persona id_persona
    String nivel
    
    static constraints = {
        nivel (inList:["Basico", "Intermedio", "Avanzado"])
    }
    static mapping ={
        id column: 'id_idioma_persona'
    }
}
