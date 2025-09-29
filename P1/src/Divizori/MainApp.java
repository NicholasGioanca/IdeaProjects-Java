package Divizori;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti in numar natural : ");
        int n = scanner.nextInt();

        int nr = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                nr++;
            }
        }
        if (nr == 0) {
            System.out.println("Numarul introdus este un numar prim.");
        }
    }
}
