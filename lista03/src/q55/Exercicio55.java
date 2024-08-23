package q55;

import java.util.Scanner;

public class Exercicio55 {
    public static void main(String[] args) {
        final double VALOR_MENSAL = 50.00;
        final int MINUTOS_INCLUSOS = 100;
        final int MINUTOS_VAI_VAI_ADICIONAIS = 50;
        final double VALOR_MINUTO_OUTRAS_OPERADORAS = 0.65;
        final double VALOR_MINUTO_VAI_VAI = 0.20;
        final double VALOR_MINUTO_FONE_FIXO = 0.325;

        Scanner scanner = new Scanner(System.in);
        char tipoLigacao;
        int minutos;
        double saldo = VALOR_MENSAL;
        int minutosRestantes = MINUTOS_INCLUSOS + MINUTOS_VAI_VAI_ADICIONAIS;

        do {
            System.out.print("Digite o tipo de ligação (o = outras operadoras, v = Vai-Vai, f = telefone fixo): ");
            tipoLigacao = scanner.next().charAt(0);

            System.out.print("Digite a quantidade de minutos: ");
            minutos = scanner.nextInt();

            double valorAPagar = 0;
            int minutosExcedentes = 0;

            switch (tipoLigacao) {
                case 'o':
                    if (minutos > minutosRestantes) {
                        minutosExcedentes = minutos - minutosRestantes;
                        valorAPagar = minutosExcedentes * VALOR_MINUTO_OUTRAS_OPERADORAS;
                        minutosRestantes = 0;
                    } else {
                        minutosRestantes -= minutos;
                    }
                    break;

                case 'v':
                    if (minutos > minutosRestantes) {
                        minutosExcedentes = minutos - minutosRestantes;
                        valorAPagar = minutosExcedentes * VALOR_MINUTO_VAI_VAI;
                        minutosRestantes = 0;
                    } else {
                        minutosRestantes -= minutos;
                    }
                    break;

                case 'f':
                    if (minutos > minutosRestantes) {
                        minutosExcedentes = minutos - minutosRestantes;
                        valorAPagar = minutosExcedentes * VALOR_MINUTO_FONE_FIXO;
                        minutosRestantes = 0;
                    } else {
                        minutosRestantes -= minutos;
                    }
                    break;

                default:
                    System.out.println("Tipo de ligação inválido.");
                    continue;
            }

            saldo -= valorAPagar;

            System.out.printf("Saldo restante: R$ %.2f\n", saldo);
            System.out.printf("Valor a pagar: R$ %.2f\n", valorAPagar);

            System.out.print("Deseja inserir mais ligações? (s = sim, n = não): ");
        } while (scanner.next().charAt(0) == 's');

        scanner.close();
    }
}

