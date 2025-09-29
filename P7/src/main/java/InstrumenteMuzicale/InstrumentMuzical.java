package InstrumenteMuzicale;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class InstrumentMuzical {
    protected String producator;
    protected double pret;

    // Constructor pentru inițializarea producătorului și prețului
    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    // Gettere pentru producator și pret
    public String getProducator() {
        return producator;
    }

    public double getPret() {
        return pret;
    }

    // Metodă abstractă care poate fi implementată de clasele derivate
    public abstract String detalii();
}