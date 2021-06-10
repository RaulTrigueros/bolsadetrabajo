package EmailSender
import org.springframework.web.multipart.MultipartFile


class EmailSenderController {

    def index() { }
    
    def contacto() {}
    
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
        	subject params.subject
        	html params.body
   		}

    	flash.message = "Se envio correctamente el mensaje "+new Date()
    	//redirect to:"../../index" 
        //render(view:"contacto")
        redirect action:"contacto"
    }
	
}
