package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.HistoricoMedicoDAO;


import java.util.List;

public class HistoricoMedico {

    public static void mostrarHistoricoMedico() {
        System.out.println("Menu Histórico de Sintomas");

        String cpfUsuarioLogado = Login.cpfUsuarioLogado;

        List<String> historicoList = HistoricoMedicoDAO.getHistoricoSintomas(cpfUsuarioLogado);

        for (String historico : historicoList) {
            System.out.println(historico);
        }
    }
}
