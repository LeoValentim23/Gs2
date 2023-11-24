package Notridame.com.br.Gs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.PacienteDAO;
import Notridame.com.br.Gs.model.Paciente;

@Service
public class CadastroService {

    @Autowired
    private PacienteDAO pacienteDAO;

    public boolean cadastrarPaciente(Paciente paciente) {
        // Implemente a lógica para cadastrar um paciente usando o DAO
        return pacienteDAO.inserirNoBancoDeDados(paciente);
    }
}
