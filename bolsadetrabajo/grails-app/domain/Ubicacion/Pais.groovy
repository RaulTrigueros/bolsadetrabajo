package Ubicacion

class Pais {
    Integer id
    String nombrePais
    String continente
    
    static hasMany = [departamentos:Departamento]
    static constraints = {
        nombrePais maxZize:100
        continente (inList:["Africa","America", "Asia", "Europa", "Oceania"])
    }
    static mapping ={
        id column: 'id_pais'
    }
}
