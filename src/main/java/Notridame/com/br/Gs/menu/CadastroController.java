package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.PacienteDAO;
import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private PacienteDAO pacienteDAO;

    @PostMapping
    public ResponseEntity<String> realizarCadastro(@RequestBody Paciente novoPaciente) {
        try {
            ConnectionManager connectionManager = new ConnectionManager();

            System.out.println("Inserindo no banco de dados...");

            if (PacienteDAO.inserirNoBancoDeDados(novoPaciente, connectionManager)) {
                System.out.println("Cadastro realizado com sucesso!");
                return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso!");
            } else {
                System.out.println("Erro ao realizar o cadastro.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar o cadastro.");
            }
        } catch (Exception e) {
            System.out.println("Erro inesperado ao processar a requisição: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado ao processar a requisição.");
        }
    }

}