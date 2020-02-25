package br.com.treinaweb.estruturadados.vetores;

import br.com.treinaweb.estruturadados.modelos.Pessoa;

public class Vetor<T> {
    private Object [] elementos;

    public Vetor (int capacidade) {
        this.elementos = new Object[capacidade];
    }

    public void inserirEm(int posicao, T elementos) {
        this.elementos[posicao] = elementos;
    }

    public T recuperar(int posicao) {
        return (T)this.elementos[posicao];
    }
}
