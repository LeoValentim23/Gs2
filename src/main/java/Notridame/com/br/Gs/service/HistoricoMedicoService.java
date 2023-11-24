package Notridame.com.br.Gs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.HistoricoMedicoDAO;
import Notridame.com.br.Gs.model.Historico.HistoricoSintomas;

import java.util.List;

@Service
public class HistoricoMedicoService {

    @Autowired
    private HistoricoMedicoDAO historicoMedicoDAO;

    public List<String> obterHistoricoSintomas(String cpfUsuarioLogado) {
        return historicoMedicoDAO.getHistoricoSintomas(cpfUsuarioLogado);
    }

    public void adicionarHistoricoSintomas(HistoricoSintomas historicoSintomas) {
        // Implemente a lógica para adicionar o histórico de sintomas usando o DAO
        historicoMedicoDAO.adicionarHistoricoSintomas(historicoSintomas);
    }


}