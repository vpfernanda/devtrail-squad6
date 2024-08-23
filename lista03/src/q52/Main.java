package q52;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int totalCasasTabuleiro = 64;
        //Como resolvemos um problema parecido em sala, espera-se um overflow com
        //int ou long. Utilizaremos um tipo de dado especial: BigInteger. Assim, comportaremos
        //a grande quantidade.
        BigInteger totalGraos = BigInteger.ZERO; //inicializando
        BigInteger graosNaCasa = BigInteger.ONE; //primeiro grão...

        // calculando total de grãos somando as quantidades em cada casa, começando por 1.
        for (int i = 1; i <= totalCasasTabuleiro; i++) {
            totalGraos = totalGraos.add(graosNaCasa);
            graosNaCasa = graosNaCasa.multiply(BigInteger.valueOf(2));
        }

        //2^64
        System.out.println("Total de grãos de arroz: " + totalGraos);

        // Quantos grãos cabem em um saco de arroz? Suponhamos que 1 milhão.
        BigInteger arrozNoSaco = BigInteger.valueOf(1_000_000);
        BigInteger totalSacos = totalGraos.divide(arrozNoSaco);

        System.out.println("Qtd de sacos de arroz: " + totalSacos);
    }

}
