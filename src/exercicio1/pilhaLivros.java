package exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class pilhaLivros {
    private final Stack<String> stack = new Stack<>();

    public void push(String livro) {
        stack.push(livro);             //esse método adiciona um livro ao topo da pilha
    }

    public String pop() {
        if (stack.isEmpty()) return null;       //verifica se a pilha está vazia
        return stack.pop();                       //esse método remove 1e retorna o livro do topo da pilha
    }

    public String peek() {
        if (stack.isEmpty()) return null;
        return stack.peek();                //esse método retorna o livro do topo da pilha sem removê-lo
    }

    public List<String> getAll() {      //esse método retorna todos os livros na pilha
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        pilhaLivros pilha = new pilhaLivros();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Remover último livro");
            System.out.println("3 - Mostrar livro do topo");
            System.out.println("4 - Exibir todos os livros");
            System.out.println("0 - Sair");
            System.out.print("> ");

            String opc = sc.nextLine().trim();
            switch (opc) {
                case "1":
                    System.out.print("Nome do livro: ");
                    String nome = sc.nextLine().trim();       //lê o nome do livro a ser adicionado
                    if (!nome.isEmpty()) {
                        pilha.push(nome);
                        System.out.println("Livro adicionado.");
                    } else {
                        System.out.println("Nome vazio. Não foi adicionado.");
                    }
                    break;
                case "2":
                    String removido = pilha.pop();
                    if (removido == null) System.out.println("Pilha vazia.");
                    else System.out.println("Removido: " + removido);
                    break;
                case "3":
                    String topo = pilha.peek();
                    if (topo == null) System.out.println("Pilha vazia.");
                    else System.out.println("Topo: " + topo);
                    break;
                case "4":
                    List<String> todos = pilha.getAll();
                    if (todos.isEmpty()) {
                        System.out.println("Pilha vazia.");
                    } else {
                        System.out.println("Livros (do topo para a base):");
                        for (int i = todos.size() - 1; i >= 0; i--) {
                            System.out.println("- " + todos.get(i));
                        }
                    }
                    break;
                case "0":
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
