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
public class TesteOdenaAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int tam = 10000;

        //Instancias
        Ordena array = new Ordena();
        GeraVetor gera = new GeraVetor();

        //Geração do vetor
        int[] vetor = gera.RandomVet(tam);

        //Imprimir o vetor desordenado
        System.out.println("Vetor Desordenado Aleatório com " + tam + " elementos:");
        String mostrarDesordenado = "";
        for (int n : vetor) {
            mostrarDesordenado += n + " ";
        }
        System.out.println(mostrarDesordenado);
        System.out.println(" \n");
        int[] vetor2 = new int[tam];
        int[] vetor3 = new int[tam];
        int[] vetor4 = new int[tam];
        for (int i = 0; i < tam; i++) {
            vetor2[i] = vetor[i];
            vetor3[i] = vetor[i];
            vetor4[i] = vetor[i];
        }
        double soma = 0;

        //Bubble Sort
        for (int i = 0; i < 100; i++) {
            double tempoinibublle = System.currentTimeMillis();
            array.bubble_sort(vetor);
            double tempofimbublle = System.currentTimeMillis();
            double tempobubble = tempofimbublle - tempoinibublle;
            soma += tempobubble;
        }
        System.out.println("\nBuuble Sort:");
        System.out.printf("Tempo Gasto: %.4f\n", soma / 100);
        /*
        String mostrarBublle = "";
        for (int n : vetor) {
            mostrarBublle += n + " ";
        }
        System.out.println(mostrarBublle);
         */
        //selection sort
        double soma2 = 0;

        for (int i = 0; i < 100; i++) {
            double tempoiniSelection = System.currentTimeMillis();
            array.SelectionSort(vetor2);
            double tempofimSelection = System.currentTimeMillis();
            double tempoSelection = tempofimSelection - tempoiniSelection;
            soma2 += tempoSelection;
        }
        System.out.println("\nSelection Sort");
        System.out.printf("Tempo Gasto: %.4f\n", soma2 / 100);
        /*
        String mostrarSelection = "";
        for (int n : vetor2) {
            mostrarSelection += n + " ";
        }
        System.out.println(mostrarSelection);
         */
        //insertion sort:
        double soma3 = 0;
        for (int i = 0; i < 100; i++) {
            double tempoiniInsertion = System.currentTimeMillis();
            array.insertionSort(vetor3);
            double tempofimInsertion = System.currentTimeMillis();
            double tempoInsertion = tempofimInsertion - tempoiniInsertion;
            soma3 += tempoInsertion;
        }
        System.out.println("\nInsertion Sort: ");
        System.out.printf("Tempo Gasto: %.4f\n", soma3 / 100);
        /*
        String mostrarInsertion = "";
        for (int n : vetor3) {
            mostrarInsertion += n + " ";
        }
        System.out.println(mostrarInsertion);
         */

        //Shell Sort
        double soma4 = 0;
        for (int i = 0; i < 100; i++) {
            double tempoiniShell = System.currentTimeMillis();
            array.ShellSort(vetor4);
            double tempofimShell = System.currentTimeMillis();
            double tempoShell = tempofimShell - tempoiniShell;
            soma4 += tempoShell;
        }
        System.out.println("\nShell Sort");
        System.out.printf("Tempo Gasto: %.4f\n", soma4 / 100);
        /*System.out.printf("Tempo gasto: %d\n", tempofimShell - tempoiniShell);
        String mostrarShell = "";
        for (int n : vetor4) {
            mostrarShell += n + " ";
        }
        System.out.println(mostrarShell);
         */

        //QuickSort
        
        double soma5 = 0;
         for (int i = 0; i < 100; i++) {
            double tempoiniquick  = System.currentTimeMillis();
            array.QuickSort(vetor);
            double tempofimquick = System.currentTimeMillis();
            double tempoquick = tempofimquick - tempoiniquick;
            soma5 += tempoquick;
        }
        System.out.println("\nQuick Sort:");
        System.out.printf("Tempo Gasto: %.4f\n",  soma5/100);

        double soma6 = 0;
        for (int i = 0; i < 100; i++) {
            double tempoiniheap = System.currentTimeMillis();
            array.HeapSort(vetor);
            double tempofimheap = System.currentTimeMillis();
            double tempoheap = tempofimheap - tempoiniheap;
            soma6 += tempoheap;

        }
        System.out.println("\nHeap Sort:");
        System.out.printf("Tempo Gasto: %.4f\n", soma6 / 100);
        
        double soma7 = 0;
        for (int i = 0; i < 100; i++) {
            double tempoiniMerge = System.currentTimeMillis();
            array.MergeSort(vetor);
            double tempofimMerge = System.currentTimeMillis();
            double Merge = tempofimMerge - tempoiniMerge;
            soma7 += Merge;

        }
        System.out.println("\nMerge Sort:");
        System.out.printf("Tempo Gasto: %.4f\n", soma7 / 100);

    }

}
