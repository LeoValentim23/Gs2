package Notridame.com.br.Gs.menu;

import Notridame.com.br.Gs.DAO.PacienteDAO;
import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.Paciente;

import java.util.Scanner;

public class Cadastro {

    public static void realizarCadastro(Scanner scanner) {
        System.out.println("Cadastro Cliente");


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Plano de Saúde: ");
        String planoSaude = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Idade: ");
        String idade = scanner.nextLine();


        Paciente novoPaciente = new Paciente(nome, Integer.parseInt(idade), sexo, endereco, cpf, senha, Integer.parseInt(planoSaude));


        ConnectionManager connectionManager = new ConnectionManager();


        if (PacienteDAO.inserirNoBancoDeDados(novoPaciente, connectionManager)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o cadastro.");
        }


        Menu.mostrarMenuPrincipal(scanner);
    }
}