<html>
<head>
	<meta name="layout" content="main"/>
	<title>Solicitud de Rol</title>
	<asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    
	 <div id="content" role="main">
        <section class="row colset-2-its">
            <g:if test="${flash.message}">
                <div class="message" role="alert">
                    ${flash.message}
                </div>
            </g:if>
             
                 <h2>Mensajeria BADMASTER</h2>
            
            <g:form action="solRol" controller="emailSender">
                <br><label>Correo: </label></br>
                <div class="fieldcontain">
                 
                  <g:textField name="address" required="" value="grupo9bad115@gmail.com" readonly="readonly"/> 
                </div>
                
                <br><label>Asunto: </label></br>
                <div class="fieldcontain">
                  
                  <g:textField name="subject" required="" value="Solicitud-Cambio-Rol" readonly="readonly" />
                </div>
                <br><label>Rol que solicitas: </label></br>
                <div class="fieldcontain">
                    
                  <g:select name="group" from="${['Empresa', 'Postulante']}"/>
                </div>
                
               <br><label>Texto: </label></br>
                <div class="fieldcontain">
                    
                  <g:textArea name="body" rows="5" cols="80" placeholder="Escribe tu e-mail  y tu nombre completo y rol que necesitas" required="" />
                </div>
                
                <fieldset>
                  <g:submitButton name="email" value="Enviar" />
                </fieldset>
                
            </g:form>
        </section>
    </div>
</body>
</html>