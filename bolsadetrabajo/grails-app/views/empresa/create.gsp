<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empresa.label', default: 'Empresa')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-empresa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="${createLink(uri: '/inicio/')}">Principal</a></li>
                <li><a class="home" href="${createLink(uri: '/empresa/listar')}">Lista de Empresas</a></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_EMPRESA">
                <li><a class="home" href="/empresa/index/<sec:loggedInUserInfo field='id'/>">Principal</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="create-empresa" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
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
            <g:form resource="${this.empresa}" method="POST">
                
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
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
