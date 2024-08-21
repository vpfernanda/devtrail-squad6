package q57;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exercicio57 {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate dataInicio = obterData(scanner, "início");
        LocalDate dataFim = obterData(scanner, "fim");

        if (dataInicio.isAfter(dataFim)) {
            System.out.println("A data de início não pode ser depois da data de fim.");
        } else {
            exibirDatasEntre(dataInicio, dataFim);
        }

        scanner.close();
    }

    private static LocalDate obterData(Scanner scanner, String tipoData) {
        while (true) {
            System.out.print("Digite a data de " + tipoData + " (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            try {
                return LocalDate.parse(dataStr, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");
            }
        }
    }

    private static void exibirDatasEntre(LocalDate inicio, LocalDate fim) {

        LocalDate dataAtual = inicio.plusDays(1);

        LocalDate dataLimite = fim.minusDays(1);

        if (dataAtual.isAfter(dataLimite)) {
            System.out.println("Não há datas entre " + FORMATTER.format(inicio) + " e " + FORMATTER.format(fim) + ".");
        } else {
            System.out.println("Datas entre " + FORMATTER.format(inicio) + " e " + FORMATTER.format(fim) + ":");
            while (!dataAtual.isAfter(dataLimite)) {
                System.out.println(FORMATTER.format(dataAtual));
                dataAtual = dataAtual.plusDays(1);
            }
        }
    }
}

