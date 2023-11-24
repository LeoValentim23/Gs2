package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.DAO.CpfLogado;
import Notridame.com.br.Gs.model.HistoricoSintomas;
import Notridame.com.br.Gs.service.HistoricoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes/historico-sintomas")
public class HistoricoSintomasResource {

    @Autowired
    private HistoricoMedicoService historicoMedicoService;

    @GetMapping
    public List<String> obterHistoricoSintomas() {
        // Chama o serviço para obter o histórico de sintomas
        return historicoMedicoService.obterHistoricoSintomas(CpfLogado.getCpfUsuarioLogado());
    }

    @PostMapping
    public String adicionarHistoricoSintomas(@RequestBody HistoricoSintomas historicoSintomas) {
        // Implemente a lógica para adicionar o histórico de sintomas usando o serviço
        historicoMedicoService.adicionarHistoricoSintomas(historicoSintomas);
        return "Histórico de sintomas adicionado com sucesso!";
    }
}