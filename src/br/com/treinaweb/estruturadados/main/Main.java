package br.com.treinaweb.estruturadados.main;

import java.util.Scanner;

import br.com.treinaweb.estruturadados.modelos.Pessoa;
import br.com.treinaweb.estruturadados.vetores.Vetor;

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

			case 2:
				fazerVetor();
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

	private static void fazerVetor() {

		//utilizacao de generics
		Vetor<Pessoa> vetorPessoas = new Vetor<Pessoa>(3); //vetores são alocados na heap por conta da complexidade dos mesmos.
		vetorPessoas.inserir(new Pessoa(0,"Jimi Hendrix no vetor")); //vetores grandes demais poderiam estourar a stack.
		vetorPessoas.inserir(new Pessoa(1, "BB King no vetor"));
		vetorPessoas.inserir(new Pessoa(2, "Jimmy page no vetor"));
		vetorPessoas.inserir(new Pessoa(3, "Joe Satriani no vetor"));
		vetorPessoas.inserir(new Pessoa(4, "Eric Clapton no vetor"));
		vetorPessoas.inserirEm(1, new Pessoa(5, "Tom Morello no vetor"));
		System.out.println(vetorPessoas); //essa posicao 1 equivale ao 2o elemento do vetor

		//exemplo com inteiros
		Vetor<Integer> vetorInteiros = new Vetor<Integer>(2);
		vetorInteiros.inserirEm(0, 2020);
		System.out.println(vetorInteiros.recuperar(0));

		System.out.println("Lista de pessoas: ");
		for(int i = 0; i < vetorPessoas.tamanho(); i++) {
			System.out.println(vetorPessoas.recuperar(i).getNome());
		}

		System.out.println("**********************************");

		Pessoa p1 = vetorPessoas.recuperar(1);
		System.out.println(p1);
		System.out.println(vetorPessoas.contem(p1));
		System.out.println(vetorPessoas.indice(p1));

		Pessoa pessoaErrada = new Pessoa(13, "Giovana Pinheiro não está no vetor");
		System.out.println(pessoaErrada);
		System.out.println(vetorPessoas.contem(pessoaErrada));
		System.out.println(vetorPessoas.indice(pessoaErrada));


		//testes de inicialização
//		int [] vetorInteiro = new int [3];
//		System.out.println("O valor padrão para inteiros quando não foram inicializados: " + vetorInteiro[0]);
//		boolean [] vetorBooleans = new boolean[3];
//		System.out.println("O valor padrão para booleanos quando não foram inicializados: " + vetorBooleans[0]);
//		String [] vetorString = new String[3];
//		System.out.println("O valor padrão para strings quando não foram inicializadas: " + vetorString[0]);

	}
}
