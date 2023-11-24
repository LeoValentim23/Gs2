package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.LoginDAO;
import Notridame.com.br.Gs.model.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @PostMapping("/login")
    public ResponseEntity<String> realizarLogin(@RequestBody Paciente paciente, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String senha = paciente.getSenha();
        String cpf = paciente.getCpf();

        if (LoginDAO.verificarCadastro(cpf, senha)) {
            HttpSession session = request.getSession();
            session.setAttribute("cpfUsuarioLogado", cpf);

            // O redirecionamento ocorrerá automaticamente pelo AuthenticationSuccessHandler
            return ResponseEntity.status(HttpStatus.OK).body("Login bem-sucedido. Bem-vindo!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login falhou. CPF ou senha incorretos.");
        }
    }

    public static String getCpfUsuarioLogado(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("cpfUsuarioLogado");
    }
}
