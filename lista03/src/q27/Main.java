package q27;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[3];

        //Preenche o vetor com input do usuário
        for(int i=0; i<numeros.length; i++){
            System.out.println("Digite o "+(i+1)+"º numero: ");
            numeros[i] = scanner.nextInt();
        }

        //São todos iguais?
        if(numeros[0]==numeros[1]&&numeros[1]==numeros[2]){
            System.out.println("Os números são iguais");
        } //se não, cabe a comparação.
        else{
            int maior = numeros[0];
            for(int j=1; j<numeros.length; j++){
                if(numeros[j]>maior)
                    maior = numeros[j];
            }
            System.out.println("O maior número é: "+maior);
        }

        scanner.close();
    }


}
