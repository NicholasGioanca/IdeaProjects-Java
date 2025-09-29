package Produse;

import java.time.LocalDate;

public class Produs {
   private String denumire;
   private double pret;
   private int cantitate;
   private LocalDate dataExpirarii;
   public static int incasari = 0;

   public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirarii) {
       this.denumire = denumire;
       this.pret = pret;
       this.cantitate = cantitate;
       this.dataExpirarii = dataExpirarii;
   }
   public String getDenumire() {
       return denumire;
   }
   public double getPret(){
       //return Double.toString(pret);
       return pret;
   }
   public int getCantitate(){
       return cantitate;
   }
   public LocalDate getDataExpirarii(){
       return dataExpirarii;
   }
   public void setCantitate(int cantitate){
       this.cantitate = cantitate;
   }
   public boolean esteExpirat(){
       return dataExpirarii.isBefore(LocalDate.now());
   }
   public static void actualizeazaIncasari(double suma){
       incasari += suma;
   }

   @Override
    public String toString(){
       return denumire + "," +pret + "," +cantitate + "," +dataExpirarii;
   }
}
