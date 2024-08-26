package q60;

public class CalculoDivida {
    double valorInicialDivida;
    double valorAtualizado;
    double taxaCorrecao;
    int anoInicial;

    public CalculoDivida(double valorInicialDivida, double taxaCorrecao, int anoInicial) {
        this.valorInicialDivida = valorInicialDivida;
        this.taxaCorrecao = taxaCorrecao;
        this.anoInicial = anoInicial;
        this.valorAtualizado = valorInicialDivida;
    }

    public void aplicaCorrecao(){
        valorAtualizado *=(1+taxaCorrecao/100);
    }

    public double getValorAtualizado() {
        return valorAtualizado;
    }


}
