<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
        <title>Editar Personas</title>
    </head>
    <body>
        <a href="#edit-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="${createLink(uri: '/inicio/')}">Principal</a></li>
                <li><a class="list" href="${createLink(uri: '/persona/listar')}">Lista de Personas</a></li>
                <li><g:link class="create" action="create">Nueva Persona</g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_POSTULANTE">
                <li><a class="home" href="/persona/show/${pos}">Principal</a></li>
                </sec:ifAnyGranted>

                </ul>
            </div>
            <div id="edit-persona" class="content scaffold-edit" role="main">
                <h1>Editar Persona</h1>
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
            <g:form resource="${this.persona}" method="PUT">
                <g:hiddenField name="version" value="${this.persona?.version}" />
                <fieldset class="form">
                    <f:with bean="persona">
                    <f:field property="nombres"/>
                    <f:field property="apellidos"/>
                    <f:field property="genero"/>
                    <f:field property="fechaNac"/>
                    <f:field property="pais"/>
                    <f:field property="tipoDocumento"/>
                    <f:field property="numDocumento"/>
                    <f:field property="NIT"/>
                    <f:field property="NUP"/>
                    <f:field property="direccion"/>
                    <f:field property="correo"/>
                    <input type="hidden" name="usuarios.id" value="${sec.loggedInUserInfo(field: 'id')}" required id= "usuarios.id">
                    </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="Actualizar mis datos" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>