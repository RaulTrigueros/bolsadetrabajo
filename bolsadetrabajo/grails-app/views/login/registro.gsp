<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Usuario_Create</title>
</head>
<body>
    <!--bloque para capturar mensages del controlador y manejarlos en el js para pintar un toast con la info-->
    <g:if test="${flash.message}">
        <ul>
            <g:each var="item" in="${flash.message}">
                <input type="text" name="opcionesAlertas" id="opcionesAlertas" value="${flash.message}" hidden>
            </g:each>
        </ul>
    </g:if>
    <content tag="titulo_template">
        Registrar Usuario
    </content>
    <g:form name="userCreateForm" id="userCreateForm" action="save" controller="user">
        <div class="container">
            <div class="card">
                <div class="card-header text-white" style="background-color:rgb(17, 147, 140);">
                    <h4>
                        Datos Generales:
                    </h4>
                </div>
                <div class="card-body">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Username:&nbsp;<span style="color:red">*</span></span>
                        </div>
                        <input type="text" class="form-control" id="username" name="username"
                            placeholder="Ingrese el username" maxlength="50" value="${user.username}" required>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Password:&nbsp;<span style="color:red">*</span></span>
                        </div>
                        <input type="password" class="form-control" id="password" name="password"
                            placeholder="Ingrese la contraseña" maxlength="50" required >
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="spanGroupRole">Grupos:&nbsp;<span style="color:red">*</span></span>
                        </div>
                            <select class="form-control" id="groupRole" name="groupRole" required multiple>
                                <g:each var="item" in="${roleGroupsList}">
                                    <option value="${item.id}">${item.name}</option>
                                </g:each>
                            </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Habilitada:</span>
                        </div>
                        <select class="form-control" id="enabled" name="enabled">
                            <option selected disabled value="">----Seleccione el Estado----</option>
                            <option value="0">NO</option>
                            <option value="1">SI</option>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Contraseña Expirada:</span>
                        </div>
                        <select class="form-control" id="passwordExpired" name="passwordExpired">
                            <option selected disabled value="">----Seleccione el Estado----</option>
                            <option value="0">NO</option>
                            <option value="1">SI</option>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Cuenta Expirada:</span>
                        </div>
                        <select class="form-control" id="accountExpired" name="accountExpired">
                            <option selected disabled value="">----Seleccione el Estado----</option>
                            <option value="0">NO</option>
                            <option value="1">SI</option>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Cuenta Bloqueada:</span>
                        </div>
                        <select class="form-control" id="accountLocked" name="accountLocked">
                            <option selected disabled value="">----Seleccione el Estado----</option>
                            <option value="0">NO</option>
                            <option value="1">SI</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </g:form>
    <div class="container">
        <div class="card bg-light mb-3">
            <div class="card-body">
                <g:link controller="user" action="index" class='btn btn-danger'>Cancelar</g:link>
                <button type="submit" class='btn btn-success' id='id_guardar'> Registrar</button>
            </div>
        </div>
    </div>
    <content tag="javascript">
       <asset:javascript src="seguridad/user/userCreate.js"/>
    </content>
</body>
</html>