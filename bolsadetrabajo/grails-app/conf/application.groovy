
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'seguridad.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'seguridad.UserRole'
grails.plugin.springsecurity.authority.className = 'seguridad.Role'
grails.plugin.springsecurity.authority.groupAuthorityNameField = 'authorities'
grails.plugin.springsecurity.useRoleGroups = true
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
    [pattern: '/',                     access: ['permitAll']],
    [pattern: '/error',                access: ['permitAll']],
    [pattern: '/index/',                access: ['permitAll']],
    [pattern: '/index.gsp',            access: ['ROLE_ADMIN']],
    [pattern: '/shutdown',             access: ['permitAll']],
    [pattern: '/assets/**',            access: ['permitAll']],
    [pattern: '/**/js/**',             access: ['permitAll']],
    [pattern: '/**/css/**',            access: ['permitAll']],
    [pattern: '/**/images/**',         access: ['permitAll']],
    [pattern: '/**/favicon.ico',       access: ['permitAll']],
    [pattern: '/login/**',             access: ['permitAll']],
    [pattern: '/logout/**',            access: ['permitAll']],
    [pattern: '/dbconsole/**',         access: ['permitAll']],
    [pattern: '/console/**', 	       access: ['permitAll']],
    [pattern: '/user/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/userRole/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/roles/', 	       access: ['ROLE_ADMIN']],
    [pattern: '/crearRol/**', 	       access: ['ROLE_ADMIN']],
    [pattern: '/register/**',          access: ['permitAll']],
    [pattern: '/password/**',          access: ['permitAll']],
    [pattern: '/persona/**',           access: ['permitAll']],
    [pattern: '/publicaciones/**',     access: ['permitAll']],
    [pattern: '/logro/**',             access: ['ROLE_ADMIN']],
    [pattern: '/idioma/**', 	       access: ['permitAll']],
    [pattern: '/explaboral/**',        access: ['permitAll']],
    [pattern: '/perfilPuesto/**',      access: ['permitAll']],
    [pattern: '/certificacion/**',     access: ['permitAll']],
    [pattern: '/idioma/**', 	       access: ['permitAll']],
    [pattern: '/personaRecomendacion/**', access: ['permitAll']],   
    [pattern: '/redSocial/**', 	       access: ['permitAll']],
    [pattern: '/empresa/**', 	       access: ['ROLE_ADMIN']]



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

