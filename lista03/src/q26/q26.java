package q26;
import java.util.Scanner;

public class q26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro horário (horas minutos segundos):");
        int horas1 = scanner.nextInt();
        int minutos1 = scanner.nextInt();
        int segundos1 = scanner.nextInt();
        System.out.println("Digite o segundo horário (horas minutos segundos):");
        int horas2 = scanner.nextInt();
        int minutos2 = scanner.nextInt();
        int segundos2 = scanner.nextInt();
        scanner.close();
        int diferenca = calcularDiferencaEmSegundos(horas1, minutos1, segundos1, horas2, minutos2, segundos2);
        System.out.println("A diferença entre os horários é: " + diferenca + " segundos.");
    }
    private static int calcularDiferencaEmSegundos(int horas1, int minutos1, int segundos1, int horas2, int minutos2, int segundos2) {
        int segundosTotais1 = horas1 * 3600 + minutos1 * 60 + segundos1;
        int segundosTotais2 = horas2 * 3600 + minutos2 * 60 + segundos2;
        return Math.abs(segundosTotais1 - segundosTotais2);
    }
}

