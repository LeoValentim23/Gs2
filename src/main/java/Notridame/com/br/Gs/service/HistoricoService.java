package Notridame.com.br.Gs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.HistoricoDAO;
import Notridame.com.br.Gs.model.HistoricoMedico;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoDAO historicoDAO;

    public List<String> obterHistoricoMedico(String cpfUsuarioLogado) {
        // Implemente a lógica para recuperar o histórico médico usando o DAO
        return historicoDAO.getHistoricoMedico(cpfUsuarioLogado);
    }

    public void adicionarHistoricoMedico(HistoricoMedico historicoMedico) {
        // Implemente a lógica para adicionar o histórico médico usando o DAO
        historicoDAO.adicionarHistoricoMedico(historicoMedico);
    }

    // Você pode adicionar métodos adicionais relacionados ao histórico médico aqui
}

