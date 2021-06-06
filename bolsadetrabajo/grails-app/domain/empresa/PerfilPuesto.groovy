package empresa
import seguridad.Persona
import empresa.Empresa

class PerfilPuesto {
    
    Integer id
    Persona idPersona
    Empresa idEmpresa
    String nombrePuestoTrabajo
    String descripcionPuesto
    String conocimientosNecesarios
    String perfilAcademico
    String habilidades
    String experienciaLaboral
    Float salarioMin
    Float salarioMax
    String ubicacionGeografica
    
    static constraints = {
        nombrePuestoTrabajo (blank:false, masSize:200)
        descripcionPuesto (blank:false, masSize:200)
        conocimientosNecesarios (blank:false, masSize:200)
        perfilAcademico (blank:false, masSize:200)
        habilidades (blank:false, masSize:200)
        experienciaLaboral (blank:false, masSize:200)
        salarioMin (blank:false)
        salarioMax (blank:false)
        ubicacionGeografica (blank:false, masSize:200)
    }
    static mapping ={
        id column: 'id_perfil_puesto'
    }
}
