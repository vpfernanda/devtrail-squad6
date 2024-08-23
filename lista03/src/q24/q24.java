package q24;
public class q24 {

    public static void main(String[] args) {
        // Exemplos de datas para teste
        System.out.println(ehDataValida(29, 2, 2024)); // true (ano bissexto)
        System.out.println(ehDataValida(29, 2, 2023)); // false (não é ano bissexto)
        System.out.println(ehDataValida(31, 4, 2023)); // false (abril tem 30 dias)
        System.out.println(ehDataValida(15, 8, 2024)); // true
    }
    public static boolean ehDataValida(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }
        int diasNoMes = obterDiasNoMes(mes, ano);
        return dia >= 1 && dia <= diasNoMes;
    }
    private static int obterDiasNoMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return ehAnoBissexto(ano) ? 29 : 28;
            default:
                return 0;
        }
    }
    private static boolean ehAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
