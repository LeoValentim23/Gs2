package Notridame.com.br.Gs.resource;

import Notridame.com.br.Gs.model.model.Paciente;
import Notridame.com.br.Gs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public String realizarLogin(@RequestBody Paciente paciente) {
        if (loginService.realizarLogin(paciente.getSenha(), paciente.getCpf())) {
            return "Login bem-sucedido. Bem-vindo!";
        } else {
            return "Login falhou. CPF ou senha incorretos.";
        }
    }
}
