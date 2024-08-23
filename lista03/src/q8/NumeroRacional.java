package q8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumeroRacional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerador = 0, denominador = 0;
        boolean entradaValida = false;

        while(!entradaValida) {
            try {
                System.out.println("Digite o numerador: ");
                numerador = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: por favor, digite um número inteiro.");
                scanner.next();
            }
        }

        entradaValida = false;

        while(!entradaValida) {
            try {
                System.out.println("Digite o denominador: ");
                denominador = scanner.nextInt();

                if (denominador == 0) {
                    System.out.println("Erro: o denominador não pode ser zero");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: por favor, digite um número inteiro");
                scanner.next();
            }
        }

        Double resultado = ((double) numerador) / denominador;
        System.out.printf("O número real é: %.2f%n", resultado);

        scanner.close();
    }
}
