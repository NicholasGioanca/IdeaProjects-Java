package Carti;

import java.util.Objects;

public class Carte {
    private String titlu;
    private String autor;
    private int anAparitie;

    // Constructor
    public Carte(String titlu, String autor, int anAparitie) {
        this.titlu = titlu;
        this.autor = autor;
        this.anAparitie = anAparitie;
    }

    // Getters
    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    // Setters
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnAparitie(int anAparitie) {
        this.anAparitie = anAparitie;
    }

    // toString method
    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", anAparitie=" + anAparitie +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return anAparitie == carte.anAparitie &&
                Objects.equals(titlu, carte.titlu) &&
                Objects.equals(autor, carte.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titlu, autor, anAparitie);
    }
}
