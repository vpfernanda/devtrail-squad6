package q10;

import java.util.Scanner;

public class ValorEmprestimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do salário bruto: ");
        double salarioBruto = scanner.nextDouble();

        System.out.print("Digite o valor dos descontos: ");
        double descontos = scanner.nextDouble();

        System.out.print("Digite o valor do empréstimo solicitado: ");
        double valorEmprestimo = scanner.nextDouble();

        // Calcula o salário subtraindo os descontos
        double salarioLiquido = salarioBruto - descontos;

        // Calcula o limite do empréstimo, sendo 30% do salário
        double limiteEmprestimo = salarioLiquido * 0.30;

        // Verifica se o valor do empréstimo solicitado está dentro do limite permitido
        if (valorEmprestimo <= limiteEmprestimo) {
            System.out.println("Empréstimo aprovado.");
        } else {
            System.out.println("Empréstimo negado.");
        }

        scanner.close();
    }
}

