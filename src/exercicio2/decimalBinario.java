package exercicio2;

import java.util.Scanner;
import java.util.Stack;

public class decimalBinario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();

        System.out.print("Digite um número inteiro: ");
        int numero = sc.nextInt();

        if (numero == 0) {
            System.out.println("Binário: 0");
            return;
        }

        // Enquanto o número for maior que 0, divide por 2 e guarda o resto na pilha
        int n = numero;
        while (n > 0) {
            int resto = n % 2;
            pilha.push(resto);
            n = n / 2;
        }

        // Desempilha e exibe os restos — forma o número binário
        System.out.print("Binário: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }

        System.out.println(); // quebra de linha
        sc.close();
    }
}
