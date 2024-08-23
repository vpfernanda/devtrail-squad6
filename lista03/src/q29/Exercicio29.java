package q29;

import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a coordenada x1 do vértice superior esquerdo: ");
        int x1 = scanner.nextInt();

        System.out.println("Informe a coordenada y1 do vértice superior esquerdo: ");
        int y1 = scanner.nextInt();

        System.out.println("Informe a coordenada x2 do vértice inferior direito: ");
        int x2 = scanner.nextInt();

        System.out.println("Informe a coordenada y2 do vértice inferior direito: ");
        int y2 = scanner.nextInt();

        if (x1 == x2 && y1 == y2) {
            System.out.println("Os pontos representam um ponto.");
        } else if (y1 == y2) {
            System.out.println("Os pontos representam uma reta horizontal.");
        } else if (x1 == x2) {
            System.out.println("Os pontos representam uma reta vertical.");
        } else if (x1 < x2 && y1 > y2) {
            System.out.println("Os pontos representam um retângulo.");

            int largura = x2 - x1;
            int altura = y1 - y2;
            int area = largura * altura;
            System.out.println("Área do retângulo: " + area);
        } else {
            System.out.println("Os pontos não podem formar um retângulo.");
            scanner.close();
            return;
        }

        System.out.println("Digite a coordenada x do ponto: ");
        int x = scanner.nextInt();

        System.out.println("Digite a coordenada y do ponto: ");
        int y = scanner.nextInt();

        if (x < x1 && y > y1) {
            System.out.println("O ponto está acima e à esquerda do retângulo.");
        } else if (x >= x1 && x <= x2 && y > y1) {
            System.out.println("O ponto está acima do retângulo.");
        } else if (x > x2 && y > y1) {
            System.out.println("O ponto está acima e à direita do retângulo.");
        } else if (x < x1 && y < y2) {
            System.out.println("O ponto está embaixo e à esquerda do retângulo.");
        } else if (x >= x1 && x <= x2 && y < y2) {
            System.out.println("O ponto está embaixo do retângulo.");
        } else if (x > x2 && y < y2) {
            System.out.println("O ponto está embaixo e à direita do retângulo.");
        } else if (x < x1 && y >= y2 && y <= y1) {
            System.out.println("O ponto está à esquerda do retângulo.");
        } else if (x > x2 && y >= y2 && y <= y1) {
            System.out.println("O ponto está à direita do retângulo.");
        } else if (x > x1 && x < x2 && y < y1 && y > y2) {
            System.out.println("O ponto está dentro do retângulo.");
        } else {
            System.out.println("O ponto está na linha do retângulo.");
        }

        scanner.close();
    }
}
