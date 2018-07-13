package br.com.sender.resource;

import br.com.sender.component.Productor;
import br.com.sender.domain.Tarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensageriaResource {

	@Autowired
    Productor productor;
	
	@RequestMapping(value="/send", method = RequestMethod.POST)
	private ResponseEntity<?> sendMsg(@RequestBody Tarefas user) {
		productor.produceMessenger(user);
		return ResponseEntity.ok().build();
	}
}