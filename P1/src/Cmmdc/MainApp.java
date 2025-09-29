package Cmmdc;

import java.util.Random;

public class MainApp {
    public static int cmmdc(int a,int b){
        while(b!=0)
        {
            int aux = b;
            b = a % b;
            a=aux;
        }
        return a;
    }
    public static void main(String[] args) {
        Random random = new Random();

        int a = random.nextInt(30);
        int b = random.nextInt(30);

        System.out.println("Cele doua numere generate aleator sunt : ");
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("Cel mai mic divizor comun al numerelor este : "+cmmdc(a,b));
    }
}
