package q11;

import java.util.Scanner;

/*11 - A partir da idade informada de um cidadão diga se:
        - ele não pode votar (idade inferior a 16), ou se
        - o voto é facultativo (idade menor ou igual a 16, ou maior ou igual a 65), ou ainda se
        - o voto é obrigatório.
*/
public class VotingAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;

        System.out.println("informe a idade do cidadão:");
        age = scanner.nextInt();

        if (age < 16) System.out.println("não pode votar");
        else if (age < 18 || age >= 65) System.out.println("facultativo");
        else System.out.println("voto orbigatório");
    }
}
