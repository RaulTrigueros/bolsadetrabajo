package bolsadetrabajo

import seguridad.User
import seguridad.RoleGroup
import seguridad.UserRoleGroup

class RegistroController {
    
    def index() {
    	/*
    		HS15018
    	*/
    	def userList = User.list()
    	[userList:userList]
    }

    def create(){
    	/*
    		HS15018
    	*/
    	[user:new User(params), roleGroupsList:RoleGroup.executeQuery("from RoleGroup where ENABLED = 1")]
    }

    def save(){
    	/*
    		HS15018
    	*/
    	if (params.enabled==null) {
    		params.enabled=1
    	}
    	if (params.accountExpired==null) {
    		params.accountExpired=0
    	}
    	if (params.accountLocked==null) {
    		params.accountLocked=0
    	}
    	if (params.passwordExpired==null) {
    		params.passwordExpired=0
    	}
    	def user = new User(username:params.username, password:params.password, enabled:params.enabled, accountExpired:params.accountExpired,
    		accountLocked:params.accountLocked, passwordExpired:params.passwordExpired)
        def listaGrupos=params.groupRole
    	if (user.save(flush:true)){
            for(i in listaGrupos) {
                new UserRoleGroup(user: user, roleGroup: i).save(flush: true)
            }
    		flash.message="1"
    		redirect(action:'index')
    	}else{
            for(i in user.errors) {
                println i.fieldError.field + " " + i.fieldError.code
                flash.message = i.fieldError.field + " " + i.fieldError.code
            }
            user=new User(params)
            render(view:'create', model:[user:user,roleGroupsList:RoleGroup.executeQuery("from RoleGroup where ENABLED = 1")])
    	}
    }

    def show(){
    	/*
    		HS15018
    	*/
    	def user= User.get(params.id)
    	def grupos= UserRoleGroup.executeQuery("from UserRoleGroup where user_id=" + params.id)
    	//println(grupos)
    	[user:user,grupos:grupos]
    }

    def edit(){
        /*
            HS15018
        */

        //obteniendo el usaurio a editar
        def user= User.get(params.id)
        //obteniendo los grupos que tiene asignado el usuario a editar
        def roleGroupAsignados=user.getAuthorities()
        //formateando la variable roleGroupAsignados quitandole corchetes por parentesis y que este lista para concatenar a la query
        def roleGroupAsignadosFormat=roleGroupAsignados.id.toString().replace("[", "(").replace("]", ")")
        //obtenirndo  todos los grupos menos aquellos que esten ya asignados
        def roleGroup=RoleGroup.executeQuery("from RoleGroup where id not in " + roleGroupAsignadosFormat + "and ENABLED = 1")

        [user:user,roleGroup:roleGroup,roleGroupAsignados:roleGroupAsignados]
    }

    def update(){
        /*
            HS15018
        */

        //obteniendo usuario a editar
        def user= User.get(params.id)
        user.properties=params
        //obteniendo grupos seleccionados o los que ya estaban seleccionados
        def listaGrupos=params.groupRole
        if (user.save(flush:true)){
            //removiendo los grupos que tiene asignado el usuario
            UserRoleGroup.removeAll(user)
            //UserRoleGroup.executeUpdate("delete UserRoleGroup where user_id=" + user.id)
            for(i in listaGrupos) {
                //modificando, agregando los grupos seleccionados al usuario
                //println("el id del grupo es" + i)
                new UserRoleGroup(user: user, roleGroup: i).save(flush: true)
            }
            flash.message="2"
            redirect(action:'index')
        }else{
            for(i in user.errors) {
                println i.fieldError.field + " " + i.fieldError.code
                flash.message = i.fieldError.field + " " + i.fieldError.code
            }
            redirect(action:'edit', id: user.id)
        }
    }

    def delete(){
        /*
            HS15018
        */
        //eliminado logico de la base de datos, en este caso se cambiara el estado enabled a false y accountLocked en true
        if(request.method == "POST"){
            println("estoy en el post")
            def user= User.get(params.id)
            user.enabled=false
            user.accountLocked=true
            if(user.save(flush:true)){
                flash.message="3"
                redirect(action:'index')
            }else{
                println("estoy en el else del save")
                redirect(action:'index')
            }
        }else{
            def user= User.get(params.id)
            println('estoy en el else del post (get)' + user)
            [user:user]
        }
    }

    def restore(){
        /*
            HS15018
        */
        //restaurando el eliminado logico de la base de datos, en este caso se cambiara el estado enabled a true y accountLocked en false
        if(request.method == "POST"){
            println("estoy en el post")
            def user= User.get(params.id)
            user.enabled=true
            user.accountLocked=false
            if(user.save(flush:true)){
                flash.message="4"
                redirect(action:'index')
            }else{
                println("estoy en el else del save")
                redirect(action:'index')
            }
        }else{
            def user= User.get(params.id)
            println('estoy en el else del post (get)' + user)
            [user:user]
        }
    } 
}