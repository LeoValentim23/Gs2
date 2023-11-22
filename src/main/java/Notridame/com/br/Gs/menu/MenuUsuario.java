package Notridame.com.br.Gs.menu;

import java.util.Scanner;

public class MenuUsuario {

    public static void mostrarMenuUsuario(Scanner scanner) {
        Scanner scanner2 = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Bem-vindo ao Menu do Usuário");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Histórico");
            System.out.println("2 - Histórico Médico");
            System.out.println("3 - Triagem");
            System.out.println("0 - Sair");

            opcao = scanner2.nextInt();
            scanner2.nextLine();

            switch (opcao) {
                case 1:
                    Historico.mostrarHistorico();
                    break;
                case 2:
                    HistoricoMedico.mostrarHistoricoMedico();
                    break;
                case 3:
                    Triagem.mostrarTriagem();
                    break;
                case 0:
                    System.out.println("Saindo do Menu do Usuário.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}