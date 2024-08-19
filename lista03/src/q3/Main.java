package q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de alunos homens: ");
        int maleStudents = scanner.nextInt();
        System.out.println("Digite a quantidade de alunas mulheres: ");
        int femStudents = scanner.nextInt();
        float femPercent, malePercent, total;
        total = maleStudents + femStudents;
        femPercent = ((float)femStudents/total)*100;
        malePercent = ((float)maleStudents/total)*100;
        System.out.printf("\nPorcentagem de alunos homens: %.2f %%",malePercent);
        System.out.printf("\nPorcentagem de alunas mulheres: %.2f %%",femPercent);
    }


}
