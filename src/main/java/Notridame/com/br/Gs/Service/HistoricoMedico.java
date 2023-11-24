package Notridame.com.br.Gs.Service;

import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HistoricoMedico {

    public static void mostrarHistoricoMedico() {
        System.out.println("Menu Histórico de Sintomas");

        RestTemplate restTemplate = new RestTemplate();
        List<String> historicoList = restTemplate.getForObject("http://localhost:8050/historicoMedico/mostrar", List.class);

        for (String historico : historicoList) {
            System.out.println(historico);
        }
    }
}
