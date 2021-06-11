package bolsadetrabajo


import seguridad.User
import groovy.transform.CompileStatic
import javax.management.relation.Role
import org.springframework.context.annotation.Role
import seguridad.RoleGroup
import seguridad.RoleGroupRole
import seguridad.User
import seguridad.UserRoleGroup
import seguridad.Role


@CompileStatic
class BootStrap {

    def init = { servletContext ->
    	final boolean flush = true
        final boolean failOnError = true
    	def admin = new User(username: 'admin', password: 'admin123').save(flush:true)
    	def administrador =  new RoleGroup(name: 'administrador').save(flush:true)
    	def administradorRole = new Role(authority: 'ROLE_ADMIN').save(flush:true)
    	new RoleGroupRole(roleGroup: administrador, role: administradorRole).save(flush: flush)
    	new UserRoleGroup(user: admin, roleGroup: administrador).save(flush: flush)
        
        def empresa = new User(username: 'empresa', password: 'empresa123').save(flush:true)
    	def administradorEmpresa =  new RoleGroup(name: 'empresa').save(flush:true)
    	def administradorEmpresaRole = new Role(authority: 'ROLE_EMPRESA').save(flush:true)
    	new RoleGroupRole(roleGroup: administradorEmpresa, role: administradorEmpresaRole).save(flush: flush)
    	new UserRoleGroup(user: empresa, roleGroup: administradorEmpresa).save(flush: flush)
        
        def postulante = new User(username: 'postulante', password: 'postulante123').save(flush:true)
    	def administradorPostulante =  new RoleGroup(name: 'postulante').save(flush:true)
    	def administradorPostulanteRole = new Role(authority: 'ROLE_POSTULANTE').save(flush:true)
    	new RoleGroupRole(roleGroup: administradorPostulante, role: administradorPostulanteRole).save(flush: flush)
    	new UserRoleGroup(user: postulante, roleGroup: administradorPostulante).save(flush: flush)
        
      /*  def permitAll = new User(username: 'permitAll', password: 'permitAll123').save(flush:true)
    	def administradorPermitAll =  new RoleGroup(name: 'permitAll').save(flush:true)
    	def administradorPermitAllRole = new Role(authority: 'permitAll').save(flush:true)
    	new RoleGroupRole(roleGroup: administradorPermitAll, role: administradorPermitAllRole).save(flush: flush)
    	new UserRoleGroup(user: permitAll, roleGroup: administradorPermitAll).save(flush: flush)*/
    }
    def destroy = {
    }
}