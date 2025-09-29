package Nume_CNP;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Persoana{
    private String nume;
    private String CNP;

    //constructor
    protected Persoana(String nume, String CNP){
        this.CNP = CNP;
    }
    protected String getNume(){
        return nume;
    }
    protected String getCNP(){
        return CNP;
    }
    protected String setCNP(String CNP){
        this.CNP = CNP;
        return CNP;
    }
    protected int getVarsta(){
        if(CNP.length() != 13){
            return -1;
        }
        int anulNasterii = Integer.parseInt(CNP.substring(1, 3));
        int lunaNasterii = Integer.parseInt(CNP.substring(3, 5));
        int ziuaNasterii = Integer.parseInt(CNP.substring(5, 7));

        char sex = CNP.charAt(0);
        if(sex == '1' || sex == 2){
            anulNasterii += 1900;
        }else if(sex == '5' || sex == '6'){
            anulNasterii += 2000;
        }else{
            return -1;
        }

        LocalDate dataNasterii = LocalDate.of(anulNasterii, lunaNasterii, ziuaNasterii);
        LocalDate dataCureanta= LocalDate.now();
        Period perioada = Period.between(dataNasterii, dataCureanta);

        return perioada.getYears();
    }
    protected String afisare_persoana(){
        return nume + ",CNP : " + CNP + "Varsta : " + getVarsta();
    }
}
public class MainApp {
    public static boolean cnpValid(String CNP){
        if(CNP.length() != 13){
            return false;
        }
        if(!CNP.matches("\\d+")){
            return false;
        }
        if(CNP.charAt(0) != 1 && CNP.charAt(0) != 2 && CNP.charAt(0) != 5 && CNP.charAt(0) != 6){
            return false;
        }

        int[] coeficienti = {2,7,9,1,4,6,3,5,8,2,7,9};
        int suma=0;
        for(int i=0;i<12;i++){
            suma += (CNP.charAt(i) - '0') * coeficienti[i];
        }
        int cifraControl = suma % 11;
        if(cifraControl == 10){
            cifraControl = 1;
        }
        return cifraControl == (CNP.charAt(15)- '0');
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul de persoane : ");
        int n = scanner.nextInt();
        String CNP = scanner.next();

        Persoana[] persoane = new Persoana[n];

        for(int i=0;i<n;i++){
            System.out.print("Introduceti numele persoanei " + i + " : ");
            String nume = scanner.nextLine();

            do {
                System.out.print("Introduceti CNP-ul persoanei " + i + " : ");
                CNP = scanner.nextLine();
            }while(!cnpValid(CNP));
            persoane[i] = new Persoana(nume, CNP);
        }

        //afisam
        System.out.println("\nPersoanele introduse : \n\n");
        for(Persoana p :persoane){
            System.out.println(p);
        }
    }
}
