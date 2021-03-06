<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Mensajeria BADMASTER</title>
	<asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
        <script src="//cdn.ckeditor.com/4.6.0/full-all/ckeditor.js"></script>
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
            <g:form action="send" controller="emailSender" enctype="multipart/form-data">
                <div class="fieldcontain">
                  <g:textField name="address" placeholder="aspirante@gmail.com" required="" /> 
                </div>
                <div class="fieldcontain">
                  <g:textField name="subject" placeholder="Asunto" required="" />
                </div>
                <div class="fieldcontain">
                  <g:textArea name="body" rows="5" cols="80" placeholder="Tu mensaje" required="" />
                </div>
                <input type="file" name="attachment" />
                <fieldset>
                  <g:submitButton name="email" value="Enviar" />
                </fieldset>
            </g:form>
        </section>
        
    </div>
    <script>
  CKEDITOR.replace('body', {
    extraPlugins: 'codesnippet'
  });
</script>
</body>
</html>