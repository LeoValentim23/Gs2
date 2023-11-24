package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.PacienteDAO;
import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.model.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @PostMapping
    public ResponseEntity<String> realizarCadastro(@RequestBody Paciente novoPaciente) {

        try {
            ConnectionManager connectionManager = new ConnectionManager();

            if (PacienteDAO.inserirNoBancoDeDados(novoPaciente, connectionManager)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar o cadastro.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado ao processar a requisição.");
        }
    }
}
