package Electronice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp {
    public static List<Echipament> echipamente = new ArrayList<>();

    public static void main(String[] args) {
        echipamente = ControlerFisiere.incarcaEchipamenteDinFisier("electronice.txt");;
        Scanner scanner = new Scanner(System.in);
        boolean ruleaza = true;
        while (ruleaza) {
            System.out.println("\nMeniu:");
            System.out.println("0.Iesire");
            System.out.println("1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatoarelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea starii unui echipament.");
            System.out.println("6.Setarea modului de scriere pentru o imprimanta");
            System.out.println("7.Setarea formatului de copiere pentru un copiator");
            System.out.println("8.Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9.Afisarea echipamentelor vandute");
            System.out.println("10.Serializarea echipamentelor");
            System.out.println("11.Deserializarea echipamentelor");

            System.out.print("Optiune  : ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

             switch (optiune) {
                 case 0:
                     System.out.println("\nMeniu oprit! ");
                     ruleaza = false;
                     break;

                 case 1:
                     if (echipamente.isEmpty()) {
                         System.out.println("Nu exista echipamente inregistrate");
                     } else {
                         for (Echipament e : echipamente) {
                             System.out.println(e);
                         }
                     }
                     break;

                 case 2:
                     boolean exista = false;
                     for (Echipament e : echipamente) {
                         if (e instanceof Imprimanta) {
                             exista = true;
                             System.out.println(e);
                         }
                     }
                     if (!exista) {
                         System.out.println("Nu exista imprimante inregistrate");
                     }
                     break;

                 case 3:
                     boolean exist = false;
                     for (Echipament e : echipamente) {
                         if (e instanceof Imprimanta) {
                             exist = true;
                             System.out.println(e);
                         }
                     }
                     if (!exist) {
                         System.out.println("Nu exista copiatoare inregistrate");
                     }
                 case 4:
                     boolean exisa = false;
                     for (Echipament e : echipamente) {
                         if (e instanceof Imprimanta) {
                             exisa = true;
                             System.out.println(e);
                         }
                     }
                     if (!exisa) {
                         System.out.println("Nu exista sisteme de calcul inregistrate");
                     }

                 case 5:
                     System.out.print("Introduceti numarul de inventar al echipamentului :  ");
                     int nrInventar = scanner.nextInt();
                     scanner.nextLine();

                     Echipament echipamentGasit = null;
                     for (Echipament e : echipamente) {
                         if (e.nr_inv == nrInventar) {
                             echipamentGasit = e;
                             break;
                         }
                     }
                     if (echipamentGasit == null) {
                         System.out.println("Echipament gasit: " + echipamentGasit);
                         System.out.println("Selectati noua stare: ");
                         System.out.println("1. ACHIZITIONAT");
                         System.out.println("2. EXPUS");
                         System.out.println("3. VANDUT");
                         System.out.print("Optiune stare: ");
                         int StareNoua = scanner.nextInt();
                         scanner.nextLine();
                         boolean stare = true;
                         while (stare) {
                             switch (StareNoua) {
                                 case 1:
                                     echipamentGasit.setStare(StareEchipament.ACHIZITIONAT);
                                     stare = false;
                                     break;

                                 case 2:
                                     echipamentGasit.setStare(StareEchipament.EXPUS);
                                     stare = false;
                                     break;

                                 case 3:
                                     echipamentGasit.setStare(StareEchipament.VANDUT);
                                     stare = false;
                                     break;

                                 default:
                                     System.out.println("Stare invalida!");
                                     break;
                             }
                         }
                     }
                     break;

                 case 6:
                     System.out.print("Introduceti numarul de inventar al imprimantei: ");
                     int nrInvImprimanta = scanner.nextInt();
                     scanner.nextLine();

                     Echipament imprimantaGasita = null;
                     for (Echipament e : echipamente) {
                         if (e instanceof Imprimanta) {
                             if (e.nr_inv == nrInvImprimanta) {
                                 imprimantaGasita = e;
                                 break;
                             }
                         }
                     }
                     if (imprimantaGasita != null) {
                         System.out.println("Imprimanta gasita: " + imprimantaGasita);
                         System.out.println("Selectati noul mod de tiparire: ");
                         System.out.println("1. COLOR");
                         System.out.println("2. ALB_NEGRU");
                         System.out.print("Optiune Tiparire: ");
                         int OptiuneTiparire = scanner.nextInt();
                         scanner.nextLine();
                         boolean tiparire = true;

                         ModTiparire modTiparireSelectat = null;
                         while (tiparire) {
                             switch (OptiuneTiparire) {
                                 case 1:
                                     modTiparireSelectat = ModTiparire.COLOR;
                                     tiparire = false;
                                     break;

                                 case 2:
                                     modTiparireSelectat = ModTiparire.ALB_NEGRU;
                                     tiparire = false;
                                     break;

                                 default:
                                     System.out.println("Mod tiparire invalid!");
                                     break;
                             }
                         }

                         assert false;
                         ((Imprimanta) imprimantaGasita).setModTiparire(modTiparireSelectat);
                         System.out.println("Modul de tiparire actualizat: " + modTiparireSelectat);
                         System.out.println(imprimantaGasita);
                     }else{
                         System.out.println("Imprimanta cu nu numarul de inventar "+ nrInvImprimanta + " nu a fost gasita.");
                     }
                     break;

                 case 7:
                     System.out.print("Introduceti numarul de inventar al copiatorului: ");
                     int nrInvCopiator = scanner.nextInt();
                     scanner.nextLine();

                     Echipament copiatorGasit = null;
                     for(Echipament e : echipamente) {
                         if (e.nr_inv == nrInvCopiator) {
                             if(e.nr_inv == nrInvCopiator){
                                 copiatorGasit = e;
                                 break;
                             }
                         }
                     }
                     if (copiatorGasit != null) {
                         System.out.println("Copiator gasit: " + copiatorGasit);
                         System.out.println("Selectati noul format de copiere: ");
                         System.out.println("1. A3");
                         System.out.println("2. A4");
                         System.out.print("Optiune format copiere: ");
                         int OptiuneCopiere = scanner.nextInt();
                         scanner.nextLine();
                         boolean copiere = true;

                         FormatCopiere formatSelectat = null ;
                         while (copiere) {
                             switch (OptiuneCopiere) {
                                 case 1:
                                     formatSelectat = FormatCopiere.A3;
                                     copiere = false;
                                     break;

                                 case 2:
                                     formatSelectat = FormatCopiere.A4;
                                     copiere = false;
                                     break;

                                 default:
                                     System.out.println("Optiune format copiere invalid!");
                                     break;
                             }
                         }
                         ((Copiator) copiatorGasit).setFormat(formatSelectat);
                         System.out.println("Formatul de copiere actualuzat: " + formatSelectat);
                         System.out.println(copiatorGasit);
                     }else{
                         System.out.println("Copiatorul cu numaruk de inventar "+ nrInvCopiator + " nu a fost gasit.");
                     }
                     break;

                 case 8:
                     System.out.print("Introduceti numarul de inventar al sistemului de calcul : ");
                     int nrInvSistemCalcul = scanner.nextInt();
                     scanner.nextLine();

                     Echipament sistemCalculGasit = null;
                     for(Echipament e : echipamente) {
                         if(e instanceof SistemCalcul){
                             if(e.nr_inv == nrInvSistemCalcul){
                                 sistemCalculGasit= e;
                                 break;
                             }
                         }
                     }
                     if(sistemCalculGasit != null) {
                         System.out.println("Sistemului gasit: " + sistemCalculGasit);
                         System.out.println("Selectati noul sistem de operare: ");
                         System.out.println("1. Windows");
                         System.out.println("2. Linux");
                         System.out.print("Optiune sistem operare: ");
                         int optiuneSistemOperare = scanner.nextInt();
                         scanner.nextLine();

                         boolean sistemOperare = true;
                         SistemOperare sistemOperareSelectat = null;
                         while(sistemOperare) {
                             switch (optiuneSistemOperare) {
                                 case 1:
                                     sistemOperareSelectat = SistemOperare.Windows;
                                     sistemOperare = false;
                                     break;

                                 case 2:
                                     sistemOperareSelectat = SistemOperare.Linux;
                                     sistemOperare = false;
                                     break;

                                 default:
                                     System.out.println("Optiune sistem operare invalida!");
                                     break;
                             }
                         }
                         ((SistemCalcul) sistemCalculGasit).setSistemOperare(sistemOperareSelectat);
                         System.out.println("Sistemul de operare actualizat:  " + sistemOperareSelectat);
                         System.out.println(sistemCalculGasit);
                     }else{
                         System.out.println("Sistemul de calcul cu numarul de inventar" + nrInvSistemCalcul + " nu a fost gasit.");
                     }
                     break;

                 case 9:
                     System.out.println("Echipamente vandute: ");
                     boolean gasit = false;
                     for(Echipament e : echipamente) {
                         if(e.getStare() == StareEchipament.VANDUT){
                             System.out.println(e);
                             gasit = true;
                         }
                     }
                     if(!gasit){
                         System.out.println("Nu exista echipamnte vandute!");
                     }
                     break;

                 case 10:
                     try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("echip.bin"))){
                         oos.writeObject(echipamente);
                         System.out.println("Echipamentele au fost serializate cu succes in 'echip.bin'.");
                     }catch(IOException e){
                         System.out.println("Eroare la serializarea echipamentelor.");
                     }
                     break;

                 case 11:
                     try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("echip.bin"))) {
                         echipamente = (List<Echipament>) ois.readObject();
                         System.out.println("Echipamentele au fost deserealizate cu succes din 'echip.bin'.");
                     }catch(IOException e){
                         System.out.println("Eroare la deserializarea echipamentelor.");
                     }catch(ClassNotFoundException e){
                         System.out.println("Clasa nu a fost gasita.");
                     }
                     break;

                 default:
                     System.out.println("Optiune invalida.");
                     break;
             }
        }
    }
}
