package q43;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Media500Valores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double soma =  0.0;

        for (int i = 0; i < 500; i++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Digite o valor " + (i + 1) + ": ");
                    Double valor = scanner.nextDouble();
                    soma += valor;
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: por favor, digite um número válido.");
                    scanner.next();
                }
            }
        }

        Double media = soma / 500;
        System.out.printf("A média aritmética é: %.2f%n", media);
        scanner.close();
    }
}