package empresa

class PerfilPuesto {
    
    Integer id
    //PuestoTrabajo id_puesto_trabajo
    String conocimientosNecesarios
    String perfilAcademico
    String habilidades
    String experienciaLaboral
    Float salarioMin
    Float salarioMax
    String ubicacionGeografica
    
    static constraints = {
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
