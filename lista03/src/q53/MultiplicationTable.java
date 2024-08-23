package q53;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("informe um inteiro:");
        n = scanner.nextInt();

        for(int i = 1; i < 11; i++){
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        scanner.close();
    }
}
