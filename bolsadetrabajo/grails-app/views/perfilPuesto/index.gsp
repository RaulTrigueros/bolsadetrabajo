<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'perfilPuesto.label', default: 'PerfilPuesto')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-perfilPuesto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/inicio/">Principal</a></li>
                <li><g:link class="list" action="listar">Lista Perfil de Puestos</g:link></li>
                <li><g:link class="create" action="create">Perfil de Puesto</g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_EMPRESA">
                <li><a class="home" href="/empresa/index/<sec:loggedInUserInfo field='id'/>">Principal</a></li>
                <li><a class="create" href="/perfilPuesto/create/${sec.loggedInUserInfo(field: 'id')}">Crear nuevo Perfil de puesto</a></li>

                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="list-perfilPuesto" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${perfilPuestoList}" />

            <div class="pagination">
                <g:paginate total="${perfilPuestoCount ?: 0}" />
            </div>
        </div>
    </body>
</html>