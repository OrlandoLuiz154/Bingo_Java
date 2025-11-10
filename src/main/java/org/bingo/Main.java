package org.bingo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BINGO POO =====");
        System.out.print("Digite a quantidade de cartelas: ");
        int qtd = sc.nextInt();

        Bingo bingo = new Bingo(qtd);
        bingo.mostrarCartelas();
        bingo.iniciarSorteio();

        sc.close();
    }
}
