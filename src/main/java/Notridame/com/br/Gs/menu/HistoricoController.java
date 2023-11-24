package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.HistoricoDAO;
import com.sun.net.httpserver.HttpExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoDAO historicoDAO;

    @GetMapping("/mostrar")
    public List<String> mostrarHistorico(HttpServletRequest request) {
        String cpfUsuarioLogado = LoginController.getCpfUsuarioLogado((HttpExchange) request);
        return historicoDAO.getHistoricoMedico(cpfUsuarioLogado);
    }
}
