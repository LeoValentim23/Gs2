package Notridame.com.br.Gs.Service;

import Notridame.com.br.Gs.DAO.ProcessoTriagemDAO;
import Notridame.com.br.Gs.model.Historico.InformacoesSintoma;
import Notridame.com.br.Gs.model.pulseira.pulseira;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {

    private static TriagemUtil triagemUtil = new TriagemUtil();

    public TriagemService(TriagemUtil triagemUtil) {
        this.triagemUtil = triagemUtil;
    }

    public static String realizarTriagem(String cpfUsuarioLogado) {
        String endereco = ProcessoTriagemDAO.obterEnderecoDoPaciente(cpfUsuarioLogado);

        if (endereco != null) {
            InformacoesSintoma informacoesSintoma = triagemUtil.obterInformacoesSintoma();
            pulseira pulseira = triagemUtil.calcularUrgenciaComBaseNasInformacoes(cpfUsuarioLogado, informacoesSintoma);

            triagemUtil.adicionarHistorico(cpfUsuarioLogado, informacoesSintoma, pulseira);

            return "Triagem realizada com sucesso! Pulseira atribuída: " + pulseira.getClass().getSimpleName();
        } else {
            return "Paciente não encontrado.";
        }
    }
}
