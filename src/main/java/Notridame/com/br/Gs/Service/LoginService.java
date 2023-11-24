// LoginService.java
package Notridame.com.br.Gs.Service;

import Notridame.com.br.Gs.DAO.LoginDAO;

public class LoginService {

    public static String realizarLogin(String cpf, String senha) {
        if (LoginDAO.verificarCadastro(cpf, senha)) {
            return "Login realizado com sucesso!";
        } else {
            return "Login falhou. CPF ou senha incorretos.";
        }
    }
}
