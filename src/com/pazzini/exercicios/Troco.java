// Declaração do pacote para organização e identificação do código
package com.pazzini.exercicios;

/*
   Descrição do problema:
   Você tem que dar o troco de uma quantia em dinheiro usando o menor número possível de moedas.
   Exemplo:
   Entrada: Quantia 18, Moedas disponíveis 5, 2 e 1
   Saída: 5 (três moedas de 5, uma de 2 e uma de 1)
*/

// Importação das classes ArrayList e List do pacote java.util
import java.util.ArrayList;
import java.util.List;

// Declaração da classe principal Troco
public class Troco {

    // Método para dar o troco usando o menor número possível de moedas
    public static List<Integer> darTroco(int quantia, int[] cedulas) {
        List<Integer> troco = new ArrayList<>(); // Lista para armazenar as moedas do troco
        int i = 0;

        // Loop para calcular o troco enquanto há quantia a ser devolvida e moedas disponíveis
        while (quantia > 0 && i < cedulas.length) {
            // Se a cédula atual é menor ou igual à quantia, adiciona à lista e subtrai da quantia
            if (cedulas[i] <= quantia) {
                troco.add(cedulas[i]);
                quantia -= cedulas[i];
            } else {
                i++; // Passa para a próxima cédula se a atual for maior que a quantia
            }
        }
        return troco; // Retorna a lista de moedas do troco
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        int quantia = 58; // Quantia a ser trocada
        int[] cedulas = {10, 5, 2, 1}; // Moedas disponíveis
        List<Integer> resultado = darTroco(quantia, cedulas); // Chama o método darTroco
        System.out.println(resultado); // Imprime o resultado (lista de moedas do troco)
    }
}
