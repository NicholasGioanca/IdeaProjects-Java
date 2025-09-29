package Dreptunghi;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);;
        System.out.print("Introdu lungimea dreptunghiului : ");
        int lungime = scanner.nextInt();;

        System.out.print("Introdu latimea dreptunghiului : ");
        int latime = scanner.nextInt();

        int perimetru = 2*(lungime+latime);
        int arie = lungime*latime;;

        System.out.println("Perimetrul dreptunghiului este : "+perimetru);
        System.out.println("Aria dreptunghiului este : "+arie);
    }

}
