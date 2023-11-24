package Notridame.com.br.Gs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.HistoricoMedicoDAO;

import java.util.List;

@Service
public class HistoricoMedicoService {

    @Autowired
    private HistoricoMedicoDAO historicoMedicoDAO;

    public List<String> obterHistoricoSintomas(String cpfUsuarioLogado) {
        // Implemente a lógica para recuperar o histórico de sintomas usando o DAO
        return historicoMedicoDAO.getHistoricoSintomas(cpfUsuarioLogado);
    }
}