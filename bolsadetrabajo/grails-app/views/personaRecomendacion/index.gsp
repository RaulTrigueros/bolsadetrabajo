<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-personaRecomendacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/user/index"><g:message code="default.home.label"/></a></li>
                <li><a class="list" href="/personaRecomendacion/create/${usu}"><g:message  code="Agregar Referencia Personal" /></li>

                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="home" href="/persona/show/${per}"><g:message code="default.home.label"/></a></li>
                <li><a class="list" href="/personaRecomendacion/create/${per}"><g:message  code="Agregar Referencia Personal" /></a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="list-personaRecomendacion" class="content scaffold-list" role="main">
            <h1><g:message code="Referencias Personales" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${personaRecomendacionList}" except="id,persona" />

            <div class="pagination">
                <g:paginate total="${personaRecomendacionCount ?: 0}" />
            </div>
        </div>
    </body>
</html>