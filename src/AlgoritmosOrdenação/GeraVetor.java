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
public class GeraVetor {
        public int[] RandomVet(int tam) {
        int vet[] = new int[tam];
        int i;
        Random random = new Random();
        for (i = 0; i < tam; i++) {
            vet[i] = random.nextInt(tam);
        }
        return vet;
    }

    public int[] cresVet(int tam) {
        int vet[] = new int[tam];
        int i;
        for (i = 0; i < tam; i++) {
            vet[i] = i;
        }
        return vet;
    }

    public int[] decVet(int tam) {
        int vet[] = new int[tam];
        int i;
        int x = tam;
        for (i = 0; i < tam; i++) {
            vet[i] = x--;
        }
        return vet;
    }
    
}
