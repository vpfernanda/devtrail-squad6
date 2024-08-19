package q4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double total=0;
        boolean entradaValida;
        for(int i=0; i<notas.length; i++){

                entradaValida = false;

                while (!entradaValida) {
                    try {
                        System.out.println("Digite a nota nº " + (i + 1) + ":");
                        notas[i] = scanner.nextDouble();
                        total += notas[i];
                        entradaValida = true;  // Sai do loop while se a entrada for válida
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número.");
                        scanner.next();  // Limpa a entrada inválida do scanner
                    }
                }

        }
        double media = total/4;
        System.out.println("Média das notas: "+media);
        scanner.close();

    }
}
