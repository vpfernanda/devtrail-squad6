package q41;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        System.out.println("tente adivinhar o número secreto:");
        while (true) {
            System.out.println("- informe um número, de 1 a 100");
            guess = scanner.nextInt();

            if (secretNumber == guess){
                System.out.println("parabéns, você acertou!");
                break;
            }else if (secretNumber < guess) {
                System.out.println(
                        "tente novamente!" +
                        "\ndica: o número secreto é menor."
                );
            } else {
                System.out.println(
                        "tente novamente!" +
                        "\ndica: o número secreto é maior."
                );
            }
        }
    }
}
