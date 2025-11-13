package exercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class senhasBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>();
        int contador = 1;     // Contador para gerar senhas sequenciais

        while (true) {
            System.out.println("\n=== SISTEMA DE SENHAS ===");
            System.out.println("1 - Gerar nova senha");
            System.out.println("2 - Chamar próxima senha");
            System.out.println("3 - Mostrar senhas na fila");
            System.out.println("0 - Sair");
            System.out.print("> ");

            String opc = sc.nextLine().trim();

            switch (opc) {
                case "1":
                    // Gera senha com formato S001, S002, S003...
                    String senha = String.format("S%03d", contador++);
                    fila.add(senha);
                    System.out.println("Senha gerada: " + senha);
                    break;

                case "2":
                    if (fila.isEmpty()) {
                        System.out.println("Nenhuma senha na fila.");
                    } else {
                        String proxima = fila.remove();
                        System.out.println("Chamando senha: " + proxima);
                    }
                    break;

                case "3":
                    if (fila.isEmpty()) {
                        System.out.println("Nenhuma senha aguardando atendimento.");
                    } else {
                        System.out.println("Senhas aguardando:");
                        for (String s : fila) {
                            System.out.println("- " + s);
                        }
                    }
                    break;

                case "0":
                    System.out.println("Encerrando o sistema.");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
