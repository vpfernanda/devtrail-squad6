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


    LivrariaVirtual() {
        numImpressos = 0;
        numEletronicos = 0;
        numVendas = 0;
        impressos = new Impressos[MAX_IMPRESSOS];
        eletronicos = new Eletronicos[MAX_ELETRONICOS];
        vendas = new Vendas[MAX_VENDAS];
    }

    public void cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);
        String op;
        String[] entradas;
        System.out.println("|----------CADASTRAR LIVRO----------|");
        System.out.println("Qual tipo de livro será cadastrado? Digite 1 para Impresso, 2 para " +
                "Eletrônico, 3 para Ambos: ");
        op = scanner.nextLine();

        switch (op) {
            case "1": { // Impresso
                if(numImpressos<MAX_IMPRESSOS){
                    entradas = getInfoLivro();
                    float frete = inputFrete();
                    System.out.println("Entre a quantidade do livro em estoque: ");
                    int estoque = scanner.nextInt();
                    Impresso livroImpresso = new Impresso(entradas[0], entradas[1], entradas[2], Double.parseDouble(entradas[3]),
                            frete, estoque);
                    impressos[numImpressos] = livroImpresso;
                    numImpressos++;
                }
                else
                    System.out.println("Quantidade máxima de livros impressos no sistema atingida.");
                break;
            }

            case "2": { // Eletronico
                if(numEletronicos<MAX_ELETRONICOS){
                    entradas = getInfoLivro();
                    System.out.println("Entre o tamanho do livro eletrônico: ");
                    int tamanho = scanner.nextInt();
                    Eletronico livroEletronico = new Eletronico(entradas[0], entradas[1], entradas[2], Double.parseDouble(entradas[3]),
                            tamanho);
                    eletronicos[numEletronicos] = livroEletronico;
                    numEletronicos++;
                }
                else
                    System.out.println("Quantidade máxima de livros eletrônicos no sistema atingida.");
                break;
            }

            case "3": { // Ambos
                if(numEletronicos<MAX_ELETRONICOS && numImpressos<MAX_IMPRESSOS){
                    entradas = getInfoLivro();
                    float frete = inputFrete();
                    System.out.println("Entre a quantidade do livro impresso em estoque: ");
                    int estoque = scanner.nextInt();
                    System.out.println("Entre o tamanho do livro eletrônico: ");
                    int tamanho = scanner.nextInt();
                    Impresso livroImpresso = new Impresso(entradas[0], entradas[1], entradas[2], Double.parseDouble(entradas[3]),
                            frete, estoque);
                    impressos[numImpressos] = livroImpresso;
                    Eletronico livroEletronico = new Eletronico(entradas[0], entradas[1], entradas[2], Double.parseDouble(entradas[3]),
                            tamanho);
                    eletronicos[numEletronicos] = livroEletronico;
                    numImpressos++;
                    numEletronicos++;
                }
                else
                    System.out.println("Quantidade máxima de livros impressos e/ou eletrônicos no sistema atingida.");
                break;
            }

            default:
                System.out.println("Digite uma opção válida.");
                cadastrarLivro();
                break;
        }
        scanner.close();
    }


    public String[] getInfoLivro() {
        String[] entradas = new String[4];
        Scanner scanner = new Scanner(System.in);

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
                Double.parseDouble(precoStr);
                entradas[3] = precoStr;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Por favor, insira um valor válido para o preço.\n(Exemplo: 100.50)\n");
            }
        }
        scanner.close();
        return entradas;
    }

    public float inputFrete(){
        float frete = 0.0f;
        String freteStr;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Entre o valor do frete (apenas números, ex: 10.90): ");
            freteStr = scanner.next();
            try {
                frete = Float.parseFloat(freteStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Por favor, insira um valor válido para o frete.");
            }
        }
        scanner.close();
        return frete;
    }


    public void realizarVenda() {
        Scanner scanner = new Scanner(System.in);
        int qtdLivros;
        if(numVendas<MAX_VENDAS){
            System.out.println("|----------REALIZAR VENDA----------|");
            System.out.println("Entre o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            while (true) {
                System.out.println("Entre a quantidade de livros que "+nomeCliente+" deseja comprar: ");
                try {
                    qtdLivros = scanner.nextInt();
                    if(qtdLivros > 0)
                        break;
                    else
                        System.out.println("A quantidade deve ser maior que zero.");
                }
                catch (InputMismatchException e) {
                    System.out.println("Insira uma quantidade válida.\n");
                }
            }
            scanner.next();
            for(int i=0; i<qtdLivros; i++){
                System.out.println("Qual o tipo do livro que "+nomeCliente+" deseja comprar (1 - Impresso | 2 - Eletrônico): ");
                String op = scanner.nextLine();
                switch (op){
                    case "1":{
                        listarLivrosImpressos();
                        //TODO: receber o código/índice do livro selecionado, e utilizar addLivro do obj Venda.
                        numVendas++;
                        break;
                    }
                    case "2":{
                        listarLivrosEletronicos();
                        //TODO: receber o código/índice do livro selecionado, e utilizar addLivro do obj Venda.
                        numVendas++;
                        break;
                    }
                    default:
                        System.out.println("Digite uma opção válida.");
                        i--; //retorna o índice em uma posição para refazer o laço nesse caso.
                        break;
                }
            }
        }
        scanner.close();
    }

    public void listarLivrosImpressos() {
        //@TODO
    }

    public void listarLivrosEletronicos() {
        //@TODO
    }

    public void listarLivros() {
        //@TODO
    }

    public void listarVendas() {
        //@TODO
    }

    public static void main(String[] args) {
        //@TODO
    }
}
