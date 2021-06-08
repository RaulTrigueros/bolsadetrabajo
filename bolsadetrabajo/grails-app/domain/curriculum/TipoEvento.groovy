package curriculum

class TipoEvento {
   
    String nombreTipoEvento
    static hasMany=[participacionEvento:ParticipacionEvento]
    static constraints = {
        nombreTipoEvento maxZize:100
    }
    static mapping ={
        id column: 'id_evento'
    }
}
