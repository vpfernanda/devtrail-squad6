package q61;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height;
        String row;

        System.out.println("informe o tamanho:");
        height = scanner.nextInt();
        for(int i = 1; i <= height; i++){
            row = "*".repeat(i);
            System.out.println(row);
        }
    }
}
