package q34;

import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int numeroAleatorio;
        Random random = new Random();
        TreeSet<Integer> numerosSorteados = new TreeSet<>();
        //Preenche um TreeSet com 50 números sorteados de 1 a 100.
        while(numerosSorteados.size()<50){
            numeroAleatorio = random.nextInt(99)+1;
            numerosSorteados.add(numeroAleatorio);
        }
        //TreeSet mantém ordenado e não permite valores duplicados.
        //Podemos agora imprimir o conteúdo do TreeSet.
        for(Integer i : numerosSorteados){
            System.out.printf(i+" ");
        }

    }

}
