package parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(MainConfig.class)
public class Application extends SpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}