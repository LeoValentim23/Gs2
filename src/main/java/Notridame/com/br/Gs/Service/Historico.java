package Notridame.com.br.Gs.Service;

import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Historico {

    public static void mostrarHistorico() {
        System.out.println("Bem-vindo ao Menu de Histórico");

        RestTemplate restTemplate = new RestTemplate();
        List<String> historicoList = restTemplate.getForObject("http://localhost:8050/historico/mostrar", List.class);

        for (String historico : historicoList) {
            System.out.println(historico);
        }
    }
}
