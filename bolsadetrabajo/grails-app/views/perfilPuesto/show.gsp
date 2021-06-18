<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'perfilPuesto.label', default: 'PerfilPuesto')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        ${emp}
        <a href="#show-perfilPuesto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_EMPRESA">
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_EMPRESA">
                <li><a class="list" href="/perfilPuesto/index/${sec.loggedInUserInfo(field: 'id')}">Listado de puestos</a></li>
                <li><a class="create" href="/perfilPuesto/create/${sec.loggedInUserInfo(field: 'id')}">Crear nuevo Perfil de puesto</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        </sec:ifAnyGranted>
        <div id="show-perfilPuesto" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="perfilPuesto" except="id,empresa" />
            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_EMPRESA">
                <g:form resource="${this.perfilPuesto}" method="DELETE">
                    <fieldset class="buttons">
                        <g:link class="edit" action="edit" resource="${this.perfilPuesto}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                        <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
            </sec:ifAnyGranted>
        </div>
    </body>
</html>
