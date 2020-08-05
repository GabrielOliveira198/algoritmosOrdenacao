/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosOrdenação;

import java.util.Random;

/**
 *
 * @author Phael
 */
public class Ordena {

    // Abaixo, o algoritmo do Bubble sort em Java:
    public void bubble_sort(int[] vetor) {
        int iterar = 0;
        int trocas = 0, comp = 0;

        while (true) {
            boolean ordenado = true;

            for (int i = vetor.length - 1; i > iterar; i--) {
                comp++;
                if (vetor[i] < vetor[i - 1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = aux;
                    trocas += 3;
                    ordenado = false;
                }

            }

            if (ordenado) {
                break;
            }
            iterar++;
        }
        //System.out.println("Bubble Sort: \nNumero de trocas: " + trocas + "\nComparaçoes: " + comp);

    }

    public void insertionSort(int[] array) {
        int trocas = 0, comp = 0;

        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            trocas++;
            for (int j = i - 1; j >= 0 /**
                     * && array[j] > a
                     */
                    ; j--) {
                comp++;

                if (array[j] > a) {
                    trocas += 2;
                    array[j + 1] = array[j];
                    array[j] = a;

                }

            }

        }

        //System.out.println("\nInsertion sort: \nNumero de trocas : " + trocas + "\nComparaçoes : " + comp);
    }

    public int[] SelectionSort(int[] array) {

        int menor, indiceMenor, trocas = 0, comp = 0;

        for (int i = 0; i < array.length - 1; i++) {
            // antes de comparar, considera-se menor o valor atual do loop
            menor = array[i];
            indiceMenor = i;
            trocas++;

            // compara com os outros valores do vetor
            for (int j = i + 1; j < array.length; j++) {
                comp++;
                if (array[j] < menor) {
                    menor = array[j];
                    indiceMenor = j;
                    trocas++;
                }
            }

            // troca os valores menor e maior
            array[indiceMenor] = array[i];
            array[i] = menor;
            trocas += 3;
        }

        //System.out.println("\nSelection Sort: \nNumero de trocas: " + trocas + "\nComparações : " + comp);
        return array;
    }

    public void ShellSort(int[] v) {
        int i, j, h = 1, value, trocas = 0, comp = 0;
        do {
            h = 3 * h + 1;
        } while (h < v.length);
        do {
            h = h / 3;

            for (i = h; i < v.length; i++) {
                value = v[i];
                trocas++;
                j = i - h;
                while (j >= 0 && value < v[j]) {
                    comp++;
                    v[j + h] = v[j];
                    j = j - h;

                }
                comp++;
                v[j + h] = value;
                trocas++;
            }

        } while (h > 1);
        //System.out.println("\nShell Sort \nNumero de trocas: " + trocas + "\nComparaçoes: " + comp);

    }

    //TRABALHO 3 
    //MERGE SORT
    public int[] MergeSort(int[] array) {

        if (array.length <= 1) {
            return array;       // VERIFICA SE O ARRAY SE E UM ARRAY VALIDO, OU SEJA COM PELO MENOS DOIS ELEMENTOS
        }
        int meio = array.length / 2; //SELECIONA O PIVO, OU SEJA O MEIO DO VETOR EM INDICE
        int[] dir = array.length % 2 == 0 ? new int[meio] : new int[meio + 1]; //REPARTE A PARTE PARA DIREITA DO PIVO, CASO SEJA IMPAR ELE ADICIONA MAIS UMA
        //POSICAO PARA QUE SEJA POSSIVEL TRABALHAR A ORDENACAO DO VETOR
        int[] esq = new int[meio]; // REPARTE A ESQUERDA DO PIVO

        int[] aux = new int[array.length]; // CRIA UM ARRAY AUXILIAR ONDE SERAM COLOCADOS OS DADOS ORDENADOS

        for (int i = 0; i < meio; i++) { //TRANSFERE OS ELEMENTOS DA ESQUEDAR DO PIVO DO 'ARRAY' PARA O 'ESQ'
            esq[i] = array[i];
        }

        int auxIndex = 0;	//INDICE AUXILIAR PARA TRANSFERENCIA DE DADOS JA QUE OS DADOS ESTARAM EM POSICOES DIFERENTES NOS VETORES
        for (int i = meio; i < array.length; i++) { //TRANSFERE OS ELEMENTOS DA DIREITA DO PIVO DO 'ARRAY' PARA O 'DIR'
            dir[auxIndex] = array[i];
            auxIndex++;
        }
        //ESSA PARTE ABAIXO USA A RECURSAO PARA CRIAR INFINITAS REPARTIÇOES ATE QUE O TAMANHO DAS MEMSMA SEJA 2 OU QUE ESTEJAM ORDENADAS
        esq = MergeSort(esq); //CHAMA RECURSIVAMENTE PARA QUE OS DADOS DE 'ESQ' SEJAM REPARTIDOS NOVAMENTE
        dir = MergeSort(dir); //CHAMA RECURSIVAMENTE PARA QUE OS DADOS DE 'DIR' SEJAM REPARTIDOS NOVAMENTE

        aux = mergesort(esq, dir); //CHAMA MERGESORT

        return aux;
    }

    int[] mergesort(int[] esq, int[] dir) { //RECEBE VETORES REPARTIDOS PELO 'SORT'
        int[] aux = new int[esq.length + dir.length]; //CRIA UM VETOR AUXILIAR DO TAMANHO DE 'DIR.LENGTH'+'ESQ.LENGTH'

        int indexDir = 0, indexEsq = 0, indexAux = 0; //CRIA UM INDICE PARA CADA RESPECTIVO VETOR CONTIDO NO ESCOPO DO METODO POR CAUSA DO WHILE

        while (indexEsq < esq.length || indexDir < dir.length) { //ENQUANTO O INDICE DE 'ESQ' OU 'DIR' FOREM MENORES QUE O TAMANHO DOS MESMOS
            if (indexEsq < esq.length && indexDir < dir.length) { //SE O INDICE DE 'ESQ' E 'DIR' FOREM MENORES QUE O TAMANHO DOS MESMOS
                // (E QUANDO ESTAO DO MESMO TAMANHO DAI SAO AVALIADOS JUNTOS)
                if (esq[indexEsq] <= dir[indexDir]) { //SE O O VALOR DA POSICAO DE 'ESQ' FOR MENOR OU IGUAL QUE A DE 'DIR'
                    aux[indexAux] = esq[indexEsq]; //COLOCA O VALOR DE 'ESQ' QUE E O MENOR NO VETOR 'AUX' QUE GUARDA OS VALORES ORDENADOS
                    indexAux++; //AUMENTA O INDICE EM 1  DO 'AUX' POIS FOI POVOADA A POSICAO
                    indexEsq++; //AUMENTA O INDICE EM 1  DO 'ESQ' POIS FOI AVALIADA A POSICAO
                } else {	//SE NAO
                    aux[indexAux] = dir[indexDir]; //COLOCA O VALOR DE 'DIR' QUE E O MENOR NO VETOR 'AUX' QUE GUARDA OS VALORES ORDENADOS
                    indexAux++;  //AUMENTA O INDICE EM 1  DO 'AUX' POIS FOI POVOADA A POSICAO
                    indexDir++;	//AUMENTA O INDICE EM 1  DO 'DIR' POIS FOI AVALIADA A POSICAO
                }
            } else if (indexEsq < esq.length) { //SE O INDICE DE 'ESQ' AINDA E MENOR QUE SEU TAMANHO TOTAL
                aux[indexAux] = esq[indexEsq]; //'AUX' NO INDICE ATUAL DE SUA VARIALVEL 'INDEXAUX' RECEBE O VALOR DA POSICAO DE 'ESQ' NA POSICAO DE SEU INDICE
                indexAux++; //AUMENTA O INDICE EM 1  DO 'AUX' POIS FOI POVOADA A POSICAO
                indexEsq++; //AUMENTA O INDICE EM 1  DO 'EST' POIS FOI TRANSFERIDO O DADO DA POSICAO
            } else if (indexDir < dir.length) { //SE O INDICE DE 'ESQ' AINDA E MENOR QUE SEU TAMANHO TOTAL
                aux[indexAux] = dir[indexDir]; //'AUX' NO INDICE ATUAL DE SUA VARIALVEL 'INDEXAUX' RECEBE O VALOR DA POSICAO DE 'DIR' NA POSICAO DE SEU INDICE
                indexAux++; //AUMENTA O INDICE EM 1  DO 'AUX' POIS FOI POVOADA A POSICAO
                indexDir++; //AUMENTA O INDICE EM 1  DO 'DIR' POIS FOI TRANSFERIDO O DADO DA POSICAO
            }
        }
        return aux;
    }

    //QUICK SORT
    private int array[];
    private int length;

    public void QuickSort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a
             * number from right side which is less then the pivot value. Once
             * the search is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //HEAP SORT

    public int[] HeapSort(int[] v) { //RECEBE O VETOR PARA SER TRABALHADO
        buildMaxHeap(v); //CHAMA O METODO QUE IRA REPATIR EM PARTES PARA SER ORGANIZADO LEVANDO EM CONTA A FILOSOFIA DA ARVORE BINARIA BALANCEADA (ORGANIZA DE FORMA QUE SEMPRE O MAIOR VALOR ESTEJA A DIREITA DE UM MENOR DO MESMO)
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0); //TROCA O VALOR DA ULTIMA POSICAO COM A PRIMEIRA
            maxHeapify(v, 0, --n); //PASSA COMO PARAMETRO O VETOR A SER TRABALHADO O VALOR INICIAL DO VETOR E SEU TAMANHO DE FORMA DECRESCENTE A CADA LACO
        }

        return v;
    }

    private void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) { //RODA EM TORNO DA METADE DE VEZES DO TAMANHO DO VETOR
            maxHeapify(v, i, v.length); //CHAMA O METODO PARA COMPARAR OS DADOS DAS POSICOES E TOMAR AS DECISOES DE TROCA DE POSICAO
        }

    }

    private void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor) { //CADA METODO CHAMA A SI MESMO NO MINIMO UMA VEZ, 
        //OU SEJA 2 'MAXHEAPIFY' POR VOLTA DO LACO NO MINIMO (COM EXCECAO DO ULTIMO)
        int max = 2 * pos + 1, right = max + 1; // OPERACOES ARITMETICAS PARA ESTABELECER O INDICES
        if (max < tamanhoDoVetor) {

            if (right < tamanhoDoVetor && vetor[max] < vetor[right]) {
                max = right;
            }

            if (vetor[max] > vetor[pos]) {
                swap(vetor, max, pos); 	//CHAMA O METODO QUE TROCA DE POSICAO OS DADOS DE UM DADO VETOR COM OS SEUS INDICES ESPECIFICADOS
                maxHeapify(vetor, max, tamanhoDoVetor); //CHAMA RECURSIVAMENTE A SI PROPIO
            }
        }
    }

    public void swap(int[] v, int j, int aposJ) { // 'V' E O DADO VETOR EM QUE SERA TROCADO AS DEVIDAS POSICOES
        int aux = v[j]; //CRIA UMA VARIAVEL AUXILIAR PARA GUARDAR O VALOR DE 'V[J]' TEMPORARIAMENTE
        v[j] = v[aposJ]; //COLOCA O VALOR DA POSICAO 'APOSJ' NA POSICAO 'J'
        v[aposJ] = aux; //COLOCA O VALOR DE AUX (QUE E O VALOR ANTERIOR DE 'J') NA POSICAO 'APOSJ'
    }
}
