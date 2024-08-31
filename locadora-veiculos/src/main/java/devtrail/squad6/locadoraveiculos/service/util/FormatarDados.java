package devtrail.squad6.locadoraveiculos.service.util;

public class FormatarDados {
    public static String formatarCpf(String cpf) {
        String numerosCpf = cpf.replaceAll("[^0-9]", "");

        if (numerosCpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }

        return String.format("%s.%s.%s-%s",// Formata o CPF no padrão comum (XXX.XXX.XXX-XX)
                numerosCpf.substring(0, 3),
                numerosCpf.substring(3, 6),
                numerosCpf.substring(6, 9),
                numerosCpf.substring(9));
    }
}
