package q54;

import java.util.Locale;
import java.util.Scanner;

public class ExchangeTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float brlQuote, usdQuote, brlAmount, usdAmount;
        int option = -1;
        int subOption = -1;

        brlQuote = usdQuote = brlAmount = usdAmount = -1.0F;

        scanner.useLocale(Locale.US);

        option = menu(scanner);
        if (option == 1){
            System.out.println("(BRL) digite o valor:");
            brlAmount = readValue(scanner);

            subOption = subMenu(scanner, option);
            if (subOption == 1){
                System.out.println("(USD) digite o valor:");
                usdAmount = readValue(scanner);
                brlQuote = usdAmount / brlAmount;
                usdQuote = brlAmount / usdAmount;
            } else if (subOption == 2) {
                System.out.println(
                        "digite a cotação do Dólar:" +
                        "\n(valor em BRL, equivalente a 1 USD)"
                );
                usdQuote = readValue(scanner);
                brlQuote = 1 / usdQuote;
                usdAmount = brlAmount / usdQuote;
            }
        } else if (option == 2) {
            System.out.println("(USD) digite o valor:");
            usdAmount = readValue(scanner);

            subOption = subMenu(scanner, option);
            if (subOption == 1){
                System.out.println("(BRL) digite o valor:");
                brlAmount = readValue(scanner);
                brlQuote = usdAmount / brlAmount;
                usdQuote = brlAmount / usdAmount;
            } else if (subOption == 2) {
                System.out.println(
                        "digite a cotação do Real:" +
                        "\n(valor em USD, equivalente a 1 BRL)"
                );
                brlQuote = readValue(scanner);
                usdQuote = 1 / brlQuote;
                brlAmount = usdAmount / brlQuote;
            }
        }

        printTable(brlAmount,usdAmount,brlQuote,usdQuote);

        scanner.close();
    }

    private static void printTable(float brlAmount, float usdAmount, float brlQuote, float usdQuote) {
        System.out.printf(
                "[tabela de câmbio]%n" +
                "Valor em BRL: R$%.2f%n" +
                "Valor em USD: $%.2f%n" +
                "Cotação do Dólar: R$%.2f%n" +
                "Cotação do Real: U$%.2f%n",
                brlAmount, usdAmount, usdQuote, brlQuote
        );
    }

    private static float readValue(Scanner scan){
        float value = scan.nextFloat();

        if (value <= 0){
            throw new IllegalArgumentException("Valor não pode ser negativo ou igual a zero.");
        }

        return value;
    }

    private static int menu(Scanner scan){
        int option;
        System.out.println(
                "[menu]" +
                "\n1 - Iformar valor inicial em BRL" +
                "\n2 - Informar valor inicial em USD"
        );
        option = scan.nextInt();

        if (option != 1 && option != 2  ){
            throw new IllegalArgumentException("Opção '" + option + "' é inválida");
        }

        return option;
    }

    private static int subMenu(Scanner scan, int option){
        int subOption;
        System.out.println(
                "[sub-menu]"
                + "\n1 - Iformar valor final em " + ((option == 1) ? "USD" : "BRL")
                + "\n2 - Informar a cotação do " + ((option == 1) ? "Dólar" : "Real")
        );
        subOption = scan.nextInt();

        if (subOption != 1 && subOption != 2  ){
            throw new IllegalArgumentException("Opção '" + subOption + "' é inválida");
        }

        return subOption;
    }
}
