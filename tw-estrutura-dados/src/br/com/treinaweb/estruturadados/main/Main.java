package br.com.treinaweb.estruturadados.main;

import java.util.Scanner;

import br.com.treinaweb.estruturadados.modelos.Pessoa;

public class Main {

	public static void main(String[] args) {
		System.out.println("Digite a opção desejada");
		System.out.println("1. Gerenciamento de memória");
		Scanner scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		switch(opcao) {
		case 1:
			fazerGerenciamentoMemoria();
			break;
		}
		scanner.close();
	}
	
	private static void fazerGerenciamentoMemoria() {
		int a = 3;
		System.out.println(a);
		int b = a;
		System.out.println(b);
		b = 2;
		System.out.println("------------");
		System.out.println(a);
		System.out.println(b);
		System.out.println(a == b);
		System.out.println("*********teste**********");
		Pessoa p1 = new Pessoa(1, "Treinaweb");
		System.out.println(p1.toString());
		Pessoa p2 = p1; //aqui tanto p2 quanto p1 estão apontando para o mesmo endereço de memória --> dupliquei o ponteiro e não o conteúdo da heap.
		System.out.println(p2.toString());
		System.out.println("++++++++++++++++++++++++++");
		p2.setNome("Treinaweb que foi modificado");
		p2 = new Pessoa(2, "Novo objeto treinaweb"); //a palavra 'new' é quem instrui a jvm a criar um novo espaço de memoria na heap
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1 == p2); //compara se ambos estão apontando para mesma posição de memória

	}

}
