<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
        <title>INGRESO DE DATOS PERSONALES</title>
    </head>
    <body>
        <a href="#create-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="${createLink(uri: '/user/index')}">Principal</a></li>
                <li><a class="home" href="${createLink(uri: '/persona/listar')}">Lista de Personas</a></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="home" href="/persona/index/<sec:loggedInUserInfo field='id'/>">Principal</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="create-persona" class="content scaffold-create" role="main">
            <h1>INGRESA TUS DATOS PERSONALES</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.persona}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.persona}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.persona}" method="POST">
                <fieldset class="form">
                    <f:all bean="persona">
                        </f:all>
                    
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save"  value="Guardar datos personales" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>