package Notridame.com.br.Gs.Service;

import Notridame.com.br.Gs.DAO.ProcessoTriagemDAO;
import Notridame.com.br.Gs.model.Historico.InformacoesSintoma;
import Notridame.com.br.Gs.model.pulseira.*;
import Notridame.com.br.Gs.model.model.TipoSintoma;
import org.springframework.stereotype.Component;

import java.util.Scanner;  // Adicionei esta importação

@Component
public class TriagemUtil {

    private Scanner scanner;  // Adicionei este membro

    public InformacoesSintoma obterInformacoesSintoma() {
        System.out.println("Tipos de Sintomas:");
        for (TipoSintoma sintoma : TipoSintoma.values()) {
            System.out.println(sintoma.ordinal() + 1 + ". " + sintoma.name());
        }
        System.out.print("Escolha o número correspondente ao tipo de sintoma: ");
        int tipoSintomaEscolhido = lerInteiroDoUsuario();

        TipoSintoma tipoSintoma = TipoSintoma.values()[tipoSintomaEscolhido - 1];

        System.out.print("Intensidade do Sintoma (1 a 10): ");
        int intensidadeSintoma = lerInteiroDoUsuario();

        return new InformacoesSintoma(tipoSintoma, intensidadeSintoma);
    }

    public pulseira calcularUrgenciaComBaseNasInformacoes(String cpfPaciente, InformacoesSintoma informacoesSintoma) {
        int idade = ProcessoTriagemDAO.obterIdadeDoPaciente(cpfPaciente);
        TipoSintoma tipoSintoma = informacoesSintoma.getTipoSintoma();
        int intensidadeSintoma = informacoesSintoma.getIntensidadeSintoma();

        int pontuacaoTotal = CalculadoraPontuacao.calcularPontuacaoTotal(idade, tipoSintoma, intensidadeSintoma);

        if (pontuacaoTotal >= 0 && pontuacaoTotal <= 2) {
            return new NaoUrgente();
        } else if (pontuacaoTotal > 2 && pontuacaoTotal <= 4) {
            return new PoucoUrgente();
        } else if (pontuacaoTotal > 4 && pontuacaoTotal <= 6) {
            return new Urgente();
        } else if (pontuacaoTotal > 6 && pontuacaoTotal <= 8) {
            return new MuitoUrgente();
        } else {
            return new emergencia();
        }
    }

    public void adicionarHistorico(String cpfPaciente, InformacoesSintoma informacoesSintoma, pulseira pulseira) {
        int nivelUrgencia = mapearIntensidadeParaNivelUrgencia(pulseira);

        ProcessoTriagemDAO.inserirHistorico(cpfPaciente, informacoesSintoma.getTipoSintoma().name(),
                informacoesSintoma.getIntensidadeSintoma(), nivelUrgencia);
    }

    private int lerInteiroDoUsuario() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int mapearIntensidadeParaNivelUrgencia(pulseira pulseira) {
        if (pulseira instanceof NaoUrgente) {
            return 1;
        } else if (pulseira instanceof PoucoUrgente) {
            return 2;
        } else if (pulseira instanceof Urgente) {
            return 3;
        } else if (pulseira instanceof MuitoUrgente) {
            return 4;
        } else {
            return 5;
        }
    }
}
