<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
        <title>Mostrar Personas</title>
    </head>
    <body>
        <a href="#show-persona" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><g:link class="list" action="index">Lista de Personas</g:link></li>
                <li><g:link class="create" action="create">Nuevo Persona</g:link></li>
            </ul>
        </div>
        <div id="show-persona" class="content scaffold-show" role="main">
            <h1>Mostrar Persona</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="persona" />
            <g:form resource="${this.persona}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.persona}">Editar</g:link>
                    <li><a class="home" href="${createLink(uri: '/logro/create')}" id="${this.persona}">CREAR UN LOGRO</a></li>
                    <input class="delete" type="submit" value="Eliminar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>