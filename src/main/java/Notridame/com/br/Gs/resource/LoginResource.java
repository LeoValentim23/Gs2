package Notridame.com.br.Gs.resource;


import Notridame.com.br.Gs.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public String realizarLogin(@RequestBody LoginRequest loginRequest) {
        if (loginService.realizarLogin(loginRequest.getSenha(), loginRequest.getCpf())) {
            return "Login bem-sucedido. Bem-vindo!";
        } else {
            return "Login falhou. CPF ou senha incorretos.";
        }
    }
}
