package EmailSender
import org.springframework.web.multipart.MultipartFile


class EmailSenderController {

    //Las 4 vistas que usan este controlador
    def index() { }
    def contacto() {}
    def desbloqueo() {}
    def cambioRol() {}
    
    def send() {
        def multipartFile = request.getFile('attachment')

        sendMail {
            multipart true
            to params.address
            subject params.subject
            html params.body
            if(multipartFile && !multipartFile.empty) {
               File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + multipartFile.getOriginalFilename());
               multipartFile.transferTo(tmpFile);
               attach tmpFile
        }
    }

    flash.message = "Tu mensaje fue enviado correctamente "+new Date()
    redirect action:"index"
    }
        
    def envio2() {
        sendMail {
        	to params.address
        	subject "Ayuda BADMASTER"
        	html params.body
   		}

    	flash.message = "Se envio correctamente el mensaje "+new Date()
    	//redirect to:"../../index" 
        //render(view:"contacto")
        redirect action:"contacto"
    }
    
    def desbloq() {
        sendMail {
        	to params.address
        	subject "Solicitud-Desbloqueo-Cuenta"
        	html params.body
   		}

    	flash.message = "Se envio correctamente el mensaje "+new Date()
        redirect action:"desbloqueo"
    }
        def solRol() {
        sendMail {
        	to params.address
        	subject "Solicitud-Cambio-Rol"
        	html  "**ROL: " + params.group  + " **CUENTA A REASIGNAR: " + params.body
   		}

    	flash.message = "Se envio correctamente el mensaje "+new Date()
        redirect action:"cambioRol"
    }
	
}
