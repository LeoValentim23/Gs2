package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.HistoricoDAO;

import java.util.List;

public class Historico {

    public static void mostrarHistorico() {
        System.out.println("Bem-vindo ao Menu de Histórico");

        String cpfUsuarioLogado = Login.cpfUsuarioLogado;


        List<String> historicoList = HistoricoDAO.getHistoricoMedico(cpfUsuarioLogado);


        for (String historico : historicoList) {
            System.out.println(historico);
        }
    }
}