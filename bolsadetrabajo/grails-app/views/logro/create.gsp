<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'logro.label', default: 'Logro')}" />
        <title>Crear Logros</title>
    </head>
    <body>
        <a href="#create-logro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/inicio/"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="list" href="/logro/index/${sec.loggedInUserInfo(field: 'id')}">Logros</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="create-logro" class="content scaffold-create" role="main">
            <h1>Crear logro</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.logro}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.logro}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.logro}" method="POST">
                <fieldset class="form">
                    <f:with bean="logro">
                    <f:field property="tipoLogro"/>
                    <f:field property="nombreLogro"/>
                    <f:field property="fechaLogro"/>
                    <input type="hidden" name="persona.id" value="${pos}" required id= "${pos}">
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Crear" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>