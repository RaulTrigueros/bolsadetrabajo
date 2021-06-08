package Ubicacion

class Pais {
    String nombrePais
    String continente
    
    static hasMany = [departamento:Departamento]
    static constraints = {
        nombrePais maxZize:100
        continente (inList:["Africa","America", "Asia", "Europa", "Oceania"])
    }
    static mapping ={
        id column: 'id_pais'
        version false
    }
    String toString (){
        nombrePais
    }
}
