package Tabele_Persoane;

public class ExceptieVarsta extends Exception {
    // Constructor
    public ExceptieVarsta(String mesaj) {
        super(mesaj); // transmite mesajul la clasa de bază
    }
}
