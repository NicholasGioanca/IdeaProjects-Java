package Sir_Caractere;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sacnner = new Scanner(System.in);
        System.out.print("Introduceti sirul de caractere : ");

        String sirPrincipal = sacnner.nextLine();

        StringBuilder sb = new StringBuilder(sirPrincipal);

        System.out.print("Introduceti sirul care va fi inserat : ");
        String sirDeInserat = sacnner.nextLine();

        System.out.print("Introduceti pozitia de inserare : ");
        int pozitieInserare = sacnner.nextInt();

        if(pozitieInserare >=0 && pozitieInserare < sb.length()) {
            sb.insert(pozitieInserare,sirDeInserat);
            System.out.println("Sirul dupa inserare : "+sb.toString());
        }else{
            System.out.println("Nu se poate insera ");
        }

        System.out.print("Introduceti pozitia de stergere: ");
        int pozitieStergere = sacnner.nextInt();

        System.out.print("Introduceti numarul de caractere pe care vreti sa il stergeti : ");
        int nrCaractereSterse = sacnner.nextInt();

        if(pozitieStergere >=0 && pozitieStergere + nrCaractereSterse < sb.length()) {
            sb.delete(pozitieStergere,pozitieStergere + nrCaractereSterse);
            System.out.println("Sirul dupa stergere : "+sb.toString());
        }else {
            System.out.println("Nu se poate sterge ");
        }
    }
}
