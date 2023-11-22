package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.service.LoginService;

import java.util.Scanner;

public class Login {
    public static String cpfUsuarioLogado;
    private static Scanner scanner;

    public static boolean realizarLogin(String senha, String cpf) {
        if (LoginService.verificarCadastro(cpf, senha)) {
            System.out.println("Login bem-sucedido. Bem-vindo!");

            cpfUsuarioLogado = cpf;

            System.out.println(cpfUsuarioLogado);

            MenuUsuario.mostrarMenuUsuario(scanner);
            ;

            return true;
        } else {
            System.out.println("Login falhou. CPF ou senha incorretos.");
            return false;
        }
    }

    public static String getCpfUsuarioLogado() {
        return cpfUsuarioLogado;
    }
}