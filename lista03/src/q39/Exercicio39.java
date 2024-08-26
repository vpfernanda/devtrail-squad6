package q39;

import java.util.Scanner;

public class Exercicio39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para verificar se é perfeito: ");
        int numero = scanner.nextInt();

        if (ehNumeroPerfeito(numero)) {
            System.out.println(numero + " é um número perfeito.");
        } else {
            System.out.println(numero + " não é um número perfeito.");
        }

        scanner.close();
    }

    public static boolean ehNumeroPerfeito(int numero) {
        if (numero <= 1) {
            return false;
        }

        int somaDivisores = 0;

        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                somaDivisores += i;
            }
        }


        return somaDivisores == numero;
    }
}
