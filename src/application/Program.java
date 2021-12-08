package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {

		// O Pipeline são operações em streams que retornam novas streams, sendo
		// possível criar uma cadeia de operações(Fluxo de processamento).
		// É composto por zero ou mais operações intermediárias e uma terminal.

		// Iniciando a lista com Arrays.asLista
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		// Criando um stream a partir da lista "list", utilizando map como operação
		// intermediária: a cada elemento multiplique por 10, utilizando toArray como
		// operação terminal: converte para um vetor
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		// Transformando a lista em um vetor
		System.out.println(Arrays.toString(st1.toArray()));

		// Operação terminal reduce: pega o elemento inicial que vai ser o elemento
		// neutro da
		// operação, e depois uma função que recebe dois argumentos e gera um resultado.
		// Nesse exemplo: O elemento inicial vai ser 0 (Pois o elemento neutro da soma é
		// 0, assim não afetando o resultado), a cada elemento y adicione ele com x,
		// fazendo assim a soma de todos os itens da lista, ele irá retornar um número
		// inteiro.
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum: " + sum);

		// Utilizando duas operações intermediárias
		// filter: Filtra sua lista... você irá definir um predicato e com base nesse
		// predicato será gerada uma nova stream, nesse exemplo: Pegue apenas os
		// elementos que o resto da divisão dele com 2 seja igual a 0.
		// Map: Aplica uma função a cada elemento da stream, nesse exemplo: Multiplique
		// os elementos por 10.
		// E utilizando a operação terminal collect: Converte a stream para uma lista.
		List<Integer> newList = list.stream().filter(x -> x % 2 == 0).map(x -> x * 10).collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));
	}
}
