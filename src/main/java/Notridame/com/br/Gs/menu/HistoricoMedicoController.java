package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.HistoricoMedicoDAO;
import com.sun.net.httpserver.HttpExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/historicoMedico")
public class HistoricoMedicoController {

    @Autowired
    private HistoricoMedicoDAO historicoMedicoDAO;

    @GetMapping("/mostrar")
    public List<String> mostrarHistoricoMedico(HttpServletRequest request) {
        String cpfUsuarioLogado = LoginController.getCpfUsuarioLogado((HttpExchange) request);
        return historicoMedicoDAO.getHistoricoSintomas(cpfUsuarioLogado);
    }
}
