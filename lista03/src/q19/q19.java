package q19;
import java.util.Scanner;

public class q19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int numero1 = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int numero2 = scanner.nextInt();
        if (numero1 < numero2) {
            System.out.println("Ordem crescente: " + numero1 + ", " + numero2);
        } else if (numero1 > numero2) {
            System.out.println("Ordem crescente: " + numero2 + ", " + numero1);
        } else {
            System.out.println("Os números são iguais: " + numero1 + ", " + numero2);
        }
        scanner.close();
    }
}
