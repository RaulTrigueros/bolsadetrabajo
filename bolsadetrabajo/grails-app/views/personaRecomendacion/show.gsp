<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-personaRecomendacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/inicio/"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>          
                </sec:ifAnyGranted>
                
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                    <li><a class="list" href="/personaRecomendacion/index/${sec.loggedInUserInfo(field: 'id')}"> <g:message code="default.list.label" args="[entityName]" /></a></li>
               </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="show-personaRecomendacion" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <sec:ifAnyGranted roles="ROLE_ADMIN">
                <f:display bean="personaRecomendacion"/>
            </sec:ifAnyGranted>
            <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <f:display bean="personaRecomendacion" except="persona"/>
            </sec:ifAnyGranted>
            <g:form resource="${this.personaRecomendacion}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.personaRecomendacion}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
