
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'seguridad.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'seguridad.UserRole'
grails.plugin.springsecurity.authority.className = 'seguridad.Role'
grails.plugin.springsecurity.authority.groupAuthorityNameField = 'authorities'
grails.plugin.springsecurity.useRoleGroups = true
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
    [pattern: '/',                          access: ['permitAll']],
    [pattern: '/dbconsole/**',              access: ['permitAll']],
    [pattern: '/console/**',                access: ['permitAll']],
    [pattern: '/index/',                    access: ['permitAll']],
    [pattern: '/index.gsp',                 access: ['permitAll']],
    [pattern: '/**/js/**',                  access: ['permitAll']],
    [pattern: '/**/css/**',                 access: ['permitAll']],
    [pattern: '/**/images/**',              access: ['permitAll']],
    [pattern: '/**/favicon.ico',            access: ['permitAll']],
    [pattern: '/error',                     access: ['permitAll']],
    [pattern: '/assets/**',                 access: ['permitAll']],
    [pattern: '/register/**',               access: ['permitAll']],
    [pattern: '/shutdown',                  access: ['permitAll']],
    [pattern: '/login/**',                  access: ['permitAll']],
    [pattern: '/logout/**',                 access: ['permitAll']],
    
    [pattern: '/user/index',                access: ['ROLE_POSTULANTE']],
    [pattern: '/user/**',                   access: ['ROLE_ADMIN']],
    [pattern: '/userRole/**',               access: ['ROLE_ADMIN']],
    [pattern: '/roles/',                    access: ['ROLE_ADMIN']],
    [pattern: '/crearRol/**',               access: ['ROLE_ADMIN']],
    
    
    //[pattern: '/emailSender/**',            access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/emailSender/**',    access: ['permitAll']],
    [pattern: '/persona/**',                access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/certificacion/**',          access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/explaboral/**',             access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/formacion/**',              access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/habilidadTecnica/**',       access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/idioma/**',                 access: ['ROLE_ADMIN',]],
    [pattern: '/idiomaPersona/**',          access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/logro/**',                  access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/participacionEvento/**',    access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/personaRecomendacion/**',   access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/publicacion/**',            access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/redSocial/**',              access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/tipoEvento/**', 	    access: ['ROLE_ADMIN', 'ROLE_POSTULANTE']],
    [pattern: '/empresa/**',                access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/perfilPuesto/**', 	    access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/evaluacion/**', 	    access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/preguntas/**',              access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/recordDeNotas/**', 	    access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/respuestas/**', 	    access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/tipoEvaluacion/**', 	    access: ['ROLE_ADMIN', 'ROLE_EMPRESA']],
    [pattern: '/departamento/**', 	    access: ['ROLE_ADMIN']],
    [pattern: '/municipio/**',              access: ['ROLE_ADMIN']],
    [pattern: '/pais/**',                   access: ['ROLE_ADMIN']],
    
    
    [pattern: '/password/**',               access: ['permitAll']],
      
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.afterLogoutUrl = '/login/auth'
grails.plugins.springsecurity.successHandler.alwaysUseDefault = true
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/user/index'
//grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/persona/index' /*carlos*/
//grails.plugin.springsecurity.securityConfigType = "Annotation"

grails.plugins.springsecurity.userLookup.usernamePropertyName = 'e-mail'