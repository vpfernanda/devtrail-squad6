package q14;
import java.util.Scanner;
public class q14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de um mês: ");
        String mes = scanner.nextLine();
        mes = mes.toLowerCase();  // Converte o nome do mês para minúsculas para facilitar a comparação
        if (mes.equals("janeiro")) {
            System.out.println("O número equivalente é 1.");
        } else if (mes.equals("fevereiro")) {
            System.out.println("O número equivalente é 2.");
        } else if (mes.equals("março")) {
            System.out.println("O número equivalente é 3.");
        } else if (mes.equals("abril")) {
            System.out.println("O número equivalente é 4.");
        } else if (mes.equals("maio")) {
            System.out.println("O número equivalente é 5.");
        } else if (mes.equals("junho")) {
            System.out.println("O número equivalente é 6.");
        } else if (mes.equals("julho")) {
            System.out.println("O número equivalente é 7.");
        } else if (mes.equals("agosto")) {
            System.out.println("O número equivalente é 8.");
        } else if (mes.equals("setembro")) {
            System.out.println("O número equivalente é 9.");
        } else if (mes.equals("outubro")) {
            System.out.println("O número equivalente é 10.");
        } else if (mes.equals("novembro")) {
            System.out.println("O número equivalente é 11.");
        } else if (mes.equals("dezembro")) {
            System.out.println("O número equivalente é 12.");
        } else {
            System.out.println("Nome de mês inválido.");
        }
        scanner.close();
    }
}
