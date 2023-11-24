package Notridame.com.br.Gs.security;

import Notridame.com.br.Gs.DAO.CpfLogado;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationSuccessController {

    @RequestMapping("/onAuthenticationSuccess")
    public String handleAuthenticationSuccess(Authentication authentication) {

        String cpfUsuarioLogado = CpfLogado.getCpfUsuarioLogado(authentication);


        return "redirect:/historico";
    }
}
