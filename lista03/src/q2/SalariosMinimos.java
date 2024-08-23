package q2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalariosMinimos {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Digite o valor do salário do funcionário: ");
            Double salarioFuncionario = scanner.nextDouble();

            System.out.println("Digite o valor do salário mínimo: ");
            Double salarioMinimo = scanner.nextDouble();

            if (salarioMinimo <= 0) {
                throw new ArithmeticException("O salário mínimo deve ser maior que zero.");
            }

            Double quantidadeSalarios = salarioFuncionario / salarioMinimo;
            System.out.printf("O funcionário ganha %.2f salários mínimos.%n", quantidadeSalarios);

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
