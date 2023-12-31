// Declaração do pacote para organização e identificação do código
package com.pazzini.algorotimo_guloso;

/*
   Descrição do problema e das regras que o sistema de backup deve seguir.
   Também apresenta um exemplo de entrada e saída esperada.
*/
import java.util.ArrayList; // Importa a classe ArrayList do pacote java.util
import java.util.Arrays; // Importa a classe Arrays do pacote java.util
import java.util.List; // Importa a classe List do pacote java.util

// Declaração da classe principal
public class SistemaBackup {

    // Declaração de uma interface chamada Lote
    public static interface Lote {
        int[] getTamanhosArquivos(); // Método para obter os tamanhos dos arquivos
        int getTamanhoFita(); // Método para obter o tamanho da fita
    }

    // Implementação da interface Lote na classe interna NovoLote
    private static class NovoLote implements Lote {

        // Implementação do método getTamanhosArquivos da interface Lote
        @Override
        public int[] getTamanhosArquivos() {
            return new int[]{ // Retorna um array de tamanhos de arquivos
                    70, 10, 20, 30, 50, 100, 90, 10, 20
            };
        }

        // Implementação do método getTamanhoFita da interface Lote
        @Override
        public int getTamanhoFita() {
            return 100; // Retorna o tamanho da fita
        }
    }

    // Declaração de uma classe interna chamada Fita
    private class Fita {
        private int armazenado; // Variável para armazenar o espaço utilizado na fita
        private int numeroArquivos; // Variável para armazenar o número de arquivos na fita

        // Construtor da classe Fita
        public Fita(int armazenado) {
            this.armazenado = armazenado; // Inicializa o espaço armazenado com o valor passado como parâmetro
            this.numeroArquivos = 1; // Inicializa o número de arquivos com 1
        }

        // Método para obter o espaço armazenado na fita
        public int getArmazenado() {
            return armazenado;
        }

        // Método para adicionar espaço de armazenamento à fita
        public void adicionarArmazenamento(int armazenamento) {
            this.armazenado += armazenamento;
        }

        // Método para obter o número de arquivos na fita
        public int getNumeroArquivos() {
            return numeroArquivos;
        }

        // Método para adicionar arquivos à fita
        public void adicionarArquivos() {
            this.numeroArquivos++;
        }
    }

    // Método principal para obter o número mínimo de fitas necessário
    public int getNumeroMinimoFitas(final Lote lote) {
        // Inicializa um array com o tamanho dos arquivos
        int[] tamanhosArquivos = lote.getTamanhosArquivos();
        // Ordena o array de tamanhosArquivos
        Arrays.sort(tamanhosArquivos);

        int fitas = 0; // Variável para armazenar o número de fitas necessário
        List<Fita> listaFitas = new ArrayList<>(); // Lista para armazenar objetos da classe Fita

        // Percorre o array do maior para o menor
        for (int i = tamanhosArquivos.length - 1; i > -1; i--) {
            boolean armazenado = false;

            // Percorre a lista de fitas
            for (Fita fita : listaFitas) {
                // Verifica se a soma do que está armazenado com o índice do array é menor ou igual ao tamanho da fita
                // e se o número de arquivos é menor que 2
                if (((fita.getArmazenado() + tamanhosArquivos[i]) <= lote.getTamanhoFita()) &&
                        (fita.getNumeroArquivos() < 2)) {
                    fita.adicionarArmazenamento(tamanhosArquivos[i]); // Adiciona o arquivo à fita
                    fita.adicionarArquivos(); // Atualiza o número de arquivos na fita
                    armazenado = true;
                    break;
                }
            }

            // Verifica se foi armazenado, se não foi, acrescenta uma nova fita
            // e instancia uma nova fita contendo o arquivo que não foi adicionado e adiciona na lista de fitas
            if (!armazenado) {
                fitas++;
                listaFitas.add(new Fita(tamanhosArquivos[i]));
            }
        }

        return fitas; // Retorna o número mínimo de fitas necessário
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        SistemaBackup sistemaBackup = new SistemaBackup(); // Instancia um objeto da classe SistemaBackup
        Lote lote = new NovoLote(); // Instancia um objeto da classe NovoLote que implementa a interface Lote

        // Chama o método getNumeroMinimoFitas e imprime o resultado
        System.out.println(sistemaBackup.getNumeroMinimoFitas(lote));
    }
}
