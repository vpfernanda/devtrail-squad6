package q47;

import java.util.ArrayList;
import java.util.Scanner;

public class RelatorioClinica {
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = lerDadosDosPacientes();

        exibirRelatorio(pacientes);
    }

    public static ArrayList<Paciente> lerDadosDosPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nome do paciente (ou 'fim' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Sexo (M/F): ");
            String sexo = scanner.nextLine();
            if(!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")){
                System.out.print("Caractere inválido!");
                System.exit(0);
            }

            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Altura (m): ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            pacientes.add(new Paciente(nome, sexo, peso, idade, altura));
        }
        return pacientes;
    }

    public static void exibirRelatorio(ArrayList<Paciente> pacientes) {
        int quantidadePacientes = pacientes.size();
        double somaIdadeHomens = 0;
        int quantidadeHomens = 0;
        int quantidadeMulheresComAlturaEPeso = 0;
        int quantidadePessoasIdade18a25 = 0;
        Paciente pacienteMaisVelho = null;
        Paciente mulherMaisBaixa = null;
        Paciente pacienteComMaiorIMC = null;
        double maiorIMC = 0;

        for (Paciente paciente : pacientes) {
            // Calcula a média da idade dos homens
            if (paciente.getSexo().equalsIgnoreCase("M")) {
                somaIdadeHomens += paciente.getIdade();
                quantidadeHomens++;
            }

            // Verifica se a mulher tem altura entre 1,60m e 1,70m e peso acima de 70kg
            if (paciente.getSexo().equalsIgnoreCase("F") && paciente.getAltura() >= 1.60 && paciente.getAltura() <= 1.70 && paciente.getPeso() > 70) {
                quantidadeMulheresComAlturaEPeso++;
            }

            // Verifica se a pessoa tem idade entre 18 e 25 anos
            if (paciente.getIdade() >= 18 && paciente.getIdade() <= 25) {
                quantidadePessoasIdade18a25++;
            }

            // Identifica o nome do paciente mais velho
            if (pacienteMaisVelho == null || paciente.getIdade() > pacienteMaisVelho.getIdade()) {
                pacienteMaisVelho = paciente;
            }

            // Identifica a mulher mais baixa
            if (paciente.getSexo().equalsIgnoreCase("F") && (mulherMaisBaixa == null || paciente.getAltura() < mulherMaisBaixa.getAltura())) {
                mulherMaisBaixa = paciente;
            }

            // Identifica o paciente com o maior IMC
            double imcAtual = paciente.calcularIMC();
            if (imcAtual > maiorIMC) {
                maiorIMC = imcAtual;
                pacienteComMaiorIMC = paciente;
            }
        }

        System.out.println("\nRelatório:");
        System.out.println("I - Quantidade de pacientes: " + quantidadePacientes);
        System.out.println("II - Média de idade dos homens: " + (quantidadeHomens > 0 ? (somaIdadeHomens / quantidadeHomens) : 0));
        System.out.println("III - Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg: " + quantidadeMulheresComAlturaEPeso);
        System.out.println("IV - Quantidade de pessoas com idade entre 18 e 25: " + quantidadePessoasIdade18a25);
        System.out.println("V - Nome do paciente mais velho: " + obterNomePacienteOuNenhum(pacienteMaisVelho));
        System.out.println("VI - Nome da mulher mais baixa: " + obterNomePacienteOuNenhum(mulherMaisBaixa));
        System.out.println("VII - Nome do paciente com o maior IMC: " + obterNomePacienteOuNenhum(pacienteComMaiorIMC));
    }

    // Método para retornar o nome do paciente ou "Nenhum" se não tiver nenhum paciente
    private static String obterNomePacienteOuNenhum(Paciente paciente) {
        if (paciente != null) {
            return paciente.getNome();
        } else {
            return "Nenhum";
        }
    }
}
