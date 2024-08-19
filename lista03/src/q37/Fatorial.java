package q37;

public class Fatorial {
    int numero;
    long fatorial;

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Fatorial(int numero){
        this.numero = numero;
        fatorial = 1;
    }

    public long getFatorial() {
        return fatorial;
    }

    public void calculaFatorial(){
        for(int i=numero; i>1; i--){
            fatorial *= i;
        }
    }
}
