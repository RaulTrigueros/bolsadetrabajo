<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'publicaciones.label', default: 'Publicaciones')}" />
        <title>Editar Publicacioness</title>
    </head>
    <body>
        <a href="#edit-publicaciones" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><a class="home" href="${createLink(uri: 'index')}">Lista de Publicacioness</a></li>
                <li><g:link class="create" action="create">Nuevo Publicaciones</g:link></li>
            </ul>
        </div>
        <div id="edit-publicaciones" class="content scaffold-edit" role="main">
            <h1>Editar Publicaciones</h1>
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
            <g:form resource="${this.publicaciones}" method="PUT">
                <g:hiddenField name="version" value="${this.publicaciones?.version}" />
                <fieldset class="form">
                    <f:all bean="publicaciones"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="Actualizar" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
