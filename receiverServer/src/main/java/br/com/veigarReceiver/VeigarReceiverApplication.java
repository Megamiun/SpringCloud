package br.com.veigarReceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class VeigarReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeigarReceiverApplication.class, args);
	}
}
