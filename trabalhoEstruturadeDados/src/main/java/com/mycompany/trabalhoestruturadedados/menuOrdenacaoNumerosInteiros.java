
/* Nome : Lucas Braga de Lima
   RA : 00243921

Trabalho 2 bimestre - Estrutura de Dados

Você foi contratado para desenvolver um projeto em Java que envolve a
implementação de algoritmos de ordenação em vetores de números inteiros. O projeto
consiste em criar uma aplicação que permita ao usuário inserir um vetor de números inteiros
de tamanho N e em seguida, aplicar três métodos de ordenação diferentes: ordenação por
inserção, ordenação por seleção e ordenação bolha. A aplicação deverá exibir o vetor original,
bem como o vetor ordenado pelo método selecionado pelo usuário.
*/

package com.mycompany.trabalhoestruturadedados;

import java.util.Arrays;
import java.util.Scanner;


// A classe MenuOrdenacao contém é o ponto de entrada do programa 
// Está solicitando ao usuário o tamanho do vetor e seus números .
public class menuOrdenacaoNumerosInteiros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o tamanho do vetor: ");
        int tamanho = scanner.nextInt();
        
        int[] vetor = new int[tamanho];
        
        System.out.println("Informe os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = scanner.nextInt();
        }
        
        exibirMenuOrdenacaoNumerosInteiros(vetor);
        
        scanner.close();
    }
   // O método exibirMenuOrdenacao exibe o menu de opções 
   // ele também processa a escolha do usuário. 
    public static void exibirMenuOrdenacaoNumerosInteiros(int[] vetor) {
        Scanner scanner = new Scanner(System.in);
        
        int[] vetorOrdenado = Arrays.copyOf(vetor, vetor.length);
        
        // Ele utiliza um loop infinito while (true) 
        // permite que o usuário faça várias escolhas sem sair do programa.
        while (true) {  
            System.out.println("\nSelecione um Método de Ordenação a sua escolha:");
            System.out.println("1. Ordenação por inserção");
            System.out.println("2. Ordenação por seleção");
            System.out.println("3. Ordenação bolha");
            System.out.println("4. Pesquisa Linear");
            System.out.println("5. Pesquisa Binária");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            
           // O switch é usado basicamente para tratar a opção escolhida pelo usuário.
            switch (opcao) {                            
                case 0:
                    System.out.println("Programa encerrado com sucesso");
                    scanner.close();
                    System.exit(0);
                case 1:
                    long inicioInsercao = System.nanoTime();
                    ordenacaoemInsercao(vetorOrdenado);
                    long fimInsercao = System.nanoTime();
                    
                    System.out.println("\nVetor oficial: " + Arrays.toString(vetor));
                    System.out.println("Vetor ordenado por inserção: " + Arrays.toString(vetorOrdenado));
                    System.out.println("Tempo de execução deste processo: " + (fimInsercao - inicioInsercao) + " nanossegundos");
                    break;
                case 2:
                    long inicioSelecao = System.nanoTime();
                    ordenacaoemSelecao(vetorOrdenado);
                    long fimSelecao = System.nanoTime();
                    
                    System.out.println("\nVetor oficial: " + Arrays.toString(vetor));
                    System.out.println("Vetor ordenado por seleção: " + Arrays.toString(vetorOrdenado));
                    System.out.println("Tempo de execução deste processo: " + (fimSelecao - inicioSelecao) + " nanossegundos");
                    break;
                case 3:
                    long inicioBolha = System.nanoTime();
                    ordenacaoemBolha(vetorOrdenado);
                    long fimBolha = System.nanoTime();
                    
                    System.out.println("\nVetor oficial: " + Arrays.toString(vetor));
                    System.out.println("Vetor ordenado por bolha: " + Arrays.toString(vetorOrdenado));
                    System.out.println("Tempo de execução deste processo:" + (fimBolha - inicioBolha) + " nanossegundos");
                    break;
                case 4:
                    System.out.print("\nInforme o número que você deseja buscar: ");
                    int numeroLinear = scanner.nextInt();
                    int posicaoLinear = pesquisaLinear(vetor, numeroLinear);
                    
                    if (posicaoLinear != -1) {
                        System.out.println("O número pesquisado" + numeroLinear + " foi encontrado na posição " + posicaoLinear);
                    } else {
                        System.out.println("O número pesquisado " + numeroLinear + " Não foi encontrado nesta lista");
                    }
                    break;
                case 5:
                    System.out.print("\nInforme o número que deseja buscar: ");
                    int numeroBinario = scanner.nextInt();
                    int posicaoBinaria = pesquisaBinaria(vetorOrdenado, numeroBinario);
                    
                    if (posicaoBinaria != -1) {
                        System.out.println("O número pesquisado " + numeroBinario + " foi encontrado na posição " + posicaoBinaria);
                    } else {
                        System.out.println("O número pesquisado " + numeroBinario + " não existe na lista.");
                    }
                    break;
                default:
                    System.out.println("Está opção não é válida, tente novamente! ");
                    break;
            }
        }
    }
    
    public static void ordenacaoemInsercao(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
                int numero = vetor[i];
            int j = i - 1;
            
            while (j >= 0 && vetor[j] > numero) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            
            vetor[j + 1] = numero;
        }
    }
    
    public static void ordenacaoemSelecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int numeroMenor = i;
            
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[numeroMenor]) {
                    numeroMenor = j;
                }
            }
            
            if (numeroMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[numeroMenor];
                vetor[numeroMenor] = temp;
            }
        }
    }
    
    public static void ordenacaoemBolha(int[] vetor) {
        boolean trocar;
        
        for (int i = 0; i < vetor.length - 1; i++) {
            trocar = false;
            
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocar = true;
                }
            }
            
            if (!trocar) {
                break;
            }
        }
    }
    
    public static int pesquisaLinear(int[] vetor, int numero) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int pesquisaBinaria(int[] vetor, int numero) {
        int ladoEsquerda = 0;
        int ladoDireito = vetor.length - 1;
        
        while (ladoEsquerda <= ladoDireito) {
            int meio = (ladoEsquerda + ladoDireito) / 2;
            
            if (vetor[meio] == numero) {
                return meio;
            }
            
            if (vetor[meio] < numero) {
                ladoEsquerda = meio + 1;
            } else {
                ladoDireito = meio - 1;
            }
        }
        
        return -1;
    }
}
