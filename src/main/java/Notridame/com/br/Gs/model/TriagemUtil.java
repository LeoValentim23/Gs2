package Notridame.com.br.Gs.model;

import Notridame.com.br.Gs.DAO.ProcessoTriagemDAO;

import java.util.Scanner;



public class TriagemUtil {

    public static InformacoesSintoma obterInformacoesSintoma() {
        System.out.println("Tipos de Sintomas:");
        for (TipoSintoma sintoma : TipoSintoma.values()) {
            System.out.println(sintoma.ordinal() + 1 + ". " + sintoma.name());
        }
        System.out.print("Escolha o número correspondente ao tipo de sintoma: ");
        int tipoSintomaEscolhido = TriagemUtil.lerInteiroDoUsuario();

        TipoSintoma tipoSintoma = TipoSintoma.values()[tipoSintomaEscolhido - 1];

        System.out.print("Intensidade do Sintoma (1 a 10): ");
        int intensidadeSintoma = TriagemUtil.lerInteiroDoUsuario();

        return new InformacoesSintoma(tipoSintoma, intensidadeSintoma);
    }

    public static pulseira calcularUrgenciaComBaseNasInformacoes(String cpfPaciente, InformacoesSintoma informacoesSintoma) {
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


    public static int lerInteiroDoUsuario() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
