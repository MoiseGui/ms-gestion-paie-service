package ma.irirsi.gestionpaieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestionDeLaPaieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeLaPaieApplication.class, args);
	}

}
