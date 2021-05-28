<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'publicaciones.label', default: 'Publicaciones')}" />
        <title>Listar Publicacioness</title>
    </head>
    <body>
        
        <a href="#list-publicaciones" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><g:link class="create" action="create">Nuevo Publicaciones</g:link></li>
                <li><a class="home" href="${createLink(uri: 'roles')}">Ir a Roles</a></li>
            </ul>
        </div>
        <div id="list-publicaciones" class="content scaffold-list" role="main">
            <h1>Lista de Publicacioness</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${publicacionesList}" />

            <div class="pagination">
                <g:paginate total="${publicacionesCount ?: 0}" />
            </div>
        </div>
    </body>
</html>