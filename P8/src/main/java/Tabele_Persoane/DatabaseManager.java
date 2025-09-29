package Tabele_Persoane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/lab8"; // URL-ul bazei de date
    private static final String USER = "root"; // Numele utilizatorului
    private static final String PASSWORD = ""; // Parola utilizatorului (lasă goală dacă nu este setată)

    // Conectare la baza de date
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Adăugarea unei persoane în tabela persoane
    public void adaugaPersoana(Persoana persoana) throws SQLException {
        String query = "INSERT INTO persoane (nume, varsta) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, persoana.getNume());
            stmt.setInt(2, persoana.getVarsta());
            stmt.executeUpdate();
        }
    }

    // Adăugarea unei excursii în tabela excursii
    public void adaugaExcursie(Excursie excursie) throws SQLException {
        // Verificăm dacă persoana există în tabela persoane
        String checkQuery = "SELECT id FROM persoane WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmtCheck = conn.prepareStatement(checkQuery)) {
            stmtCheck.setInt(1, excursie.getIdPersoana());
            ResultSet rs = stmtCheck.executeQuery();

            if (!rs.next()) {
                System.out.println("Persoana cu ID-ul " + excursie.getIdPersoana() + " nu există!");
                return;
            }
        }

        // Dacă persoana există, adăugăm excursia
        String insertQuery = "INSERT INTO excursii (id_persoana, destinatia, anul) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setInt(1, excursie.getIdPersoana());
            stmt.setString(2, excursie.getDestinatia());
            stmt.setInt(3, excursie.getAnul());
            stmt.executeUpdate();
        }
    }

    // Afișarea tuturor persoanelor și excursiilor lor
    public List<Persoana> afiseazaPersoaneCuExcursii() throws SQLException {
        List<Persoana> persoane = new ArrayList<>();
        String query = "SELECT p.id, p.nume, p.varsta, e.id_excursie, e.destinatia, e.anul " +
                "FROM persoane p LEFT JOIN excursii e ON p.id = e.id_persoana";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");

                // Verificăm dacă persoana există deja în lista de persoane
                Persoana persoana = null;
                for (Persoana p : persoane) {
                    if (p.getId() == id) {
                        persoana = p;
                        break;
                    }
                }

                if (persoana == null) {
                    persoana = new Persoana(id, nume, varsta);
                    persoane.add(persoana);
                }

                // Adăugăm excursia la persoana corespunzătoare
                int idExcursie = rs.getInt("id_excursie");
                String destinatia = rs.getString("destinatia");
                int anul = rs.getInt("anul");
                if (idExcursie > 0) {
                    persoana.afiseazaDetalii(); // Afișează informațiile despre excursii
                }
            }
        }
        return persoane;
    }

    // Afișarea excursiilor unei persoane după nume
    public List<Excursie> afiseazaExcursiiPentruPersoana(String nume) throws SQLException {
        List<Excursie> excursii = new ArrayList<>();
        String query = "SELECT e.id_excursie, e.destinatia, e.anul " +
                "FROM excursii e JOIN persoane p ON e.id_persoana = p.id WHERE p.nume = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nume);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idExcursie = rs.getInt("id_excursie");
                String destinatia = rs.getString("destinatia");
                int anul = rs.getInt("anul");
                excursii.add(new Excursie(0, idExcursie, destinatia, anul)); // ID-ul persoanei nu este necesar pentru excursie
            }
        }
        return excursii;
    }

    // Afișarea Destinatiilor
    public List<Excursie> afiseazaPersoaneDestinatie(String nume) throws SQLException {
        List<Excursie> excursii = new ArrayList<>();
        String query = "SELECT  e.destinatia " +
                "FROM excursii e JOIN persoane p ON e.id_persoana = p.id WHERE p.nume = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nume);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idExcursie = rs.getInt("id_excursie");
                String destinatia = rs.getString("destinatia");
                int anul = rs.getInt("anul");
                excursii.add(new Excursie(0, idExcursie, destinatia, anul)); // ID-ul persoanei nu este necesar pentru excursie
            }
        }
        return excursii;
    }

    // Afișarea Destinatiilor
    public List<Excursie> afiseazaPersoaneAnExcursie(String nume) throws SQLException {
        List<Excursie> excursii = new ArrayList<>();
        String query = "SELECT  e.An " +
                "FROM excursii e JOIN persoane p ON e.id_persoana = p.id WHERE p.nume = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nume);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idExcursie = rs.getInt("id_excursie");
                String destinatia = rs.getString("destinatia");
                int anul = rs.getInt("anul");
                excursii.add(new Excursie(0, idExcursie, destinatia, anul)); // ID-ul persoanei nu este necesar pentru excursie
            }
        }
        return excursii;
    }






    // Ștergerea unei excursii
    public void stergeExcursie(int idExcursie) throws SQLException {
        String query = "DELETE FROM excursii WHERE id_excursie = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idExcursie);
            stmt.executeUpdate();
        }
    }

    // Ștergerea unei persoane și a excursiilor sale
    public void stergePersoana(int idPersoana) throws SQLException {
        String deleteExcursiiQuery = "DELETE FROM excursii WHERE id_persoana = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(deleteExcursiiQuery)) {
            stmt.setInt(1, idPersoana);
            stmt.executeUpdate();
        }

        String deletePersoanaQuery = "DELETE FROM persoane WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(deletePersoanaQuery)) {
            stmt.setInt(1, idPersoana);
            stmt.executeUpdate();
        }
    }
}
