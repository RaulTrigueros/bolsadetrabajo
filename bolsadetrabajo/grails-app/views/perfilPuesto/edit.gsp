<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'perfilPuesto.label', default: 'PerfilPuesto')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-perfilPuesto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/inicio/"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_EMPRESA">
                <li><a class="list" href="/perfilPuesto/index/${sec.loggedInUserInfo(field: 'id')}">Listado de puestos</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="edit-perfilPuesto" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.perfilPuesto}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.perfilPuesto}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.perfilPuesto}" method="PUT">
                <g:hiddenField name="version" value="${this.perfilPuesto?.version}" />
                <fieldset class="form">
                    <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                    <f:with bean="perfilPuesto">
                    <f:field property="nombrePuestoTrabajo"/>
                    <f:field property="descripcionPuesto"/>
                    <f:field property="conocimientosNecesarios"/>
                    <f:field property="perfilAcademico" />
                    <f:field property="habilidades" />
                    <f:field property="experienciaLaboral"/>
                    <f:field property="salarioMin"/>
                    <f:field property="salarioMax"/>
                    <f:field property="ubicacionGeografica"/>
                    <input type="hidden" name="empresa.id" value="${emp}" required id= "${emp}">
                    </f:with>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_ADMIN">
                        <f:all bean="perfilPuesto">
                    </sec:ifAnyGranted>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
