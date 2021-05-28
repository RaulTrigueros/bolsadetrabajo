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
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><g:link class="create" action="create">Nuevo logro</g:link></li>
                <li><a class="home" href="${createLink(uri: 'roles')}">Ir a Roles</a></li>
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