package Ubicacion
import Ubicacion.Departamento

class Municipio {
    Integer id
    Departamento idDepartamento
    String nombreMunicipio
    
    static constraints = {
        nombreMunicipio maxZize:100
    }
    
    static mapping ={
        id column: 'id_municipio'
    }
}
