package q40;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GrupoPessoas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadePessoas = 0;
        boolean entradaValida = false;

        while(!entradaValida) {
            try{
                System.out.println("Digite a quantidade de pessoas: ");
                quantidadePessoas = scanner.nextInt();
                if (quantidadePessoas <= 0) {
                    System.out.println("Erro: a quantidade de pessoas deve ser maior que zero.");
                }else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: por favor, digite um número inteiro.");
                scanner.next();
            }
        }

        int somaIdades = 0;
        int maiorIdade = Integer.MIN_VALUE;
        int menorIdade = Integer.MAX_VALUE;
        int quantidadeMaioresIdade = 0;

        for (int i = 0; i < quantidadePessoas; i++){
            entradaValida = false;
            while (!entradaValida) {
                try{
                    System.out.println("Digite a idade da pessoa " + (i + 1) + ": ");
                    int idade = scanner.nextInt();
                    if(idade < 0){
                        System.out.println("Erro: a idade não pode ser negativa. ");
                    } else {
                        somaIdades += idade;
                        if(idade > maiorIdade) maiorIdade = idade;
                        if(idade < menorIdade) menorIdade = idade;
                        if(idade >= 18) quantidadeMaioresIdade++;
                        entradaValida = true;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Erro: por favor, digite um número inteiro.");
                    scanner.next();
                }
            }
        }

        Double mediaIdades = ((double) somaIdades) / quantidadePessoas;

        System.out.printf("Média das idades: %.2f%n", mediaIdades);
        System.out.println("Maior idade: " + maiorIdade);
        System.out.println("Menor idade: " + menorIdade);
        System.out.println("Quantidade de maiores de idade: " + quantidadeMaioresIdade);

        scanner.close();
    }

}
