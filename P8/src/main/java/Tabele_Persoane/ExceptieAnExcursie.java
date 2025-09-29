package Tabele_Persoane;

public class ExceptieAnExcursie extends Exception {
    // Constructor
    public ExceptieAnExcursie(String mesaj) {
        super(mesaj); // transmite mesajul la clasa de bază
    }
}
