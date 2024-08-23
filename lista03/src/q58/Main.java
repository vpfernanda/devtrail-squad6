package q58;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate data = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Tenta receber o input até a data digitada ser válida.
        while (data == null) {
            try {
                System.out.println("Entre uma data no formato DD/MM/AAAA: ");
                //Usuário entra a data.
                String dataString = scanner.nextLine();
                // Tenta converter a string digitada em LocalDate
                data = LocalDate.parse(dataString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Por favor, entre uma data no formato DD/MM/AAAA.");
            }
        }
        //Input de dias a somar
        System.out.println("Entre uma quantidade de dias: ");
        int diasASomar = scanner.nextInt();
        //Soma os dias
        LocalDate novaData = data.plusDays(diasASomar);

        //Exibição do resultado
        System.out.println("A data "+ data.format(formatter)+ " somada a "+diasASomar+" dias é: " +novaData.format(formatter));

        scanner.close();
    }
}
