package q35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Raffle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity;
        int rangeMin;
        int rangeMax;
        List<Integer> randomNumbers;


        System.out.println("informe a quatidade de números a sortear:");
        quantity = scanner.nextInt();
        System.out.println("informe o início da faixa do sorteio:");
        rangeMin = scanner.nextInt();
        System.out.println("informe o fim da faixa do sorteio:");
        rangeMax = scanner.nextInt();

        randomNumbers = getUniqueRandom(rangeMin,rangeMax,quantity);

        System.out.println("números sorteados:"+ randomNumbers);
    }

    private static List<Integer> getUniqueRandom(int min, int max, int n) {
        if (n > (max - min + 1)){
            throw new IllegalArgumentException("A quantidade de números não pode ser maior que a faixa");
        } else if (max < min){
            throw new IllegalArgumentException("O fim da faixa não pode ser menor que o início");
        }

        List<Integer> numbers = new ArrayList<>();
        for(int i = min; i <= max; i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.subList(0,n);
    }
}
