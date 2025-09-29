package Electronice;

public class Imprimanta extends Echipament{
    private int ppm;
    private int dpi;
    private int p_car;
    private ModTiparire modTiparire;
    public Imprimanta(String denumire, int nr_inv, double pret, int ppm, int dpi,int p_car, ModTiparire modTiparire, String zona_mag, StareEchipament stare){
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }
    public void setModTiparire(ModTiparire modTiparire){
        this.modTiparire = modTiparire;
    }
    @Override
    public String toString(){
        return super.toString() + ", PPM: " + ppm + ", dpi: " + dpi + "Pagini/Cartus "+p_car+  "modTiparire: " + modTiparire;
    }
}
