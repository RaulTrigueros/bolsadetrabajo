package curriculum

class TipoEvento {
    Integer id
    String nombreTipoEvento
    
    static constraints = {
        nombreTipoEvento maxZize:100
    }
    static mapping ={
        id column: 'id_evento'
    }
}
