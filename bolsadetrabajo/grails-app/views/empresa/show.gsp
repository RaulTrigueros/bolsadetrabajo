<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empresa.label', default: 'Empresa')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-empresa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                <li><a class="home" href="/inicio/">Principal</a></li>
                <li><g:link class="list" action="listar">Lista de Empresas</g:link></li>
                <li><g:link class="create" action="create">Nueva Empresa</g:link></li>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_EMPRESA">
                <li><a class="home" href="/empresa/index/<sec:loggedInUserInfo field='id'/>">Principal</a></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
        <div id="show-empresa" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="empresa" except="perfilPuesto,usuarios"/>
            <g:form resource="${this.empresa}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.empresa}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
