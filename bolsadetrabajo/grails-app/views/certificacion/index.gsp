<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'certificacion.label', default: 'Certificacion')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-certificacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="user/index"> Pagina principal</a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="home" href="/persona/show/${per}"><g:message code="default.home.label"/></a></li>
                <li><a class="list" href="/Certificacion/create/${per}"><g:message code="default.new.label" args="[entityName]" /></a></li>
                </sec:ifAnyGranted>
                
            </ul>
        </div>
        
        <div id="list-certificacion" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${certificacionList}" />

            <div class="pagination">
                <g:paginate total="${certificacionCount ?: 0}" />
            </div>
        </div>
    </body>
</html>