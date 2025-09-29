package Tabele_Persoane;

public class Excursie {
    private int idPersoana; // ID-ul persoanei care a făcut excursia
    private int idExcursie; // ID-ul excursiei
    private String destinatia; // Destinația excursiei
    private int anul; // Anul în care s-a făcut excursia

    // Constructor
    public Excursie(int idPersoana, int idExcursie, String destinatia, int anul) {
        this.idPersoana = idPersoana;
        this.idExcursie = idExcursie;
        this.destinatia = destinatia;
        this.anul = anul;
    }

    // Getters și Setters
    public int getIdPersoana() {
        return idPersoana;
    }

    public void setIdPersoana(int idPersoana) {
        this.idPersoana = idPersoana;
    }

    public int getIdExcursie() {
        return idExcursie;
    }

    public void setIdExcursie(int idExcursie) {
        this.idExcursie = idExcursie;
    }

    public String getDestinatia() {
        return destinatia;
    }

    public void setDestinatia(String destinatia) {
        this.destinatia = destinatia;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    // Metodă pentru a afișa detaliile unei excursii
    public void afiseazaDetalii() {
        System.out.println("ID Persoana: " + idPersoana + ", ID Excursie: " + idExcursie +
                ", Destinație: " + destinatia + ", Anul: " + anul);
    }
}
