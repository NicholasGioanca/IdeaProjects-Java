package Electronice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlerFisiere {
    public static List<Echipament> incarcaEchipamenteDinFisier(String numeFisier) {
        List<Echipament> echipamente = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // sau alt separator
                // Exemplu: asumăm că fiecare linie conține informațiile necesare pentru fiecare tip de echipament

                String tip = parts[0]; // Tipul de echipament (Imprimanta, Copiator, SistemCalcul)
                String denumire = parts[1];
                int nr_inv = Integer.parseInt(parts[2]);
                double pret = Double.parseDouble(parts[3]);
                String zona_mag = parts[4];
                StareEchipament stare = StareEchipament.valueOf(parts[5].trim());

                // Creăm echipamentul pe baza tipului
                switch (tip) {
                    case "Imprimanta":
                        int ppm = Integer.parseInt(parts[6]);
                        int dpi = Integer.parseInt(parts[7]);
                        int p_car = Integer.parseInt(parts[8]);
                        ModTiparire modTiparire = ModTiparire.valueOf(parts[9].trim());
                        echipamente.add(new Imprimanta(denumire, nr_inv, pret, ppm, dpi, p_car, modTiparire, zona_mag, stare));
                        break;
                    case "Copiator":
                        int p_ton = Integer.parseInt(parts[6]);
                        FormatCopiere format = FormatCopiere.valueOf(parts[7].trim());
                        echipamente.add(new Copiator(denumire, nr_inv, pret, zona_mag, stare, p_ton, format));
                        break;
                    case "SistemCalcul":
                        String tip_mon = parts[6];
                        double vit_proc = Double.parseDouble(parts[7]);
                        int c_hdd = Integer.parseInt(parts[8]);
                        SistemOperare sistemOperare = SistemOperare.valueOf(parts[9].trim());
                        echipamente.add(new SistemCalcul(denumire, nr_inv, pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, sistemOperare));
                        break;
                    default:
                        System.out.println("Tip de echipament necunoscut: " + tip);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisier: " + e.getMessage());
        }
        return echipamente;
    }
}
