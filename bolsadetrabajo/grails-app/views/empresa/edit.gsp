<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empresa.label', default: 'Empresa')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-empresa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="list" href="${createLink(uri: '/empresa/listar')}">Lista de Empresas</a></li>
                <li><g:link class="create" action="create">Nueva Empresa</g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_EMPRESA">
                <li><a class="home" href="/empresa/show/${emp}">Principal</a></li>
                </sec:ifAnyGranted></ul>
        </div>
        <div id="edit-empresa" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.empresa}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.empresa}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.empresa}" method="PUT">
                <g:hiddenField name="version" value="${this.empresa?.version}" />
                <fieldset class="form">
                    <f:with bean="empresa">
                    <f:field property="nombreEmpresa"/>
                    <f:field property="correoEmpresa"/>
                    <f:field property="sitioWeb"/>
                    <f:field property="descripcionEmpresa"/>
                    <input type="hidden" name="usuarios.id" value="${sec.loggedInUserInfo(field: 'id')}" required id= "usuarios.id">
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
