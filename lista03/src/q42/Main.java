package q42;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        //usaremos um arraylist para armazenar os grupos de 3 números randomicos.
        ArrayList<TreeSet<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            //usaremos treeset para cada grupo, assim teremos os números ordenados automaticamente.
            TreeSet<Integer> grupo = new TreeSet<>();
            while (grupo.size() < 3) {
                int numeroRandomico = random.nextInt(60); // Limite exclusivo, logo, até 59.
                grupo.add(numeroRandomico);
            }
            arrayList.add(grupo);
        }

        // exibe os TreeSets do arrayList
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Grupo "+(i+1)+": "+arrayList.get(i));
        }

    }
}
