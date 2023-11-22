package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.service.HistoricoService;

public class Historico {

    public static void mostrarHistorico() {
        System.out.println("Bem-vindo ao Menu de Histórico");

        String cpfUsuarioLogado = Login.cpfUsuarioLogado;

        HistoricoService.getHistoricoMedico(cpfUsuarioLogado);
    }
}
