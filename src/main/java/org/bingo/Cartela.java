package org.bingo;
import java.util.*;

public class Cartela {
    private Map<String, ArrayList<Integer>> colunas;
    private boolean[][] marcados;

    public Cartela() {
        colunas = new LinkedHashMap<>();
        marcados = new boolean[5][5];
        gerarCartela();
    }

    private void gerarCartela() {
        int[][] faixas = {
                {0, 19},   // B
                {20, 39},  // I
                {40, 59},  // N
                {60, 79},  // G
                {80, 99}   // O
        };
        String[] letras = {"B", "I", "N", "G", "O"};
        Random rand = new Random();

        for (int i = 0; i < letras.length; i++) {
            ArrayList<Integer> numeros = new ArrayList<>();
            while (numeros.size() < 5) {
                int num = rand.nextInt(faixas[i][1] - faixas[i][0] + 1) + faixas[i][0];
                if (!numeros.contains(num)) {
                    numeros.add(num);
                }
            }
            colunas.put(letras[i], numeros);
        }
    }

    public boolean marcarNumero(int numero) {
        String[] letras = {"B", "I", "N", "G", "O"};
        for (int c = 0; c < letras.length; c++) {
            ArrayList<Integer> nums = colunas.get(letras[c]);
            for (int l = 0; l < nums.size(); l++) {
                if (nums.get(l) == numero) {
                    marcados[c][l] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean venceu() {
        // Verifica se todos os números foram marcados
        for (int c = 0; c < 5; c++) {
            for (int l = 0; l < 5; l++) {
                if (!marcados[c][l]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        System.out.println(" B   I   N   G   O");
        for (int i = 0; i < 5; i++) {
            for (String letra : colunas.keySet()) {
                int numero = colunas.get(letra).get(i);
                System.out.printf("%02d ", numero);
            }
            System.out.println();
        }
    }
}
