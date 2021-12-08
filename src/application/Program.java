package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {

		// O Pipeline s�o opera��es em streams que retornam novas streams, sendo
		// poss�vel criar uma cadeia de opera��es(Fluxo de processamento).
		// � composto por zero ou mais opera��es intermedi�rias e uma terminal.

		// Iniciando a lista com Arrays.asLista
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		// Criando um stream a partir da lista "list", utilizando map como opera��o
		// intermedi�ria: a cada elemento multiplique por 10, utilizando toArray como
		// opera��o terminal: converte para um vetor
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		// Transformando a lista em um vetor
		System.out.println(Arrays.toString(st1.toArray()));

		// Opera��o terminal reduce: pega o elemento inicial que vai ser o elemento
		// neutro da
		// opera��o, e depois uma fun��o que recebe dois argumentos e gera um resultado.
		// Nesse exemplo: O elemento inicial vai ser 0 (Pois o elemento neutro da soma �
		// 0, assim n�o afetando o resultado), a cada elemento y adicione ele com x,
		// fazendo assim a soma de todos os itens da lista, ele ir� retornar um n�mero
		// inteiro.
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum: " + sum);

		// Utilizando duas opera��es intermedi�rias
		// filter: Filtra sua lista... voc� ir� definir um predicato e com base nesse
		// predicato ser� gerada uma nova stream, nesse exemplo: Pegue apenas os
		// elementos que o resto da divis�o dele com 2 seja igual a 0.
		// Map: Aplica uma fun��o a cada elemento da stream, nesse exemplo: Multiplique
		// os elementos por 10.
		// E utilizando a opera��o terminal collect: Converte a stream para uma lista.
		List<Integer> newList = list.stream().filter(x -> x % 2 == 0).map(x -> x * 10).collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));
	}
}
