package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.model.Paciente;
import Notridame.com.br.Gs.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes/cadastro")
public class CadastroPacienteResource{

    @Autowired
    private HistoricoService historicoService;

    @PostMapping
    public String cadastrarPaciente(@RequestBody Paciente paciente) {
        // Implemente a lógica para lidar com o cadastro
        // Você pode reutilizar sua lógica existente ou adaptá-la à estrutura da API
        return "Cadastro realizado com sucesso!";
    }
}
