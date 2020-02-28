package br.com.treinaweb.estruturadados.listasligadas;

public class ListaLigada<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaLigada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void inserir(T elemento){
        No<T> novoNo = new No<T>(elemento);
        if(estaVazia()){
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.primeiroNo.setProximo(novoNo);
            this.ultimoNo = novoNo;
        }
    }

    public boolean estaVazia(){
        return this.tamanho == 0;
    }

    public int tamanho(){
        return this.tamanho;
    }
}
