<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dtspersonales.label', default: 'Dtspersonales')}" />
        <title>Listar Dtspersonaless</title>
    </head>
    <body>
        <a href="#list-dtspersonales" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><g:link class="create" action="create">Nuevo Dtspersonales</g:link></li>
                <li><a class="home" href="${createLink(uri: 'roles')}">Ir a Roles</a></li>
            </ul>
        </div>
        <div id="list-dtspersonales" class="content scaffold-list" role="main">
            <h1>Lista de Dtspersonaless</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${dtspersonalesList}" />

            <div class="pagination">
                <g:paginate total="${dtspersonalesCount ?: 0}" />
            </div>
        </div>
    </body>
</html>