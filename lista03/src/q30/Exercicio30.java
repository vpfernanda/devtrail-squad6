package q30;

import java.util.Scanner;

public class Exercicio30 {

    public static class InputHandler {
        private static final Scanner scanner = new Scanner(System.in);

        public static int getIntInput(String prompt) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scanner.next();
                System.out.print(prompt);
            }
            return scanner.nextInt();
        }
    }

    private static int[] readRectangleCoords(String name) {
        int[] coords = new int[4];
        System.out.println("Digite as coordenadas do " + name + ":");
        coords[0] = InputHandler.getIntInput("Coordenada X do vértice 1: ");
        coords[1] = InputHandler.getIntInput("Coordenada Y do vértice 1: ");
        coords[2] = InputHandler.getIntInput("Coordenada X do vértice 2: ");
        coords[3] = InputHandler.getIntInput("Coordenada Y do vértice 2: ");

        int x1 = Math.min(coords[0], coords[2]);
        int x2 = Math.max(coords[0], coords[2]);
        int y1 = Math.max(coords[1], coords[3]);
        int y2 = Math.min(coords[1], coords[3]);

        return new int[] {x1, y1, x2, y2};
    }

    public static void main(String[] args) {
        int[] rect1 = readRectangleCoords("primeiro retângulo");
        int[] rect2 = readRectangleCoords("segundo retângulo");

        int x1Min1 = rect1[0], y1Max1 = rect1[1];
        int x1Max1 = rect1[2], y1Min1 = rect1[3];
        int x2Min2 = rect2[0], y2Max2 = rect2[1];
        int x2Max2 = rect2[2], y2Min2 = rect2[3];

        if (x1Min1 >= x1Max1 || y1Min1 >= y1Max1 || x2Min2 >= x2Max2 || y2Min2 >= y2Max2) {
            System.out.println("Pelo menos um dos retângulos é inválido.");
            return;
        }

        if (x1Max1 < x2Min2 || x1Min1 > x2Max2 || y1Max1 < y2Min2 || y1Min1 > y2Max2) {
            System.out.println("Os retângulos não se sobrepõem.");
        } else {
            System.out.println("Os retângulos se sobrepõem em algum lugar.");
        }
    }
}

