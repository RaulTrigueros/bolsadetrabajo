<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dtspersonales.label', default: 'Dtspersonales')}" />
        <title>Mostrar Dtspersonaless</title>
    </head>
    <body>
        <a href="#show-dtspersonales" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><g:link class="list" action="index">Lista de Dtspersonaless</g:link></li>
                <li><g:link class="create" action="create">Nuevo Dtspersonales</g:link></li>
            </ul>
        </div>
        <div id="show-dtspersonales" class="content scaffold-show" role="main">
            <h1>Mostrar Dtspersonales</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="dtspersonales" />
            <g:form resource="${this.dtspersonales}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.dtspersonales}">Editar</g:link>
                    <input class="delete" type="submit" value="Eliminar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
