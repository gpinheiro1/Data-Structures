package br.com.treinaweb.estruturadados.vetores;

import java.util.Arrays;

public class Vetor<T> {
    private Object [] elementos;
    private int posicao;

    public Vetor (int capacidade) {
        this.elementos = new Object[capacidade];
        this.posicao = 0;
    }

    public Vetor () {
        this.elementos = new Object[3];
        this.posicao++;
    }

    @Override
    public String toString() {
        return "Vetor[elementos=" + Arrays.toString(elementos) + "]";
    }

    public void inserir(T elemento){
        if(this.posicao >= this.elementos.length) {
            this.elementos = Arrays.copyOf(this.elementos, this.elementos.length + 1);
        }
        this.elementos[this.posicao] = elemento;
        this.posicao++;
    }

    public void inserirEm(int posicao, T elementos) {
        if(posicao > this.elementos.length)
            throw new IllegalArgumentException(String.format("A posição [%d] é invalida", posicao));
        if(this.elementos[posicao] != null) {
            //vetor com 1,2,3,4 posições
            // 1,5,2,3,4 colocando o elemento 5 na 2a posição

            Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao, this.elementos.length);
            Object[] arrayInicio = new Object[posicao+1];
            System.arraycopy(this.elementos,0, arrayInicio,0, posicao);
                //na posicao 0 do vetor this.elementos será colocada a pos. 0 do arrayInicio e qtos elementos.

            arrayInicio[arrayInicio.length-1] = elementos;
                //arrayFinal = 2,3,4
                //arrayInicio = 1,5

            int novoTamanho = arrayFinal.length + arrayInicio.length;
            this.elementos = new Object[novoTamanho];
            System.arraycopy(arrayInicio, 0, this.elementos, 0, arrayInicio.length);
            System.arraycopy(arrayFinal, 0, this.elementos, arrayInicio.length, arrayFinal.length);


        } else {
            this.elementos[posicao] = elementos;
        }
    }

    public T recuperar(int posicao) {
        return (T)this.elementos[posicao];
    }
}
