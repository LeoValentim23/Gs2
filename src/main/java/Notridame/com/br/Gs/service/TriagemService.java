package Notridame.com.br.Gs.service;

import Notridame.com.br.Gs.DAO.ProcessoTriagemDAO;
import Notridame.com.br.Gs.model.Historico.InformacoesSintoma;
import Notridame.com.br.Gs.model.model.Paciente;
import Notridame.com.br.Gs.model.model.TipoSintoma;
import Notridame.com.br.Gs.model.pulseira.*;

public class TriagemService {

    public InformacoesSintoma obterInformacoesSintoma() {

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


    public pulseira realizarTriagem(String cpfPaciente, InformacoesSintoma informacoesSintoma) {
        // Verifica se o CPF é válido (isso é apenas um exemplo, substitua com sua lógica real)
        if (!validarCPF(cpfPaciente)) {
            throw new IllegalArgumentException("CPF inválido");
        }

        // Obtém o paciente usando o CPF
        Paciente paciente = obterPacientePorCpf(cpfPaciente);



        // Realiza a triagem com as informações do sintoma
        pulseira resultadoTriagem = calcularUrgenciaComBaseNasInformacoes(cpfPaciente, informacoesSintoma);

        // Retorna o resultado da triagem
        return resultadoTriagem;
    }

    public void adicionarHistorico(String cpfPaciente, InformacoesSintoma informacoesSintoma, pulseira pulseira) {
        int nivelUrgencia = mapearIntensidadeParaNivelUrgencia(pulseira);

        ProcessoTriagemDAO.inserirHistorico(cpfPaciente, informacoesSintoma.getTipoSintoma().name(),
                informacoesSintoma.getIntensidadeSintoma(), nivelUrgencia);
    }

    private Paciente obterPacientePorCpf(String cpfPaciente) {
        // Utiliza o método existente na classe ProcessoTriagemDAO
        return ProcessoTriagemDAO.obterPacientePorCpf(cpfPaciente);
    }

    private boolean validarCPF(String cpf) {


        return true; // Substitua esta linha com sua lógica real
    }

    private pulseira calcularUrgenciaComBaseNasInformacoes(String cpfPaciente, InformacoesSintoma informacoesSintoma) {
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
