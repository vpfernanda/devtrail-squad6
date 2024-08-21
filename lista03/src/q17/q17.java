package q17;

import java.util.Scanner;

public class q17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o número do mês: ");
        int mes = scanner.nextInt();
        String nomeMes = "";
        String trimestre = "";
        String signo = "";
        boolean dataValida = false;
        switch (mes) {
            case 1:
                nomeMes = "Janeiro";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "1º trimestre";
                    signo = (dia <= 19) ? "Capricórnio" : "Aquário";
                }
                break;
            case 2:
                nomeMes = "Fevereiro";
                if (dia >= 1 && dia <= 28) {
                    dataValida = true;
                    trimestre = "1º trimestre";
                    signo = (dia <= 18) ? "Aquário" : "Peixes";
                }
                break;
            case 3:
                nomeMes = "Março";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "1º trimestre";
                    signo = (dia <= 20) ? "Peixes" : "Áries";
                }
                break;
            case 4:
                nomeMes = "Abril";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "2º trimestre";
                    signo = (dia <= 19) ? "Áries" : "Touro";
                }
                break;
            case 5:
                nomeMes = "Maio";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "2º trimestre";
                    signo = (dia <= 20) ? "Touro" : "Gêmeos";
                }
                break;
            case 6:
                nomeMes = "Junho";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "2º trimestre";
                    signo = (dia <= 20) ? "Gêmeos" : "Câncer";
                }
                break;
            case 7:
                nomeMes = "Julho";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "3º trimestre";
                    signo = (dia <= 22) ? "Câncer" : "Leão";
                }
                break;
            case 8:
                nomeMes = "Agosto";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "3º trimestre";
                    signo = (dia <= 22) ? "Leão" : "Virgem";
                }
                break;
            case 9:
                nomeMes = "Setembro";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "3º trimestre";
                    signo = (dia <= 22) ? "Virgem" : "Libra";
                }
                break;
            case 10:
                nomeMes = "Outubro";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "4º trimestre";
                    signo = (dia <= 22) ? "Libra" : "Escorpião";
                }
                break;
            case 11:
                nomeMes = "Novembro";
                if (dia >= 1 && dia <= 30) {
                    dataValida = true;
                    trimestre = "4º trimestre";
                    signo = (dia <= 21) ? "Escorpião" : "Sagitário";
                }
                break;
            case 12:
                nomeMes = "Dezembro";
                if (dia >= 1 && dia <= 31) {
                    dataValida = true;
                    trimestre = "4º trimestre";
                    signo = (dia <= 21) ? "Sagitário" : "Capricórnio";
                }
                break;
            default:
                nomeMes = "Inválido";
                break;
        }
        if (dataValida) {
            System.out.println("Data válida: " + dia + " de " + nomeMes + " (" + trimestre + ")");
            System.out.println("Signo: " + signo);
        } else {
            System.out.println("Data inválida.");
        }
        scanner.close();
    }
}
