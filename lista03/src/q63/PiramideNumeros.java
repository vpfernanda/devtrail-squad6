package q63;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PiramideNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite a quantidade de linhas: ");
                int linhas = scanner.nextInt();

                if (linhas <= 0) {
                    System.out.println("Erro: a quantidade de linhas deve ser maior que zero.");
                    continue;
                }

                for (int i = 1; i <= linhas; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: por favor, digite um número inteiro válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        scanner.close();
    }
}
