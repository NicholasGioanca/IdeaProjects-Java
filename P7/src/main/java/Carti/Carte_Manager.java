package Carti;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Carte_Manager {
    private Map<Integer, Carte> carti;

    // Constructor
    public Carte_Manager() {
        carti = new HashMap<>();
    }

    // Load data from JSON file
    public void incarcaCartiDinFisier(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, Carte> cartiDinFisier = mapper.readValue(new File(filePath), new TypeReference<>() {});
        carti.putAll(cartiDinFisier);
    }

    // Save data to JSON file
    public void salveazaCartiInFisier(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), carti);
    }

    // Add a new book
    public void adaugaCarte(int id, Carte carte) {
        carti.putIfAbsent(id, carte);
    }

    // Remove a book
    public void stergeCarte(int id) {
        carti.remove(id);
    }

    // Display all books
    public void afiseazaCarti() {
        carti.forEach((id, carte) -> System.out.println("ID: " + id + ", " + carte));
    }

    // Extract books by a specific author
    public Set<Carte> cartiDeAutor(String autor) {
        return carti.values().stream()
                .filter(carte -> carte.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toSet());
    }

    // Sort and display books by title
    public void afiseazaCartiOrdonateDupaTitlu() {
        carti.values().stream()
                .sorted(Comparator.comparing(Carte::getTitlu))
                .forEach(System.out::println);
    }

    // Display the oldest book
    public void afiseazaCeaMaiVecheCarte() {
        Optional<Carte> ceaMaiVecheCarte = carti.values().stream()
                .min(Comparator.comparingInt(Carte::getAnAparitie));

        ceaMaiVecheCarte.ifPresent(carte -> System.out.println("Cea mai veche carte: " + carte));
    }

    // Getters for testing or further usage
    public Map<Integer, Carte> getCarti() {
        return carti;
    }
}
