package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.DAO.CpfLogado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Notridame.com.br.Gs.service.HistoricoService;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes/historico")
public class HistoricoMedicoResource {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/medico")
    public List<String> obterHistoricoMedico() {
        // Implemente a lógica para recuperar o histórico médico usando o serviço
        return historicoService.obterHistoricoMedico(CpfLogado.getCpfUsuarioLogado());
    }
}