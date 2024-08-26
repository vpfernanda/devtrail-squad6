package q44;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        double avg;
        List<Integer> numbers = new ArrayList<>();

        System.out.println("informe a quantidade de valores:");
        length = scanner.nextInt();

        for (int i = 0; i < length; i++) {
            System.out.println("informe o " + (i + 1) + "º valor:");
            numbers.add(scanner.nextInt());
        }

        avg = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("média aritmética: " + avg);
    }
}
