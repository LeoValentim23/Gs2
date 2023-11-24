package Notridame.com.br.Gs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Notridame.com.br.Gs.DAO.LoginDAO;
import Notridame.com.br.Gs.menu.MenuUsuario;

@Service
public class LoginService {

    public static String cpfUsuarioLogado;

    @Autowired
    private MenuUsuario menuUsuario;

    public boolean realizarLogin(String senha, String cpf) {
        if (LoginDAO.verificarCadastro(cpf, senha)) {
            System.out.println("Login bem-sucedido. Bem-vindo!");

            cpfUsuarioLogado = cpf;

            System.out.println(cpfUsuarioLogado);

            menuUsuario.mostrarMenuUsuario(); // Note que o scanner não é mais necessário aqui

            return true;
        } else {
            System.out.println("Login falhou. CPF ou senha incorretos.");
            return false;
        }
    }

    public String getCpfUsuarioLogado() {
        return cpfUsuarioLogado;
    }
}
