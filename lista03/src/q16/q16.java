package q16;
import java.util.Scanner;

public class q16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o número do mês: ");
        int mes = scanner.nextInt();
        String nomeMes = "";
        String trimestre = "";
        boolean dataValida = false;
        switch (mes) {
            case 1:
                nomeMes = "Janeiro";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "1º trimestre";
                }
                break;
            case 2:
                nomeMes = "Fevereiro";
                if (dia >= 1 && dia <= 28) {
                    dataValida = true;
                    trimestre = "1º trimestre";
                }
                break;
            case 3:
                nomeMes = "Março";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "1º trimestre";
                }
                break;
            case 4:
                nomeMes = "Abril";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "2º trimestre";
                }
                break;
            case 5:
                nomeMes = "Maio";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "2º trimestre";
                }
                break;
            case 6:
                nomeMes = "Junho";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "2º trimestre";
                }
                break;
            case 7:
                nomeMes = "Julho";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "3º trimestre";
                }
                break;
            case 8:
                nomeMes = "Agosto";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "3º trimestre";
                }
                break;
            case 9:
                nomeMes = "Setembro";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "3º trimestre";
                }
                break;
            case 10:
                nomeMes = "Outubro";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "4º trimestre";
                }
                break;
            case 11:
                nomeMes = "Novembro";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "4º trimestre";
                }
                break;
            case 12:
                nomeMes = "Dezembro";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "4º trimestre";
                }
                break;
            default:
                nomeMes = "Inválido";
                break;
        }

        if (dataValida) {
            System.out.println("Data válida: " + dia + " de " + nomeMes + " (" + trimestre + ")");
        } else {
            System.out.println("Data inválida.");
        }
        scanner.close();
    }
}
