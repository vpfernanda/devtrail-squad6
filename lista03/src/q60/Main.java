package q60;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor da dívida. R$: ");
        double valor = scanner.nextDouble();
        System.out.println("Digite a taxa de correção (% ao mês): ");
        double taxa = scanner.nextDouble();
        System.out.println("Digite por quantos anos deseja calcular: ");
        int anosACalcular = scanner.nextInt();
        int anoInicial = 2007;
        CalculoDivida calculo = new CalculoDivida(valor, taxa, anoInicial);
        Month mes;

        // Variaveis p formatação das colunas
        int larguraAno = 6;
        int larguraMes, larguraValor;

        //Define algumas larguras para comportar melhor a depender do range do valor.
        //Valores maiores ocupam mais espaço :-)
        if(valor<=100){
            larguraMes = larguraValor= 6;
        }
        else if(valor>100 && valor<1000){
            larguraMes = larguraValor= 7;
        }
        else if(valor>1000 && valor<5000){
            larguraMes = larguraValor= 8;
        }
        else
            larguraMes = larguraValor= 10;


        // Primeira linha.
        System.out.printf("| %-" + larguraAno + "s |", "ANOS");
        for (int i = 1; i <= 12; i++) {
            mes = Month.of(i);
            System.out.printf(" %-" + larguraMes + "s |", mes.getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")));
        }
        System.out.println();

        // Dados da tabela
        for (int i = 0; i < anosACalcular; i++) {
            System.out.printf("| %-" + larguraAno + "d |", anoInicial + i);
            for (int j = 0; j < 12; j++) {
                if(i!=0 || j!=0)
                    calculo.aplicaCorrecao();
                System.out.printf(" %-" + larguraValor + ".2f |", calculo.getValorAtualizado());
            }
            System.out.println();
        }

        scanner.close();
    }
}
