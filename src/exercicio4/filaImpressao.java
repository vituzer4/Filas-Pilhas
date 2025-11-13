package exercicio4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Documento {
    private final String nome;
    private final int paginas;

    public Documento(String nome, int paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return nome + " (" + paginas + " páginas)";
    }
}

public class filaImpressao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Documento> fila = new LinkedList<>();

        while (true) {
            System.out.println("\n=== FILA DE IMPRESSÃO ===");
            System.out.println("1 - Adicionar novo documento");
            System.out.println("2 - Exibir próximo documento");
            System.out.println("3 - Imprimir (remover) próximo documento");
            System.out.println("4 - Mostrar quantidade de documentos na fila");
            System.out.println("0 - Sair");
            System.out.print("> ");

            String opc = sc.nextLine().trim();

            switch (opc) {
                case "1":
                    System.out.print("Nome do arquivo: ");
                    String nome = sc.nextLine().trim();
                    System.out.print("Número de páginas: ");
                    int paginas = Integer.parseInt(sc.nextLine().trim());
                    fila.add(new Documento(nome, paginas));      // Adiciona o novo documento à fila
                    System.out.println("Documento adicionado à fila!");
                    break;

                case "2":
                    if (fila.isEmpty()) {
                        System.out.println("Fila vazia. Nenhum documento para exibir.");
                    } else {
                        System.out.println("Próximo documento: " + fila.peek());
                    }
                    break;

                case "3":
                    if (fila.isEmpty()) {
                        System.out.println("Fila vazia. Nenhum documento para imprimir.");
                    } else {
                        Documento impresso = fila.remove();
                        System.out.println("Imprimindo: " + impresso);
                    }
                    break;

                case "4":
                    System.out.println("Documentos na fila: " + fila.size());  // Exibe a quantidade de documentos na fila
                    break;

                case "0":
                    System.out.println("Encerrando o sistema de impressão...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
