package Tabele_Persoane;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DatabaseManager dbManager = new DatabaseManager();

    public static void main(String[] args) {
        while (true) {
            afiseazaMeniu();
            int optiune = citesteOptiune();
            switch (optiune) {
                case 1:
                    adaugaPersoana();
                    break;
                case 2:
                    adaugaExcursie();
                    break;
                case 3:
                    afiseazaPersoaneCuExcursii();
                    break;
                case 4:
                    afiseazaExcursiiPersoana();
                    break;
                case 5:
                    afiseazaPersoaneDestinatie();
                    break;
                case 6:
                    afiseazaPersoaneAnExcursie();
                    break;
                case 7:
                    stergeExcursie();
                    break;
                case 8:
                    stergePersoana();
                    break;
                case 0:
                    System.out.println("Ieșire din aplicație.");
                    return;
                default:
                    System.out.println("Opțiune invalidă, încercați din nou.");
            }
        }
    }

    // Afișează meniul principal
    public static void afiseazaMeniu() {
        System.out.println("\nMeniu:");
        System.out.println("1. Adăugare persoană");
        System.out.println("2. Adăugare excursie");
        System.out.println("3. Afișare persoane și excursiile lor");
        System.out.println("4. Afișare excursii pentru o persoană");
        System.out.println("5. Afișare persoane care au vizitat o destinație");
        System.out.println("6. Afișare persoane care au făcut excursii într-un an");
        System.out.println("7. Șterge excursie");
        System.out.println("8. Șterge persoană și excursiile sale");
        System.out.println("0. Ieșire");
    }

    // Citirea opțiunii de la utilizator
    public static int citesteOptiune() {
        System.out.print("Alegeți o opțiune: ");
        return scanner.nextInt();
    }

    // Adăugarea unei persoane
    public static void adaugaPersoana() {
        System.out.print("Introduceti numele persoanei: ");
        scanner.nextLine();  // Consumăm newline-ul rămas
        String nume = scanner.nextLine();

        System.out.print("Introduceti varsta persoanei: ");
        int varsta = citesteVarsta();

        Persoana persoana = new Persoana(0, nume, varsta); // ID-ul va fi generat automat
        try {
            dbManager.adaugaPersoana(persoana);
            System.out.println("Persoana a fost adăugată cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea persoanei: " + e.getMessage());
        }
    }

    // Adăugarea unei excursii
    public static void adaugaExcursie() {
        System.out.print("Introduceti ID-ul persoanei: ");
        int idPersoana = scanner.nextInt();

        System.out.print("Introduceti destinatia excursiei: ");
        scanner.nextLine(); // Consumăm newline-ul rămas
        String destinatia = scanner.nextLine();

        System.out.print("Introduceti anul excursiei: ");
        int anul = citesteAnExcursie();

        Excursie excursie = new Excursie(idPersoana, 0, destinatia, anul); // ID-ul excursiei va fi generat automat
        try {
            dbManager.adaugaExcursie(excursie);
            System.out.println("Excursia a fost adăugată cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea excursiei: " + e.getMessage());
        }
    }

    // Afișarea persoanelor și excursiilor lor
    public static void afiseazaPersoaneCuExcursii() {
        try {
            List<Persoana> persoane = dbManager.afiseazaPersoaneCuExcursii();
            for (Persoana persoana : persoane) {
                persoana.afiseazaDetalii();
            }
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea persoanelor și excursiilor lor: " + e.getMessage());
        }
    }

    // Afișarea excursiilor pentru o persoană
    public static void afiseazaExcursiiPersoana() {
        System.out.print("Introduceti numele persoanei: ");
        scanner.nextLine(); // Consumăm newline-ul rămas
        String nume = scanner.nextLine();

        try {
            List<Excursie> excursii = dbManager.afiseazaExcursiiPentruPersoana(nume);
            if (excursii.isEmpty()) {
                System.out.println("Persoana nu are excursii.");
            } else {
                for (Excursie excursie : excursii) {
                    excursie.afiseazaDetalii();
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea excursiilor persoanei: " + e.getMessage());
        }
    }

    // Afișarea persoanelor care au vizitat o destinație
    public static void afiseazaPersoaneDestinatie() {
        System.out.print("Introduceti destinatia: ");
        scanner.nextLine(); // Consumăm newline-ul rămas
        String destinatia = scanner.nextLine();

        try {
            List<Excursie> persoane = dbManager.afiseazaPersoaneDestinatie(destinatia);
            if (persoane.isEmpty()) {
                System.out.println("Nu există persoane care au vizitat această destinație.");
            } else {
                for (Excursie persoana : persoane) {
                    persoana.afiseazaDetalii();
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea persoanelor care au vizitat destinația: " + e.getMessage());
        }
    }

    // Afișarea persoanelor care au făcut excursii într-un anumit an
    public static void afiseazaPersoaneAnExcursie() {
        System.out.print("Introduceti anul excursiei: ");
        int an = scanner.nextInt();

        try {
            List<Excursie> persoane = dbManager.afiseazaPersoaneAnExcursie(String.valueOf(an));
            if (persoane.isEmpty()) {
                System.out.println("Nu există persoane care au făcut excursii în acest an.");
            } else {
                for (Excursie persoana : persoane) {
                    persoana.afiseazaDetalii();
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare la afișarea persoanelor din anul respectiv: " + e.getMessage());
        }
    }

    // Ștergerea unei excursii
    public static void stergeExcursie() {
        System.out.print("Introduceti ID-ul excursiei de șters: ");
        int idExcursie = scanner.nextInt();

        try {
            dbManager.stergeExcursie(idExcursie);
            System.out.println("Excursia a fost ștearsă cu succes.");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea excursiei: " + e.getMessage());
        }
    }

    // Ștergerea unei persoane și a excursiilor sale
    public static void stergePersoana() {
        System.out.print("Introduceti ID-ul persoanei de șters: ");
        int idPersoana = scanner.nextInt();

        try {
            dbManager.stergePersoana(idPersoana);
            System.out.println("Persoana și excursiile sale au fost șterse cu succes.");
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea persoanei: " + e.getMessage());
        }
    }

    // Citirea vârstei de la tastatură (cu validare)
    public static int citesteVarsta() {
        int varsta;
        while (true) {
            try {
                varsta = scanner.nextInt();
                if (varsta < 0 || varsta > 120) {
                    throw new Exception("Vârsta nu este validă. Introduceți o valoare între 0 și 120.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // Consumăm newline-ul
            }
        }
        return varsta;
    }

    // Citirea anului excursiei (cu validare)
    public static int citesteAnExcursie() {
        int an;
        while (true) {
            try {
                an = scanner.nextInt();
                int anCurent = java.time.Year.now().getValue();
                if (an < 1900 || an > anCurent) {
                    throw new Exception("Anul nu este valid. Introduceți un an între 1900 și anul curent.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // Consumăm newline-ul
            }
        }
        return an;
    }
}
