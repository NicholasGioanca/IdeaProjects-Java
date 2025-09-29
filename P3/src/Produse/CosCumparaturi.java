package Produse;

import java.util.ArrayList;
import java.util.List;

public class CosCumparaturi {
    private List<Produs> produse;

    public CosCumparaturi(){
        this.produse = new ArrayList<>();
    }

    public void adaugaProdus(Produs produs){
        this.produse.add(produs);
    }
    public void eliminaProdus(Produs produs){
        this.produse.remove(produs);
    }
    public double calculeazaTotal(){
        double total = 0;
        for(Produs produs: produse){
            total = total + produs.getPret() * produs.getCantitate();
        }
        return total;
    }
    public List<Produs> getProduse() {
        return produse;
    }
    public List<Produs> getProduseExpirate(){
        List<Produs> produseExpirate = new ArrayList<>();
        for(Produs produs: produse){
            if(produs.esteExpirat()){
                produseExpirate.add(produs);
            }
        }
        return produseExpirate;
    }
    public void vindeProdus(String denumire, int cantitate) {
        for (Produs produs : produse) {
            if (produs.getDenumire().equalsIgnoreCase(denumire)) {
                if (produs.getCantitate() >= cantitate) {
                    produs.setCantitate(produs.getCantitate() - cantitate);
                    Produs.actualizeazaIncasari(produs.getPret() * cantitate);
                    if (produs.getCantitate() == 0) {
                        eliminaProdus(produs);
                    }
                    return;
                } else {
                    System.out.println("Cantitate insuficientă pe stoc!");
                    return;
                }
            }
        }
        System.out.println("Produsul nu a fost găsit în coș!");
    }
    public List<Produs> getProduseCuPretMinim() {
        List<Produs> produseCuPretMinim = new ArrayList<>();
        double pretMinim = Double.MAX_VALUE;
        for (Produs produs : produse) {
            if (produs.getPret() < pretMinim) {
                pretMinim = produs.getPret();
            }
        }
        for (Produs produs : produse) {
            if (produs.getPret() == pretMinim) {
                produseCuPretMinim.add(produs);
            }
        }
        return produseCuPretMinim;
    }
    public List<Produs> getProduseCuCantitateMaiMicaDecat(int cantitate) {
        List<Produs> produseCuCantitateMica = new ArrayList<>();
        for (Produs produs : produse) {
            if (produs.getCantitate() < cantitate) {
                produseCuCantitateMica.add(produs);
            }
        }
        return produseCuCantitateMica;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Produs produs: produse){
            sb.append(produs).append("\n");
        }
        return sb.toString();
    }
}
