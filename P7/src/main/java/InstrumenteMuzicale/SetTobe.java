package InstrumenteMuzicale;

public class SetTobe extends InstrumentMuzical {

    // Enum pentru tipurile de tobe
    public enum TipTobe {
        ELECTRONICE,
        ACUSTICE
    }

    // Variabilele membre specifice clasei SetTobe
    private TipTobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    // Constructor pentru inițializarea atributelor
    public SetTobe(String producator, double pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);  // Apel la constructorul clasei de bază
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    // Gettere pentru tipul de tobe, numărul de tobe și numărul de cinele
    public TipTobe getTipTobe() {
        return tip_tobe;
    }

    public int getNrTobe() {
        return nr_tobe;
    }

    public int getNrCinele() {
        return nr_cinele;
    }

    // Implementarea metodei abstracte din clasa de bază
    @Override
    public String detalii() {
        return "SetTobe [Producator: " + producator + ", Pret: " + pret + " RON, Tip: " + tip_tobe + ", Numar tobe: " + nr_tobe + ", Numar cinele: " + nr_cinele + "]";
    }
}
