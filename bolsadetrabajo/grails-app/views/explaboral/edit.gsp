<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'explaboral.label', default: 'Explaboral')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-explaboral" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/user/index"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="list" href="/explaboral/index/${sec.loggedInUserInfo(field: 'id')}" ><g:message code="default.list.label" args="[entityName]" /></a></li>                
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="edit-explaboral" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.explaboral}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.explaboral}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.explaboral}" method="PUT">
                <g:hiddenField name="version" value="${this.explaboral?.version}" />
                <fieldset class="form">
                    <f:with bean="explaboral">
                    <f:field property="organizacionDeExperiencia"/>
                    <f:field property="contactoOrganizacion"/>
                    <f:field property="puestoTrabajo"/>
                    <f:field property="fechaInicio"/>
                    <f:field property="fechaFin"/>
                    <f:field property="funcionesDesempenadas"/>
                    <input type="hidden" name="persona.id" value="${per}" required id= "${per}">
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
