<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Contactanos</title>
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
            <g:form action="envio2" controller="emailSender">
                <div class="fieldcontain">
                  <g:textField name="address" required="" value="grupo9bad115@gmail.com" readonly="readonly"/> 
                </div>
                <div class="fieldcontain">
                  <g:textField name="subject" required="" value="Ayuda-BADMASTER" readonly="readonly" />
                </div>
                <div class="fieldcontain">
                  <g:textArea name="body" rows="5" cols="80" placeholder="¿Cual es tu consulta?" required="" />
                </div>
                <fieldset>
                  <g:submitButton name="email" value="Enviar" />
                </fieldset>
            </g:form>
        </section>
    </div>
</body>
</html>