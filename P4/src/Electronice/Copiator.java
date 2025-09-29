package Electronice;

import java.io.Serializable;

public class Copiator extends Echipament {
    private int p_ton;
    private FormatCopiere format;
    public Copiator(String denumire, int nr_inv, double pret,String zona_mag, StareEchipament stare,int p_ton, FormatCopiere format){
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }
    public void setFormat(FormatCopiere format){
        this.format = format;
    }
    @Override
    public String toString(){
        return super.toString()+"["+p_ton+","+format+"]";
    }
}
