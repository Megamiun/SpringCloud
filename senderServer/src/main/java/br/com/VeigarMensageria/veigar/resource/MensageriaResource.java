package br.com.VeigarMensageria.veigar.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.VeigarMensageria.veigar.component.Productor;

@RestController
public class MensageriaResource {

	@Autowired
	Productor productor;
	
	@RequestMapping(value="/send", method = RequestMethod.GET)
	private ResponseEntity<?> sendMsg(@RequestParam("msg") String msg) {
		productor.produceMessenger(msg);
		return ResponseEntity.ok().body("Mensagem : \""+ msg + "\"Enviada!");
	}
}