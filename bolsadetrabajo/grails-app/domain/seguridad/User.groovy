package seguridad

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import seguridad.Persona
import seguridad.Role
import empresa.Empresa

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String  username
    String  password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
 
    
    
   // static belongsTo = [roleGroupRoles:RoleGroupRole]
  
    Set<RoleGroup> getAuthorities() {
        (UserRoleGroup.findAllByUser(this) as List<UserRoleGroup>)*.roleGroup as Set<RoleGroup>
    }
    
    
    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
                   
    }
    static mapping = {
	    password column: '`password`'
            table 'usuario'
            version false
    }
    String toString(){
        username
    }
}
