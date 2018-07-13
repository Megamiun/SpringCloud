package br.com.receiver.consumer;

import br.com.receiver.domain.Tarefas;
import br.com.receiver.repositories.TarefasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private TarefasRepository tarefasRepository;
    
	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(String msg) {
		System.out.println(msg);

		ObjectMapper mapper = new ObjectMapper();
    	try {
    		Tarefas tarefas = mapper.readValue(msg, Tarefas.class);
    		tarefasRepository.save(tarefas);
    	} catch (IOException e) {
			e.printStackTrace();
		}

		for (ServiceInstance inst : discoveryClient.getInstances("SENDER")) {
    		System.out.print(inst.getUri());
		}
    }
}
