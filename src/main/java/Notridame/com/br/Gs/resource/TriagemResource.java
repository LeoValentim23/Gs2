package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.DAO.CpfLogado;
import Notridame.com.br.Gs.DAO.ProcessoTriagemDAO;
import Notridame.com.br.Gs.service.TriagemService;
import Notridame.com.br.Gs.model.InformacoesSintoma;
import Notridame.com.br.Gs.model.Paciente;
import Notridame.com.br.Gs.model.pulseira;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/triagem")
public class TriagemResource {

    private final TriagemService triagemService;

    public TriagemResource(TriagemService triagemService) {
        this.triagemService = triagemService;
    }

    @PostMapping("/realizar")
    public ResponseEntity<pulseira> realizarTriagem(@RequestBody InformacoesSintoma informacoesSintoma) {
        String cpfPaciente = CpfLogado.getCpfUsuarioLogado();

        if (cpfPaciente == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Paciente paciente = ProcessoTriagemDAO.obterPacientePorCpf(cpfPaciente);

        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pulseira resultadoTriagem = triagemService.realizarTriagem(cpfPaciente, informacoesSintoma);

        // Adicione o histórico após a triagem
        triagemService.adicionarHistorico(cpfPaciente, informacoesSintoma, resultadoTriagem);

        return new ResponseEntity<>(resultadoTriagem, HttpStatus.OK);
    }
}
