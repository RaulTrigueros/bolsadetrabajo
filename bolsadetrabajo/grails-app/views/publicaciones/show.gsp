<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'publicaciones.label', default: 'Publicaciones')}" />
        <title>Mostrar Publicacioness</title>
    </head>
    <body>
        <a href="#show-publicaciones" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: 'index')}">Principal</a></li>
                <li><g:link class="list" action="index">Lista de Publicacioness</g:link></li>
                <li><g:link class="create" action="create">Nuevo Publicaciones</g:link></li>
            </ul>
        </div>
        <div id="show-publicaciones" class="content scaffold-show" role="main">
            <h1>Mostrar Publicaciones</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="publicaciones" />
            <g:form resource="${this.publicaciones}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.publicaciones}">Editar</g:link>
                    <input class="delete" type="submit" value="Eliminar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
