package Notridame.com.br.Gs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;

@SpringBootApplication
public class GsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsApplication.class, args);
	}

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public Filter corsFilter() {
		return new CorsFilter();
	}
}
