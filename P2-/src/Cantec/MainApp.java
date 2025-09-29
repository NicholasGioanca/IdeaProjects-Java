/*
Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
intrare. /
 */
package Cantec;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class Vers {

    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int numarCuvinte() {
        if (vers.trim().isEmpty()) {
            return 0;
        }
        return vers.trim().split("\\s+").length;
    }

    //numarul de vocale din vers
    public int numarVocale() {
        int nr = 0;
        String vocale = "aeiouAEIOU";
        for (char c : vers.toCharArray()) {
            if (vocale.indexOf(c) != -1) {
                nr++;
            }
        }
        return nr;
    }

    //daca versul se termina cu un grup de litere
    public boolean seTerminaCu(String grup) {
        return vers.endsWith(grup);
    }

    //versul in majuscule
    public String VersMajuscule() {
        return vers.toUpperCase();
    }

    public String getVers() {
        return vers;
    }
}
public class MainApp {
    public static void main(String[] args) {
        Random random = new Random();
        //String grupFinal = new Random().toString();
        String grupFinal = "la";
        ArrayList<Vers> Versuri = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("cantec_in.txt"))){
            String linie;
            while((linie = reader.readLine()) != null){
                Versuri.add(new Vers(linie));
            }
        }catch(IOException e){
            System.out.println("Eroare la citirea din fisier");
            e.printStackTrace();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("cantec_out.txt"))){
            for(Vers v : Versuri){
                int numarCuvinte = v.numarCuvinte();
                int numarVocale = v.numarVocale();
                String linie = v.getVers();

                //daca versul generat este mai mic decat 0.1
                if(random.nextDouble() < 0.1){
                    linie = v.VersMajuscule();
                }

                //daca versul se termina cu grupul de litere ales
                if(v.seTerminaCu(grupFinal)){
                    linie += " *";
                }
                writer.write(linie + " [Cuvinte: " + numarCuvinte + " Vocale " + numarVocale + " ]");
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Eroare la scrierea in fisier");
            e.printStackTrace();
        }
    }
}




