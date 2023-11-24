
package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.Service.LoginService;
import Notridame.com.br.Gs.model.model.Paciente;
import Notridame.com.br.Gs.security.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;


@Controller
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> realizarLogin(@RequestBody Paciente paciente, HttpServletRequest request) throws ServletException, IOException {
        String cpf = paciente.getCpf();
        String senha = paciente.getSenha();

        String loginResult = LoginService.realizarLogin(cpf, senha);

        if (loginResult.startsWith("Login realizado")) {
            HttpSession session = request.getSession();
            session.setAttribute("cpfUsuarioLogado", cpf);
        }

        return ResponseEntity.status(HttpStatus.OK).body(loginResult);
    }


    public static String getCpfUsuarioLogado(HttpExchange exchange) {
        Map<String, Object> session = SessionManager.getSession(exchange);
        if (session != null) {
            return (String) session.get("cpfUsuarioLogado");
        }
        return null;
    }
}