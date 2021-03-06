<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Registrar</title>
    </head>
    <body>
       
        <a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul> 
                <li><a class="home" href="${createLink(uri: '/')}">Principal</a></li> 
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="list" href="${createLink(uri: 'listar')}">Lista de Usuarios</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        
        <div id="create-user" class="content scaffold-create" role="main">
            <h1>Registrar</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.user}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.user}" method="POST">
                <fieldset class="form">
                    <f:all bean="user" except="accountExpired,accountLocked,passwordExpired"/>
                    <sec:ifAnyGranted roles="ROLE_ADMIN">
                         <f:all bean="user" except="username,password,enabled"/>
                    </sec:ifAnyGranted>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Crear" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
