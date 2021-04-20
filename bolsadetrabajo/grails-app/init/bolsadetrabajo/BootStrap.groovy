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
    }
    def destroy = {
    }
}