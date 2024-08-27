import java.util.InputMismatchException;
import java.util.Scanner;

public class LivrariaVirtual {
    private final int MAX_IMPRESSOS = 10;
    private final int MAX_ELETRONICOS = 20;
    private final int MAX_VENDAS = 50;
    private Impresso[] impressos;
    private Eletronico[] eletronicos;
    private Venda[] vendas;
    private int numImpressos;
    private int numEletronicos;
    private int numVendas;

    public LivrariaVirtual() {
        impressos = new Impresso[MAX_IMPRESSOS];
        eletronicos = new Eletronico[MAX_ELETRONICOS];
        vendas = new Venda[MAX_VENDAS];
        numImpressos = 0;
        numEletronicos = 0;
        numVendas = 0;
    }

    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("\n|----------MENU PRINCIPAL----------|");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Listar Livros");
            System.out.println("4. Listar Vendas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    livraria.cadastrarLivro(scanner);
                    break;
                case "2":
                    livraria.realizarVenda(scanner);
                    break;
                case "3":
                    livraria.listarLivros();
                    break;
                case "4":
                    livraria.listarVendas();
                    break;
                case "0":
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("[" + option + "] não é uma opção válida! Tente novamente.");
                    break;
            }
        } while (!option.equals("0"));

        scanner.close();

    }

    public void cadastrarLivro(Scanner scanner) {
        System.out.println("|----------CADASTRAR LIVRO----------|");
        System.out.println("Qual tipo de livro será cadastrado? \nDigite 1 para Impresso, 2 para Eletrônico, 3 para Ambos: ");
        String tipoLivro = scanner.nextLine();


        switch (tipoLivro) {
            case "1":
                cadastrarLivroImpresso(scanner);
                break;
            case "2":
                cadastrarLivroEletronico(scanner);
                break;
            case "3":
                cadastrarLivroImpresso(scanner);
                cadastrarLivroEletronico(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
                cadastrarLivro(scanner);
        }
    }

    private void cadastrarLivroImpresso(Scanner scanner) {
        System.out.println("|----------NOVO LIVRO IMPRESSO----------|");
        if (numImpressos < MAX_IMPRESSOS) {
            String[] entradas = inputInfoLivro(scanner);
            float frete = inputFrete(scanner);
            int estoque = inputQuantidade(scanner, "Entre a quantidade do livro em estoque: ");

            impressos[numImpressos++] = new Impresso(entradas[0], entradas[1], entradas[2], Float.parseFloat(entradas[3]), frete, estoque);
            System.out.println("Livro cadastrado com sucesso");
        } else {
            System.out.println("Quantidade máxima de livros impressos foi atingida.");
        }
    }

    private void cadastrarLivroEletronico(Scanner scanner) {
        System.out.println("|----------NOVO LIVRO ELETRÔNICO----------|");
        if (numEletronicos < MAX_ELETRONICOS) {
            String[] entradas = inputInfoLivro(scanner);
            int tamanho = inputQuantidade(scanner, "Entre o tamanho do livro eletrônico: ");

            eletronicos[numEletronicos++] = new Eletronico(entradas[0], entradas[1], entradas[2], Float.parseFloat(entradas[3]), tamanho);
            System.out.println("Livro cadastrado com sucesso");
        } else {
            System.out.println("Quantidade máxima de livros eletrônicos foi atingida.");
        }
    }

    private String[] inputInfoLivro(Scanner scanner) {
        String[] entradas = new String[4];
        System.out.println("Entre o título do livro: ");
        entradas[0] = scanner.nextLine();

        System.out.println("Entre o(s) autor(es) do livro (separados por vírgulas): ");
        entradas[1] = scanner.nextLine();

        System.out.println("Entre a editora do livro: ");
        entradas[2] = scanner.nextLine();

        while (true) {
            System.out.println("Entre o preço do livro (apenas números, ex: 100.50): ");
            String precoStr = scanner.nextLine();
            try {
                Float.parseFloat(precoStr);
                entradas[3] = precoStr;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Por favor, insira um valor válido para o preço.\n(Exemplo: 100.50)\n");
            }
        }
        return entradas;
    }

    private float inputFrete(Scanner scanner) {
        while (true) {
            System.out.println("Entre o valor do frete (apenas números, ex: 10.90): ");
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Por favor, insira um valor válido para o frete.");
            }
        }
    }

    private int inputQuantidade(Scanner scanner, String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                int quantidade = scanner.nextInt();
                scanner.nextLine();
                if (quantidade > 0) {
                    return quantidade;
                } else {
                    System.out.println("A quantidade deve ser maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira uma quantidade válida.");
                scanner.next(); // Limpa o scanner
            }
        }
    }

    public void realizarVenda(Scanner scanner) {
        if (numVendas < MAX_VENDAS) {
            System.out.println("|----------REALIZAR VENDA----------|");
            System.out.println("Entre o nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            int qtdLivros = inputQuantidade(scanner, "Entre a quantidade de livros que " + nomeCliente + " deseja comprar: ");
            Venda venda = new Venda(qtdLivros);
            venda.setCliente(nomeCliente);

            for (int i = 0; i < qtdLivros; i++) {
                System.out.println("Escolha do " + (i + 1) + "º livro:");
                System.out.println("Qual o tipo do livro que " + nomeCliente + " deseja comprar (1 - Impresso | 2 - Eletrônico): ");
                String tipoLivro = scanner.nextLine();

                switch (tipoLivro) {
                    case "1":
                        listarLivrosImpressos();
                        adicionarLivro(venda, impressos, "Digite o código do livro desejado: ", scanner, i);
                        break;
                    case "2":
                        listarLivrosEletronicos();
                        adicionarLivro(venda, eletronicos, "Digite o código do livro desejado: ", scanner, i);
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                        i--; // Retorna o índice em uma posição para refazer o laço nesse caso.
                        break;
                }
            }
            vendas[numVendas] = venda;
            numVendas++;
        } else {
            System.out.println("Quantidade máxima de vendas foi atingida.");
        }
    }

    private void adicionarLivro(Venda venda, Livro[] livros, String mensagem, Scanner scanner, int indiceLivroAdd) {
        int livroEscolhido = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println(mensagem);
            try {
                livroEscolhido = scanner.nextInt();
                scanner.nextLine();

                if (livroEscolhido > 0 && livroEscolhido <= livros.length) {
                    livroEscolhido = livroEscolhido-1; //Corrige a diferença do ID mostrado na tela para a posição do vetor.
                    venda.addLivro(livros[livroEscolhido], indiceLivroAdd);
                    entradaValida = true; //finaliza o while.
                } else {
                    System.out.println("Digite uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o scanner.
            }
        }
    }

    public void listarLivrosImpressos() {
        System.out.println("|-----|----------------------------|----------------------------|-----------------|----------|--------|----------|");
        System.out.println("| ID  | Título                     | Autores                    | Editora         | Preço    | Frete  |  Estoque  |");
        System.out.println("|-----|----------------------------|----------------------------|-----------------|----------|--------|------------|");
        for (int i = 0; i < numImpressos; i++) {
            Impresso livro = impressos[i];
            System.out.printf("| %-3d | %-26s | %-26s | %-15s | R$ %-6.2f | R$ %-4.2f | %-7d |\n",
                    i + 1, livro.getTitulo(), livro.getAutores(), livro.getEditora(),
                    livro.getPreco(), livro.getFrete(), livro.getEstoque());
        }
        System.out.println("|-----|----------------------------|----------------------------|-----------------|----------|--------|--------|");
    }

    public void listarLivrosEletronicos() {
        System.out.println("|-----|----------------------------|----------------------------|-----------------|----------|---------|");
        System.out.println("| ID  | Título                     | Autores                    | Editora         | Preço    | Tamanho |");
        System.out.println("|-----|----------------------------|----------------------------|-----------------|----------|---------|");
        for (int i = 0; i < numEletronicos; i++) {
            Eletronico livro = eletronicos[i];
            System.out.printf("| %-3d | %-26s | %-26s | %-15s | R$ %-6.2f | %-7d KB |\n",
                    i + 1, livro.getTitulo(), livro.getAutores(), livro.getEditora(),
                    livro.getPreco(), livro.getTamanho());
        }
        System.out.println("|-----|----------------------------|----------------------------|-----------------|----------|---------|");
    }

    public void listarLivros() {
        System.out.println("|----------LIVROS IMPRESSOS----------|");
        listarLivrosImpressos();
        System.out.println("|----------LIVROS ELETRÔNICOS----------|");
        listarLivrosEletronicos();
    }

    public void listarVendas() {
        System.out.println("|-----|----------------------------|---------------------------------------------------------------|");
        System.out.println("| ID  | Cliente                    | Livros                                                        |");
        System.out.println("|-----|----------------------------|---------------------------------------------------------------|");
        for (int i = 0; i < numVendas; i++) {
            Venda venda = vendas[i];
            System.out.printf("| %-3d | %-26s | %-53s |\n", i + 1, venda.getCliente(), formatLivros(venda.getLivros()));
        }
        System.out.println("|-----|----------------------------|---------------------------------------------------------------|");
    }

    private String formatLivros(Livro[] livros) {
        StringBuilder sb = new StringBuilder();
        for (Livro livro : livros) {
            if (livro != null) {
                sb.append(livro.getTitulo()).append(", ");
            }
        }
        return sb.toString().replaceAll(", $", "");
    }
}
