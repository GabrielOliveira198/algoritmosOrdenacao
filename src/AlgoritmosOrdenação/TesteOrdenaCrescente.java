/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosOrdenação;

/**
 *
 * @author Phael
 */
public class TesteOrdenaCrescente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int tam = 20;

        //Instancias
        Ordena array = new Ordena();
        GeraVetor gera = new GeraVetor();

        //Geração do vetor
        int[] vetor = gera.cresVet(tam);

        //Imprimir o vetor desordenado
        System.out.println("Vetor Desordenado Crescente: ");
        String mostrarDesordenado = "";
        for (int n : vetor) {
            mostrarDesordenado += n + " ";
        }
        int[] vetor2 = new int[tam];
        int[] vetor3 = new int[tam];
        int[] vetor4 = new int[tam];
        for (int i = 0; i < tam; i++) {
            vetor2[i] = vetor[i];
            vetor3[i] = vetor[i];
            vetor4[i] = vetor[i];   
        }
        System.out.println(mostrarDesordenado);
        System.out.println(" \n");

        //Bubble Sort
        long tempoinibublle = System.nanoTime();
        array.bubble_sort(vetor);
        long tempofimbublle = System.nanoTime();
        long tempobubble = tempofimbublle - tempoinibublle;
        System.out.println("Tempo Gasto: " + tempobubble);
        String mostrarBublle = "";
        for (int n : vetor) {
            mostrarBublle += n + " ";
        }
        System.out.println(mostrarBublle);

        //selection sort
        long tempoiniSelection = System.nanoTime();
        array.SelectionSort(vetor2);
        long tempofimSelection = System.nanoTime();
        long tempoSelection = tempofimSelection - tempoiniSelection;
        System.out.println("Tempo gasto: " + tempoSelection);

        String mostrarSelection = "";
        for (int n : vetor2) {
            mostrarSelection += n + " ";
        }
        System.out.println(mostrarSelection);

        //insertion sort:
        long tempoiniInsertion = System.nanoTime();
        array.insertionSort(vetor3);
        long tempofimInsertion = System.nanoTime();
        long tempoInsertion = tempofimInsertion - tempoiniInsertion;
        System.out.println("Tempo gasto: " + tempoInsertion);
        String mostrarInsertion = "";
        for (int n : vetor3) {
            mostrarInsertion += n + " ";
        }
        System.out.println(mostrarInsertion);

        //Shell Sort
        long tempoiniShell = System.nanoTime();
        array.ShellSort(vetor4);
        long tempofimShell = System.nanoTime();
        long tempoShell = tempofimShell - tempoiniShell;
        System.out.println("Tempo gasto: " + tempoShell);
        //System.out.printf("Tempo gasto: %d\n", tempofimShell - tempoiniShell);
        String mostrarShell = "";
        for (int n : vetor4) {
            mostrarShell += n + " ";
        }
        System.out.println(mostrarShell);

    }
}
