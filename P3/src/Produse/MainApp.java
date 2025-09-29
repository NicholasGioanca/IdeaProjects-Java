package Produse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        CosCumparaturi cos = new CosCumparaturi();
        List<Produs> produse = cos.getProduse();
        CitesteProduseFisier.citesteProduseDinFisier("produse.txt");
        produse.forEach(cos::adaugaProdus);

        Scanner scanner = new Scanner(System.in);
        boolean ruleaza = true;

        while (ruleaza) {
            System.out.print("\nOptiuni: ");
            System.out.println("1.Afisarea tuturor produselor din colectia List");
            System.out.println("2.Afisarea produselor expirate.");
            System.out.println("3.Vanzarea unui produs.");
            System.out.println("4.Afisarea produselor cu pretul minim.");
            System.out.println("5.Salvarea produselor cu cantitate mica.");
            System.out.println("Optiune : ");
            int optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune) {
                case 0:
                    ruleaza = false;
                    break;

               case 1:
                    System.out.print("Produsele din cos : ");
                    System.out.println(cos);
                    break;

                case 2:
                    System.out.print("Produsele expirate : ");
                    List<Produs>produseExpirate = cos.getProduseExpirate();

                    produseExpirate.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Introduceti denumirea produsului : ");
                    String denumire = scanner.nextLine();
                    System.out.print("Inrtroduceti cantitatea vanduta : ");
                    int cantitate = scanner.nextInt();
                    cos.vindeProdus(denumire,cantitate);
                    break;

                case 4:
                    System.out.println("Produse cu prețul minim:");
                    List<Produs> produseCuPretMinim = cos.getProduseCuPretMinim();
                    produseCuPretMinim.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Introduceți valoarea cantității: ");
                    int valoare = scanner.nextInt();
                    List<Produs> produseCuCantitateMica = cos.getProduseCuCantitateMaiMicaDecat(valoare);
                    try (PrintWriter writer = new PrintWriter("produse_cantitate_mica.txt")) {
                        for (Produs produs : produseCuCantitateMica) {
                            writer.println(produs);
                        }
                    } catch (IOException e) {
                        System.err.println("Eroare la salvarea produselor: " + e.getMessage());
                    }
                    break;

                default :
                    System.out.println("Optiune invalida meniului!!!\n");
                    break;
            }
        }
        scanner.close();
    }
}
