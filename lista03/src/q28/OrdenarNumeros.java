package q28;

import java.util.Scanner;

import java.util.Scanner;

public class OrdenarNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[3];

        System.out.print("Digite o primeiro número: ");
        numeros[0] = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        numeros[1] = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        numeros[2] = scanner.nextInt();

        // Primeira estrutura de decisão: Verifica se o primeiro número é maior que o segundo e os troca se for
        if (numeros[0] > numeros[1]) {
            int temp = numeros[0];
            numeros[0] = numeros[1];
            numeros[1] = temp;
        }

        // Segunda estrutura de decisão: Verifica se o segundo número é maior que o terceiro e os troca se for
        if (numeros[1] > numeros[2]) {
            int temp = numeros[1];
            numeros[1] = numeros[2];
            numeros[2] = temp;
        }

        // Terceira estrutura de decisão: Verifica novamente se o primeiro número é maior que o segundo e os troca se for
        if (numeros[0] > numeros[1]) {
            int temp = numeros[0];
            numeros[0] = numeros[1];
            numeros[1] = temp;
        }

        System.out.println("Números em ordem crescente: " + numeros[0] + ", " + numeros[1] + ", " + numeros[2]);
    }
}

