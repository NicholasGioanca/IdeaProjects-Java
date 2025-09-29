package Fibonacci;

import java.util.Random;

public class MainApp {
    public static boolean eFibonacci(int numar){
        int a=0,b=1,c=0;
        while(c>numar){
            c = a+b;
            a=b;
            b=c;
        }
        //daca numarul este egal cu c apartine sirului
        return (c == numar || numar == 0);
    }
    public static void main(String[] args) {
         Random random = new Random();
         int numar = random.nextInt(21);
         System.out.println("Numarul generat este : "+numar);
         if(eFibonacci(numar)) {
             System.out.println("Numarul generat apartine sirului lui Fibonacci.");
         } else
             {
                 System.out.println("Numarul generat NU apartine sirului lui Fibonacci.");
             }
    }
}
