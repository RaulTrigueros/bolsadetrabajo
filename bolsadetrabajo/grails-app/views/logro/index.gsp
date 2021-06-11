<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'logro.label', default: 'Logro')}" />
        <title>Listar Logros</title>
    </head>
    <body>
        <a href="#list-logro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/user/index">Principal</a></li>
                <li><g:link class="create" action="create">Nuevo logro</g:link></li>
                <li><a class="home" href="${createLink(uri: 'roles')}">Ir a Roles</a></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="home" href="/persona/show/${per}"><g:message code="default.home.label"/></a></li>
                <li><a class="list" href="/logro/create/${per}"><g:message code="default.new.label" args="[entityName]" /></a></li>
                
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="list-logro" class="content scaffold-list" role="main">
            <h1>Lista de Logros</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${logroList}" />

            <div class="pagination">
                <g:paginate total="${logroCount ?: 0}" />
            </div>
        </div>
    </body>
</html>