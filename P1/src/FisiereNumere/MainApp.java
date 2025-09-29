package FisiereNumere;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args){
        String inputFileNAme = "in.txt";
        String outputFileName = "out.txt";

        List<Integer> Numere = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileNAme))) {
            String linie;
            while((linie = reader.readLine()) != null)
            {
                Numere.add(Integer.parseInt(linie.trim()));
            }
        }catch(IOException e){
            System.out.println("Eroare la citirea fisierului: "+e.getMessage());
            return;
        }

        //Verificam daca au fost citite numerele
        if(Numere.isEmpty()) {
            System.out.println("Fisierul nu contine numere.");
            return;
        }

        int suma=0;
        int minim = Integer.MAX_VALUE;
        int maxim = Integer.MIN_VALUE;

        for(int numar : Numere) {
            suma = suma + numar;
            if(numar < minim)
                minim = numar;
            if(numar > maxim)
                maxim = numar;
        }
        double media = (double) suma / Numere.size();
        System.out.println("Fisierul numeri: "+Numere);
        System.out.println("Suma : "+suma);
        System.out.println("Minim : "+minim);
        System.out.println("Maxim : "+maxim);
        System.out.println("Media : "+media);

        //Scrierea in fisier

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))){
            writer.write("Suma: "+suma);
            writer.write(" Minim: "+minim);
            writer.write(" Maxim: "+maxim);
            writer.write(" Media: "+media);

        }catch(IOException e){
            System.out.println("Eroare la scrierea in fisier: "+e.getMessage());
        }
    }
}
