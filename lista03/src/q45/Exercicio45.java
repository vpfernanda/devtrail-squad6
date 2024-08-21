package q45;

import java.util.Scanner;

public class Exercicio45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanhoLista = 100;
        int maiorValor = Integer.MIN_VALUE;

        System.out.println("Digite " + tamanhoLista + " números:");


        for (int i = 0; i < tamanhoLista; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int numero = scanner.nextInt();


            if (numero > maiorValor) {
                maiorValor = numero;
            }
        }


        System.out.println("O maior valor é: " + maiorValor);

        scanner.close();
    }
}
