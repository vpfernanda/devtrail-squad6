package q49;

public class SequenciaFibonacci {
    public static void main(String[] args) {
        int count = 50;
        int num1 = 1;
        int num2 = 1;

        System.out.print(num1 + " " + num2 + " ");

        for (int i = 3; i <= count; i++) {
            int proximoNum = num1 + num2;
            System.out.print(proximoNum + " ");
            num1 = num2; // Atualiza num1 para o próximo ciclo
            num2 = proximoNum; // Atualiza num2 para o próximo ciclo
        }
    }
}
