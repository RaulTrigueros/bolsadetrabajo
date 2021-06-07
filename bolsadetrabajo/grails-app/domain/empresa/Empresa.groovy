package empresa
import seguridad.User

class Empresa {
    Integer id
    User id_user
    String nombreEmpresa
    String correoEmpresa
    String sitioWeb
    String descripcionEmpresa
    
    static constraints = {
        nombreEmpresa maxZize:200
        correoEmpresa email:true
        sitioWeb maxZize:200
        descripcionEmpresa maxZize:200
    }
    
    static mapping ={
        id column: 'id_empresa'
    }
}
