package q62;

import java.util.Scanner;

public class Exercicio62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de linhas para a pirâmide: ");
        int numeroDeLinhas = scanner.nextInt();

        if (numeroDeLinhas <= 0) {
            System.out.println("A quantidade de linhas deve ser um número positivo.");
            scanner.close();
            return;
        }

        for (int i = 1; i <= numeroDeLinhas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%02d ", i);
            }
            System.out.println();
        }

        scanner.close();
    }
}
