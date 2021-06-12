<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
        <title>Mostrar Personas</title>
    </head>
    <body>
        ${pp}
        <a href="#show-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/">Principal</a></li>
                <li><g:link class="list" action="listar">Lista de Personas</g:link></li>
                <li><g:link class="create" action="create">Nuevo Persona</g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="home" href="/persona/index/<sec:loggedInUserInfo field='id'/>">Principal</a></li>
                <li><a class="list" href="/personaRecomendacion/index/<sec:loggedInUserInfo field='id'/>">Mis Recomendaciones</a></li>
                <li><a class="list" href="/redSocial/index/<sec:loggedInUserInfo field='id'/>">Redes</a></li>
                <li><a class="list" href="/telefono/index/<sec:loggedInUserInfo field='id'/>">Telefono</a></li>
                <li><a class="list" href="/formacion/index/<sec:loggedInUserInfo field='id'/>">Formación</a></li>
                <li><a class="list" href="/certificacion/index/<sec:loggedInUserInfo field='id'/>">Certificaciones</a></li>
                <li><a class="list" href="/explaboral/index/<sec:loggedInUserInfo field='id'/>">Experiencia laboral</a></li>
                <li><a class="list" href="/publicacion/index/<sec:loggedInUserInfo field='id'/>">Mis Publicaciones</a></li>
                <li><a class="list" href="/logro/index/<sec:loggedInUserInfo field='id'/>">Logros</a></li>
                <li><a class="list" href="/idiomaPersona/index/<sec:loggedInUserInfo field='id'/>">Idiomas</a></li>
                
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="show-persona" class="content scaffold-show" role="main">
            <h1>Información personal</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="persona" except="recomendaciones,redes,certificaciones,experienciasLaborales,publicacion,logros,idiomas,usuarios,telefono"/>
            <g:form resource="${this.persona}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.persona}">Editar</g:link>
                    <input class="delete" type="submit" value="Eliminar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>