package br.com.veigarReceiver.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues="jsa.queue")
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message: " + msg);
    }
}
