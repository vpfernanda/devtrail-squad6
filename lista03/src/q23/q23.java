package q23;
import java.util.Scanner;

public class q23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite o dia de nascimento da primeira pessoa: ");
        int dia1 = scanner.nextInt();
        System.out.print("Digite o mês de nascimento da primeira pessoa: ");
        int mes1 = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha
        System.out.print("Digite o nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite o dia de nascimento da segunda pessoa: ");
        int dia2 = scanner.nextInt();
        System.out.print("Digite o mês de nascimento da segunda pessoa: ");
        int mes2 = scanner.nextInt();
        if (mes1 < mes2 || (mes1 == mes2 && dia1 < dia2)) {
            System.out.println(nome1 + " faz aniversário primeiro.");
        } else if (mes2 < mes1 || (mes2 == mes1 && dia2 < dia1)) {
            System.out.println(nome2 + " faz aniversário primeiro.");
        } else {
            System.out.println("Ambas as pessoas fazem aniversário no mesmo dia.");
        }
        scanner.close();
    }
}
