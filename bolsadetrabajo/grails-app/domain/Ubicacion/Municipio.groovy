package Ubicacion
import Ubicacion.*

class Municipio {
    String nombreMunicipio
    
    static belongsTo = [departamentos:Departamento]
    static constraints = {
        nombreMunicipio maxZize:100
    }
    
    static mapping ={
        id column: 'id_muni'
    }
}
