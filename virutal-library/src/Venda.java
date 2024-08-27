
public class Venda {
    private Livro[] livros; // Vetor de referências a objetos do tipo Livro
    private static int numVendas = 0; // Número total de vendas realizadas
    private int numero; // Número da venda
    private String cliente; // Nome do cliente que realizou a compra
    private float valor; // Valor total da venda

    // Construtor
    public Venda(int maxLivros) {
        this.livros = new Livro[maxLivros];
        this.numero = ++numVendas;
        this.valor = 0.0f; // Inicializa o valor total da venda
    }

    // -----------------------------------------------------------------------------------------addLivro-------------------------------------------------
    public void addLivro(Livro l, int index) {
        if (index >= 0 && index < livros.length) {
            livros[index] = l;
            valor += l.getPreco(); // Atualiza o valor total da venda
            if (l instanceof Impresso) {
                ((Impresso) l).atualizarEstoque(); // Atualiza o estoque se for um livro impresso
            }
        } else {
            System.out.println("Índice inválido para adicionar livro.");
        }
    }

    // ---------------------------------------------------------------------------------------listarLivros-----------------------------------------------
    public void listarLivros() {
        System.out.println("Livros na venda " + numero + ":");
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null) {
                System.out.println(livros[i].toString());
            }
        }
        System.out.println("Valor total da venda: R$ " + valor);
    }

    // -------------------------------------------------------------------------------------Getters e Setters---------------------------------------------
    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public static int getNumVendas() {
        return numVendas;
    }

    public static void setNumVendas(int numVendas) {
        Venda.numVendas = numVendas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
