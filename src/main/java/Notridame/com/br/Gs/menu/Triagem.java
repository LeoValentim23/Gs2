package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.ProcessoTriagemDAO;
import Notridame.com.br.Gs.model.Historico.InformacoesSintoma;
import Notridame.com.br.Gs.model.pulseira.pulseira;
import Notridame.com.br.Gs.service.TriagemUtil;

public class Triagem {

    public static void mostrarTriagem() {
        String cpfUsuarioLogado = Login.cpfUsuarioLogado;

        String endereco = ProcessoTriagemDAO.obterEnderecoDoPaciente(cpfUsuarioLogado);

        if (endereco != null) {
            System.out.println("Endereço do Paciente: " + endereco);
            InformacoesSintoma informacoesSintoma = TriagemUtil.obterInformacoesSintoma();
            pulseira pulseira = TriagemUtil.calcularUrgenciaComBaseNasInformacoes(cpfUsuarioLogado, informacoesSintoma);
            System.out.println("Pulseira Atribuída: " + pulseira.getClass().getSimpleName());


            TriagemUtil.adicionarHistorico(cpfUsuarioLogado, informacoesSintoma, pulseira);

        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}