package Electronice;

import java.io.Serializable;

public abstract class Echipament implements Serializable {
    protected String denumire;
    protected int nr_inv;
    protected double pret;
    protected String zona_mag;
    protected StareEchipament stare;
    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, StareEchipament stare){
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }
    public StareEchipament getStare(){
        return stare;
    }
    public void setStare(StareEchipament stare){
        this.stare = stare;
    }
    @Override
    public String toString(){
        return "Denumire: " + denumire + "Nr Inventar: " + nr_inv+ " Pret  : " + pret
                + " Zona Mag: " + zona_mag + " Echipament: " + stare;
    }
}
