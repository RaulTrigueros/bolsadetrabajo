package Ubicacion
import Ubicacion.*

class Municipio {
    String nombreMunicipio
    
    static belongsTo = [departaento:Departamento]
    static constraints = {
        nombreMunicipio maxZize:100
    }
    
    static mapping ={
        id column: 'id_muni'
    }
    String toString(){
        nombreMunicipio
    }
}
