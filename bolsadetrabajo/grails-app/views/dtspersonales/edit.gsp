<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dtspersonales.label', default: 'Dtspersonales')}" />
        <title>Editar Dtspersonaless</title>
    </head>
    <body>
        <a href="#edit-dtspersonales" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><a class="home" href="${createLink(uri: 'index')}">Lista de Dtspersonaless</a></li>
                <li><g:link class="create" action="create">Nuevo Dtspersonales</g:link></li>
            </ul>
        </div>
        <div id="edit-dtspersonales" class="content scaffold-edit" role="main">
            <h1>Editar Dtspersonales</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.dtspersonales}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.dtspersonales}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.dtspersonales}" method="PUT">
                <g:hiddenField name="version" value="${this.dtspersonales?.version}" />
                <fieldset class="form">
                    <f:all bean="dtspersonales"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="Actualizar" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
