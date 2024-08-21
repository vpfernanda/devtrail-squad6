package q50;

import java.util.Scanner;

public class Exercicio50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de n para obter o n-ésimo termo da sequência de Fibonacci: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("O valor de n deve ser um inteiro positivo.");
        } else {

            System.out.println("O " + n + "-ésimo termo da sequência de Fibonacci é: " + fibonacci(n));
        }

        scanner.close();
    }


    public static int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}

