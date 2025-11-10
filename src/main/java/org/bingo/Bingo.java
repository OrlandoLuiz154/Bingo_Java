package org.bingo;
import java.util.*;

public class Bingo {
    private ArrayList<Cartela> cartelas;
    private ArrayList<Integer> numerosSorteados;

    public Bingo(int qtdCartelas) {
        cartelas = new ArrayList<>();
        numerosSorteados = new ArrayList<>();
        for (int i = 0; i < qtdCartelas; i++) {
            cartelas.add(new Cartela());
        }
    }

    public void iniciarSorteio() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("\n===== INICIANDO SORTEIO =====");
        boolean vencedorEncontrado = false;

        while (!vencedorEncontrado) {
            int numero;
            do {
                numero = rand.nextInt(100);
            } while (numerosSorteados.contains(numero));

            numerosSorteados.add(numero);
            System.out.println("\nNúmero sorteado: " + numero);

            for (int i = 0; i < cartelas.size(); i++) {
                Cartela cartela = cartelas.get(i);
                if (cartela.marcarNumero(numero)) {
                    System.out.println("Cartela " + (i + 1) + " marcou o número!");
                }

                if (cartela.venceu()) {
                    System.out.println("\nCartela " + (i + 1) + " é a vencedora!");
                    vencedorEncontrado = true;
                }
            }

            if (!vencedorEncontrado) {
                System.out.print("Pressione ENTER para sortear o próximo número...");
                sc.nextLine();
            }
        }
    }

    public void mostrarCartelas() {
        for (int i = 0; i < cartelas.size(); i++) {
            System.out.println("\nCartela " + (i + 1) + ":");
            cartelas.get(i).mostrar();
        }
    }
}
