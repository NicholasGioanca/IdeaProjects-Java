package Electronice;

public class SistemCalcul extends Echipament{
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public SistemCalcul(String denumire,int nr_inv,double pret,String zona_mag,StareEchipament stare,String tip_mon, double vit_proc, int c_hdd,SistemOperare sistemOperare) {
        super(denumire,nr_inv,pret,zona_mag,stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }
    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }
    @Override
    public String toString() {
        return super.toString() + ", Monitor: " + tip_mon + " Viteza procesor: " + vit_proc +
                " Capacitate HDD: " + c_hdd + " Sisstem operare : " + sistemOperare;
    }
}
