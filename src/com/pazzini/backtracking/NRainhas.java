// Declaração do pacote para organização e identificação do código
package com.pazzini.backtracking;

/*
    Descrição do problema:
    Dado um tabuleiro de tamanho NxN, devemos colocar N rainhas no tabuleiro de forma que nenhuma delas se ataquem.
    Exemplo n=4;
 */
/*
   Exemplo de tabuleiro 4x4 com rainhas posicionadas:
   0 1 0 0
   0 0 0 1
   1 0 0 0
   0 0 1 0
*/
// Declaração da classe principal NRainhas
public class NRainhas {

    // Método para verificar se existe um ataque na posição (x, y) do tabuleiro
    private static boolean temAtaque(int x, int y, int[][] tab) {
        // Checando as linhas
        for (int j = 0; j < tab.length; j++) {
            if (tab[x][j] == 1) return true;
        }
        // Checando as colunas
        for (int i = 0; i < tab.length; i++) {
            if (tab[i][y] == 1) return true;
        }
        // Checando as diagonais
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                int indEsq = i + j;
                int indDir = i - j;

                if (indEsq == (x + y) && tab[i][j] == 1) return true;

                if (indDir == (x - y) && tab[i][j] == 1) return true;
            }
        }
        return false;
    }

    // Método para imprimir o tabuleiro
    private static void imprimeTabuleiro(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método principal para resolver o problema das N rainhas
    private static boolean resolveNRainhas(int[][] tab, int n) {
        // Checa se todas as rainhas foram colocadas
        if (n == 0) return true;

        // Loop para percorrer todas as posições do tabuleiro
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                // Se houver ataque na posição, continua para a próxima iteração
                if (temAtaque(i, j, tab)) continue;
                // Colocando a rainha no tabuleiro
                tab[i][j] = 1;

                // Recursivamente tenta colocar as rainhas restantes
                if (resolveNRainhas(tab, n - 1)) return true;

                // Solução não foi encontrada, desfaz a última mudança
                tab[i][j] = 0;
            }
        }
        return false;
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        int n = 4; // Número de rainhas e tamanho do tabuleiro
        int[][] tab = new int[n][n]; // Inicializa um tabuleiro vazio

        // Chama o método resolveNRainhas para encontrar a solução
        boolean resultado = resolveNRainhas(tab, n);

        // Imprime o tabuleiro se houver solução, caso contrário, informa que não há solução
        if (resultado) {
            imprimeTabuleiro(tab);
        } else {
            System.out.println("Não houve solução!");
        }
    }
}
