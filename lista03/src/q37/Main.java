package q37;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calcular fatorial de: (digite o número)");
        int numero = scanner.nextInt();
        Fatorial fatorial = new Fatorial(numero);
        fatorial.calculaFatorial();
        System.out.println(numero+"! = "+ fatorial.getFatorial());
        scanner.close();
    }
}
