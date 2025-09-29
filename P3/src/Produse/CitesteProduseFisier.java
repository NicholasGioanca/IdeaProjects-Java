package Produse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CitesteProduseFisier {
    public static List<Produs> citesteProduseDinFisier(String filename) {
        List<Produs> produse = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                String[] data = line.split(",");
                String denumire = data[0];
                double pret = Double.parseDouble(data[1]);
                int cantitate = Integer.parseInt(data[2]);
                LocalDate dataExpirarii = LocalDate.parse(data[3], formatter);
                produse.add(new Produs(denumire, pret, cantitate, dataExpirarii));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
        }

        return produse;
    }

}
