<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
        <title>Listar Personas</title>
    </head>
    <body>
        <a href="#list-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="create" action="create">Nueva Persona</g:link></li>
            </ul>
        </div>
        <div id="list-persona" class="content scaffold-list" role="main">
            <h1>Lista de Personas</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${personaList}" />

            <div class="pagination">
                <g:paginate total="${personaCount ?: 0}" />
            </div>
        </div>
    </body>
</html>