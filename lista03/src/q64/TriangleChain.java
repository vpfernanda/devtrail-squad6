package q64;

import java.util.Scanner;

public class TriangleChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity;
        String row;

        System.out.println("informe a quantidade de triângulos:");
        quantity = scanner.nextInt();

        for(int i = 1; i <= quantity; i++){
            for(int j = 1;  j <= i; j++){
                row = "*".repeat(j);
                System.out.println(row);
            }
            System.out.println("");
        }
    }
}
