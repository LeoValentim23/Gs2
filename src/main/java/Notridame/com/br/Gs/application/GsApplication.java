package Notridame.com.br.Gs.application;

import Notridame.com.br.Gs.menu.Menu;
import Notridame.com.br.Gs.model.Paciente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GsApplication {

	private static Paciente paciente;

	public static final String BASE_URI = "http://localhost:8050";

	public static void main(String[] args) {
		SpringApplication.run(GsApplication.class, args);

		Scanner scanner = new Scanner(System.in);

		Menu.mostrarMenuPrincipal(scanner);
	}
}



