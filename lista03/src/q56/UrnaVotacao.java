package q56;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UrnaVotacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int votosCandidato1 = 0, votosCandidato2 = 0, votosCandidato3 = 0;
        int votosBrancos = 0, votosTotais = 0;

        String[] candidatos = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome do candidato " + (i + 1) + ": ");
            candidatos[i] = scanner.nextLine();
        }

        System.out.println("Digite o número do candidato (1, 2, 3) ou 0 para voto em branco. Para encerrar, digite -1.");

        int voto = 0;

        do {

            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Digite seu voto: ");
                    voto = scanner.nextInt();

                    if (voto == -1) break;
                    if (voto < 0 || voto > 3) {
                        System.out.println("Erro: voto inválido. Digite 1, 2, 3 ou 0.");
                        continue;
                    }

                    switch (voto) {
                        case 1 -> votosCandidato1++;
                        case 2 -> votosCandidato2++;
                        case 3 -> votosCandidato3++;
                        case 0 -> votosBrancos++;
                    }

                    votosTotais++;
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: por favor, digite um número inteiro.");
                    scanner.next();
                }
            }
        } while (voto != -1);

        if (votosTotais > 0) {
            Double percentualCandidato1 = (votosCandidato1 / (double) votosTotais) * 100;
            Double percentualCandidato2 = (votosCandidato2 / (double) votosTotais) * 100;
            Double percentualCandidato3 = (votosCandidato3 / (double) votosTotais) * 100;
            Double percentualVotosBrancos = (votosBrancos / (double) votosTotais) * 100;

            System.out.println("Resultados da votação:");
            System.out.println(candidatos[0] + ": " + votosCandidato1 + " votos (" + String.format("%.2f", percentualCandidato1) + "%)");
            System.out.println(candidatos[1] + ": " + votosCandidato2 + " votos (" + String.format("%.2f", percentualCandidato2) + "%)");
            System.out.println(candidatos[2] + ": " + votosCandidato3 + " votos (" + String.format("%.2f", percentualCandidato3) + "%)");
            System.out.println("Votos em branco: " + votosBrancos + " votos (" + String.format("%.2f", percentualVotosBrancos) + "%)");

            int maxVotos = Math.max(votosCandidato1, Math.max(votosCandidato2, votosCandidato3));
            if (maxVotos == votosCandidato1) {
                System.out.println("Ganhador da eleição: " + candidatos[0]);
            } else if (maxVotos == votosCandidato2) {
                System.out.println("Ganhador da eleição: " + candidatos[1]);
            } else {
                System.out.println("Ganhador da eleição: " + candidatos[2]);
            }
        } else {
            System.out.println("Nenhum voto registrado.");
        }

        scanner.close();
    }
}
