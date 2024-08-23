package q21;
import java.util.Scanner;

public class q21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();
        System.out.print("Digite o cargo do funcionário (Diretoria, Gerência, Operacional): ");
        String cargo = scanner.next();
        double emprestimo = 0;
        if (cargo.equalsIgnoreCase("Diretoria")) {
            emprestimo = salario * 0.30;
        } else if (cargo.equalsIgnoreCase("Gerência")) {
            emprestimo = salario * 0.25;
        } else if (cargo.equalsIgnoreCase("Operacional")) {
            emprestimo = salario * 0.20;
        } else {
            System.out.println("Cargo inválido.");
            scanner.close();
            return;
        }
        System.out.printf("O valor do empréstimo possível é: R$ %.2f%n", emprestimo);
        scanner.close();
    }
}
