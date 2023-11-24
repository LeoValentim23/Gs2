package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.LoginDAO;
import Notridame.com.br.Gs.model.model.Paciente;
import Notridame.com.br.Gs.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @PostMapping("/login")
    public ResponseEntity<String> realizarLogin(@RequestBody Paciente paciente, HttpServletRequest request) throws ServletException, IOException {
        String senha = paciente.getSenha();
        String cpf = paciente.getCpf();

        if (LoginDAO.verificarCadastro(cpf, senha)) {
            // Usuário autenticado com sucesso
            HttpSession session = request.getSession();
            session.setAttribute("cpfUsuarioLogado", cpf);

            customAuthenticationSuccessHandler.onAuthenticationSuccess(request, null, null);
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
