package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.DAO.CpfLogado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Notridame.com.br.Gs.service.HistoricoService;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes/historico-sintomas")
public class HistoricoSintomasResource {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<String> obterHistoricoSintomas() {
        // Implemente a lógica para recuperar o histórico de sintomas usando o serviço
        return historicoService.obterHistoricoSintomas(CpfLogado.getCpfUsuarioLogado());
    }
}
