package q48;

import java.util.Scanner;

public class SistemaAvaliacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número total de aulas da disciplina: ");
        int totalAulas = scanner.nextInt();

        // Calcula o limite de faltas permitido (25% do total de aulas) segundo o sistema de avaliação da FAESA
        int limiteFaltas = (int) (totalAulas * 0.25);

        System.out.print("Informe o número de faltas: ");
        int faltas = scanner.nextInt();

        System.out.print("Informe a quantidade de notas: ");
        int quantidadeNotas = scanner.nextInt();

        double soma = 0;

        for (int i = 1; i <= quantidadeNotas; i++) {
            System.out.print("Informe a nota " + i + ": ");
            double nota = scanner.nextDouble();
            soma += nota;
        }

        double media = soma / quantidadeNotas;
        System.out.println("Média: " + media);

        if (faltas > limiteFaltas) {
            System.out.println("Resultado: Reprovado por faltas");
        } else if (media >= 7) {
            System.out.println("Resultado: Aprovado");
        } else {
            System.out.println("Resultado: Reprovado por nota");
        }

        scanner.close();
    }
}
