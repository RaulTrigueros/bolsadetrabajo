package empresa
import seguridad.User

class Empresa { 
    
    String nombreEmpresa
    String correoEmpresa
    String sitioWeb
    String descripcionEmpresa
    
    //static belongsTo = [usuarios:User]
    static hasMany=[perfilPuesto:PerfilPuesto]
    static constraints = {
        nombreEmpresa maxZize:200
        correoEmpresa email:true
        sitioWeb maxZize:200
        descripcionEmpresa maxZize:200
    }
    static mapping ={
        id column: 'id_emp'
        version false
    }
    String toString(){
        nombreEmpresa
    }
}
