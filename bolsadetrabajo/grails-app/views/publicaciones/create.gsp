<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'publicaciones.label', default: 'Publicaciones')}" />
        <title>Crear Publicacioness</title>
    </head>
    <body>
        <a href="#create-publicaciones" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><a class="home" href="${createLink(uri: 'index')}">Lista de Publicacioness</a></li>
            </ul>
        </div>
        <div id="create-publicaciones" class="content scaffold-create" role="main">
            <h1>Crear Publicaciones</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.publicaciones}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.publicaciones}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.publicaciones}" method="POST">
                <fieldset class="form">
                    <f:all bean="publicaciones"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Crear" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
