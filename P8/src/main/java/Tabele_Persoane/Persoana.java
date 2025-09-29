package Tabele_Persoane;

public class Persoana {
    private int id;
    private String nume;
    private int varsta;

    // Constructor
    public Persoana(int id, String nume, int varsta) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
    }

    // Getters și Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    // Metodă pentru a afișa detaliile unei persoane
    public void afiseazaDetalii() {
        System.out.println("ID: " + id + ", Nume: " + nume + ", Vârstă: " + varsta);
    }
}
