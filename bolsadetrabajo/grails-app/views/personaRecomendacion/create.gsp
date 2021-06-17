<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'personaRecomendacion.label', default: 'PersonaRecomendacion')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-personaRecomendacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/inicio/"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="list" href="/personaRecomendacion/index/${sec.loggedInUserInfo(field: 'id')}">Referencias personales</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="create-personaRecomendacion" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.personaRecomendacion}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.personaRecomendacion}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.personaRecomendacion}" method="POST">
                <fieldset class="form">
                    <f:with bean="personaRecomendacion">
                    <f:field property="nombreRecomendacion"/>
                    <f:field property="telefonoRecomendador"/>
                    <f:field property="correoRecomendador"/>
                    <f:field property="institucionRecomendacion"/>
                    <input type="hidden" name="persona.id" value="${pos}" required id= "${pos}">
                    </f:with>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Agregar recomencación" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
