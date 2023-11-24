package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.model.model.Paciente;
import Notridame.com.br.Gs.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes/cadastro")
public class CadastroPacienteResource {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public String cadastrarPaciente(@RequestBody Paciente paciente) {

        boolean sucesso = cadastroService.cadastrarPaciente(paciente);

        if (sucesso) {
            return "Cadastro realizado com sucesso!";
        } else {
            return "Erro ao realizar o cadastro.";
        }
    }
}
