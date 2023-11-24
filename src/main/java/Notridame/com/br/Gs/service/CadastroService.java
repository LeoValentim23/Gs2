package Notridame.com.br.Gs.service;

import Notridame.com.br.Gs.conexao.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.PacienteDAO;
import Notridame.com.br.Gs.model.Paciente;

@Service
public class CadastroService {

    @Autowired
    private PacienteDAO pacienteDAO;

    @Autowired
    private ConnectionManager connectionManager; // Certifique-se de ter a instância adequada de ConnectionManager aqui

    public boolean cadastrarPaciente(Paciente paciente) {
        return pacienteDAO.inserirNoBancoDeDados(paciente, connectionManager);
    }
}
