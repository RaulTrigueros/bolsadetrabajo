<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Usuario_EmailSender</title>
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
            <h2>Email Sender Form</h2>
            <g:form action="send" controller="emailSender">
                <div class="fieldcontain">
                  <g:textField name="address" placeholder="youremail@gmail.com" required="" /> 
                </div>
                <div class="fieldcontain">
                  <g:textField name="subject" placeholder="Your Subject" required="" />
                </div>
                <div class="fieldcontain">
                  <g:textArea name="body" rows="5" cols="80" placeholder="Your message" required="" />
                </div>
                <fieldset>
                  <g:submitButton name="email" value="Send" />
                </fieldset>
            </g:form>
        </section>
    </div>
</body>
</html>