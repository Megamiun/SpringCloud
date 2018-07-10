package br.com.VeigarMensageria.veigar.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Productor {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;
	
	public void produceMessenger(String msg) {
		amqpTemplate.convertAndSend(exchange,routingKey,msg);
		System.out.println("Send msg = "+ msg);
	}
}
