package Notridame.com.br.Gs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.HistoricoDAO;

import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoDAO historicoDAO;

    public List<String> obterHistoricoMedico(String cpfUsuarioLogado) {
        // Implemente a lógica para recuperar o histórico médico usando o DAO
        return historicoDAO.getHistoricoMedico(cpfUsuarioLogado);
    }

    public List<String> obterHistoricoSintomas(String cpfUsuarioLogado) {
        // Implemente a lógica para recuperar o histórico de sintomas usando o DAO
        return historicoDAO.getHistoricoSintomas(cpfUsuarioLogado);
    }
}
