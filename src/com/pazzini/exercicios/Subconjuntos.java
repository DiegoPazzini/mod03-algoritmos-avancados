// Declaração do pacote para organização e identificação do código
package com.pazzini.exercicios;

/*
   Descrição do problema:
   Dado um conjunto S de elementos únicos, calcule todos os seus subconjuntos de n elementos.
   Exemplos:

   Entrada: S = [1, 2, 3], n = 2
   Saída: [1, 2], [1, 3], [2, 3]

   Entrada: S= [1, 2, 3, 4], n = 1
   Saída: [1], [2], [3] e [4]
*/
// Importação das classes ArrayList e List do pacote java.util
import java.util.ArrayList;
import java.util.List;

// Declaração da classe principal Subconjuntos
public class Subconjuntos {

    // Método para encontrar todos os subconjuntos de tamanho n
    public static List<List<Integer>> encontrarSubconjuntos(int[] arrayInt, int n) {
        List<List<Integer>> subconjuntos = new ArrayList<>(); // Lista para armazenar os subconjuntos
        backtrack(arrayInt, n, 0, new ArrayList<>(), subconjuntos); // Chamada do método de backtracking
        return subconjuntos; // Retorna a lista de subconjuntos
    }

    // Método de backtracking para gerar os subconjuntos
    private static void backtrack(int[] subconjunto, int n, int inicio, List<Integer> subconjuntoAtual,
                                  List<List<Integer>> subconjuntos) {
        // Condição de parada: o subconjuntoAtual atingiu o tamanho n
        if (subconjuntoAtual.size() == n) {
            subconjuntos.add(new ArrayList<>(subconjuntoAtual)); // Adiciona uma cópia do subconjuntoAtual à lista
            return;
        }

        // Loop para explorar as opções de elementos no subconjunto
        for (int i = inicio; i < subconjunto.length; i++) {
            subconjuntoAtual.add(subconjunto[i]); // Adiciona o elemento atual ao subconjuntoAtual
            backtrack(subconjunto, n, i + 1, subconjuntoAtual, subconjuntos); // Chamada recursiva
            subconjuntoAtual.remove(subconjuntoAtual.size() - 1); // Desfaz a última adição para explorar outras opções
        }
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        // Teste 1
        int[] arrayInt1 = {1, 2, 3};
        int n1 = 2;
        List<List<Integer>> subconjuntos1 = encontrarSubconjuntos(arrayInt1, n1);
        System.out.println("Quantidade de subconjuntos: " + subconjuntos1.size());
        System.out.println(subconjuntos1);

        // Teste 2
        int[] arrayInt2 = {1, 2, 3, 4, 5};
        int n2 = 3;
        List<List<Integer>> subconjuntos2 = encontrarSubconjuntos(arrayInt2, n2);
        System.out.println("Quantidade de subconjuntos: " + subconjuntos2.size());
        System.out.println(subconjuntos2);
    }
}
