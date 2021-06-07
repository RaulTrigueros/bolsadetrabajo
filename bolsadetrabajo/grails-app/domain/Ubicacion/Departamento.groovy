package Ubicacion
import Ubicacion.*

class Departamento {
    Integer id
    Pais idPais
    String nombreDepartamento
    
    static belongsTo =[pais:Pais]
    static hasMany = [municipios:Municipio]
    
    static constraints = {
        nombreDepartamento maxZize:100
    }
    
    static mapping ={
        id column: 'id_departamento'
    }
}
