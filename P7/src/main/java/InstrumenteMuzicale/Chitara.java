package InstrumenteMuzicale;

public class Chitara extends InstrumentMuzical {

    // Enum pentru tipurile de chitare
    public enum TipChitara {
        ELECTRICA,
        ACUSTICA,
        CLASICA
    }

    // Variabilele membre specifice clasei Chitara
    private TipChitara tip_chitara;
    private int nr_corzi;

    // Constructor pentru inițializarea atributelor
    public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);  // Apel la constructorul clasei de bază
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }

    // Gettere pentru tipul chitarei și numărul de corzi
    public TipChitara getTipChitara() {
        return tip_chitara;
    }

    public int getNrCorzi() {
        return nr_corzi;
    }

    // Implementarea metodei abstracte din clasa de bază
    @Override
    public String detalii() {
        return "Chitara [Producator: " + producator + ", Pret: " + pret + " RON, Tip: " + tip_chitara + ", Numar corzi: " + nr_corzi + "]";
    }
}
