package q25;

public class q25 {

    public static void main(String[] args) {
        System.out.println(ehHorarioValido(23, 59, 59)); // true
        System.out.println(ehHorarioValido(24, 0, 0));   // false (hora inválida)
        System.out.println(ehHorarioValido(10, 60, 0));  // false (minuto inválido)
        System.out.println(ehHorarioValido(10, 30, 60)); // false (segundo inválido)
    }
    public static boolean ehHorarioValido(int horas, int minutos, int segundos) {
        if (horas < 0 || horas > 23) {
            return false;
        }
        if (minutos < 0 || minutos > 59) {
            return false;
        }
        if (segundos < 0 || segundos > 59) {
            return false;
        }
        return true;
    }
}
