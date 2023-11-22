package Notridame.com.br.Gs.menu;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Menu {
    public static void mostrarMenuPrincipal(Scanner scanner) {
        scanner = new Scanner(System.in);
            int opcao;

            System.out.println("Bem-vindo ao Menu Principal!");

            while (true) {
                System.out.println("Selecione a opção:");
                System.out.println("1 - Login");
                System.out.println("2 - Cadastro Cliente");
                System.out.println("3 - Sair");

                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();

                            System.out.print("Senha: ");
                            String senha = scanner.nextLine();

                            if (Login.realizarLogin(senha, cpf)) {


                            }
                            break;
                        case 2:
                            Cadastro.realizarCadastro(scanner);

                            break;
                        case 3:
                            System.out.println("Obrigado por utilizar o sistema!");
                            scanner.close();
                            System.exit(0);
                        default:
                            System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine();
                }
            }
        }
    }
