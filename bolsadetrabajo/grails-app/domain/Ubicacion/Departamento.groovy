package Ubicacion
import Ubicacion.Pais

class Departamento {
    Integer id
    Pais idPais
    String nombreDepartamento
    
    static constraints = {
        nombreDepartamento maxZize:100
    }
    
    static mapping ={
        id column: 'id_departamento'
    }
}
