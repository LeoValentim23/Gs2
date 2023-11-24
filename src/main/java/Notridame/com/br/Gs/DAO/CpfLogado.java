package Notridame.com.br.Gs.DAO;

import Notridame.com.br.Gs.menu.LoginController;

import javax.servlet.http.HttpServletRequest;

public class CpfLogado {
    public static String getCpfUsuarioLogado(HttpServletRequest request) {
        return LoginController.getCpfUsuarioLogado(request);
    }
}
