package q5;

import java.util.Scanner;

public class CalculadorDivida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor inicial do débito: ");
        double valorInicial = scanner.nextDouble();

        System.out.print("Digite a quantidade de meses: ");
        int meses = scanner.nextInt();

        // Solicita a taxa de juros mensal e converte para decimal (dividindo por 100)
        System.out.print("Digite a taxa de juros mensal (%): ");
        double jurosMensais = scanner.nextDouble() / 100;

        // Fórmula de juros simples
        double valorFinal = valorInicial * (1 + (jurosMensais * meses));

        System.out.println("O valor final da dívida é: R$ " + valorFinal);

        scanner.close();
    }
}

