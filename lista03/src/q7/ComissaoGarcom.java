package q7;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ComissaoGarcom {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o valor da despesa do cliente: ");
            Double valorDespesa = scanner.nextDouble();

            if (valorDespesa < 0) {
                throw new IllegalArgumentException("O valor da despesa não pode ser negativo.");
            }

            Double comissao = valorDespesa * 0.10;
            System.out.printf("A comissão do garçom é de: R$ %.2f%n", comissao);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite um número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}