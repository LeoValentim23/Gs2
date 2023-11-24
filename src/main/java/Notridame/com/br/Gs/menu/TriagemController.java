package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.Service.TriagemService;
import com.sun.net.httpserver.HttpExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/triagem")
public class TriagemController {

    @Autowired
    private TriagemService triagemService;

    @GetMapping("/realizar")
    public String realizarTriagem(HttpServletRequest request) {
        String cpfUsuarioLogado = LoginController.getCpfUsuarioLogado((HttpExchange) request);
        return triagemService.realizarTriagem(cpfUsuarioLogado);
    }
}
