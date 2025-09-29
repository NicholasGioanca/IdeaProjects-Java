package Carti;

import java.io.IOException;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {
        Carte_Manager manager = new Carte_Manager();

        // Path to JSON file
        String filePath = "carti.json";

        try {
            // Load books from JSON file
            manager.incarcaCartiDinFisier(filePath);

            // Display all books
            System.out.println("\nToate cartile:");
            manager.afiseazaCarti();

            // Add a new book
            Carte carteNoua = new Carte("Homo Deus", "Yuval Noah Harari", 2016);
            manager.adaugaCarte(5, carteNoua);

            // Remove a book
            manager.stergeCarte(2);

            // Save changes back to the JSON file
            manager.salveazaCartiInFisier(filePath);

            // Display books by Yuval Noah Harari
            System.out.println("\nCarti de Yuval Noah Harari:");
            Set<Carte> cartiHarari = manager.cartiDeAutor("Yuval Noah Harari");
            cartiHarari.forEach(System.out::println);

            // Display books sorted by title
            System.out.println("\nCarti ordonate dupa titlu:");
            manager.afiseazaCartiOrdonateDupaTitlu();

            // Display the oldest book
            System.out.println("\nCea mai veche carte:");
            manager.afiseazaCeaMaiVecheCarte();

        } catch (IOException e) {
            System.err.println("Eroare la manipularea fisierului JSON: " + e.getMessage());
        }
    }
}

