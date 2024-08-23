package q46;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContagemPessoas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeHomensMaiores = 0;
        int quantidadeMulheresMaiores = 0;

        for (int i = 0; i < 200; i++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Digite o sexo da pessoa " + (i + 1) + " (M/F): ");
                    char sexo = scanner.next().toUpperCase().charAt(0);

                    if (sexo != 'M' && sexo != 'F') {
                        System.out.println("Erro: por favor, digite 'M' para masculino ou 'F' para feminino.");
                        continue;
                    }

                    System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
                    int idade = scanner.nextInt();

                    if (idade < 0) {
                        System.out.println("Erro: a idade não pode ser negativa.");
                        continue;
                    }

                    if (idade >= 18) {
                        if (sexo == 'M') {
                            quantidadeHomensMaiores++;
                        } else {
                            quantidadeMulheresMaiores++;
                        }
                    }

                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: por favor, digite um número válido para a idade.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }
        }

        System.out.println("Quantidade de homens maiores de idade: " + quantidadeHomensMaiores);
        System.out.println("Quantidade de mulheres maiores de idade: " + quantidadeMulheresMaiores);
        scanner.close();
    }
}
