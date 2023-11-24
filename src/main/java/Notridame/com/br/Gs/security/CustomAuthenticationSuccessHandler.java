package Notridame.com.br.Gs.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements CustomAuthenticationSuccessHandler2 {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        // Obter o CPF do usuário logado
        String cpfUsuarioLogado = authentication.getName();

        // Lógica para determinar a escolha do usuário (por exemplo, a partir de uma variável de sessão)
        String escolhaUsuario = obterEscolhaUsuario(request);

        // Redirecionar dinamicamente com base na escolha do usuário
        if ("historico".equals(escolhaUsuario)) {
            setDefaultTargetUrl("http://localhost:8080/historico");
        } else if ("historicoMedico".equals(escolhaUsuario)) {
            setDefaultTargetUrl("http://localhost:8080/historicoMedico");
        } else if ("triagem".equals(escolhaUsuario)) {
            setDefaultTargetUrl("http://localhost:8080/triagem");
        }


        super.onAuthenticationSuccess(request, response, authentication);
    }
}