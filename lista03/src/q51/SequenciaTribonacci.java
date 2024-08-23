package q51;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SequenciaTribonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = new BigInteger("2");

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o número de termos da sequência de Tribonacci: ");
                int n = scanner.nextInt();

                if (n <= 0) {
                    System.out.println("Erro: o número de termos deve ser maior que zero.");
                    continue;
                }

                System.out.print("Sequência de Tribonacci: ");
                for (int i = 1; i <= n; i++) {
                    if (i == 1) System.out.print(a + " ");
                    else if (i == 2) System.out.print(b + " ");
                    else if (i == 3) System.out.print(c + " ");
                    else {
                        BigInteger proximo = a.add(b).add(c);
                        System.out.print(proximo + " ");
                        a = b;
                        b = c;
                        c = proximo;
                    }
                }
                System.out.println();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: por favor, digite um número inteiro válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        }

        scanner.close();
    }
}
