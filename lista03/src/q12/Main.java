package q12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] notas =  new double[3];
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

        double media = somaNotas/3.0;
        String mensagem="";

        if(media>=7.0)
            mensagem ="O aluno está aprovado";
        else if(media<7.0 && media>=5.0)
            mensagem ="O aluno está de recuperação";
        else if(media<5.0)
            mensagem ="O aluno está reprovado";

        System.out.println(mensagem);
        scanner.close();

    }
}
