package q13;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Exercicio13 {
    public static void main(String[] args) {
        double[] notas = new double[3];
        double somaNotas = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre as notas do aluno: ");
        for (int i = 0; i < notas.length; i++) {
            while (true) {
                try {
                    System.out.println("Nota " + (i + 1) + ": ");
                    notas[i] = scanner.nextDouble();
                    somaNotas += notas[i];
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Por favor, entre um valor numérico para a nota.");
                    scanner.next();
                }
            }
        }

        double media = somaNotas / 3.0;
        String mensagem;

        if (media >= 7.0) {
            mensagem = "O aluno está aprovado.";
        } else if (media >= 5.0) {
            System.out.println("O aluno está de recuperação. Deseja fazer a prova final? (S/N)");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("S")) {
                double notaFinal;
                while (true) {
                    try {
                        System.out.println("Entre a nota da prova final: ");
                        notaFinal = scanner.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Por favor, entre um valor numérico para a nota.");
                        scanner.next();
                    }
                }

                media = (media + notaFinal) / 2.0;
                if (media >= 5.0) {
                    mensagem = "O aluno está aprovado na prova final.";
                } else {
                    mensagem = "O aluno está reprovado após a prova final.";
                }
            } else {
                mensagem = "O aluno está reprovado.";
            }
        } else {
            mensagem = "O aluno está reprovado.";
        }

        System.out.println(mensagem);
        scanner.close();
    }
}
