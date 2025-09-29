package Judete;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static <string> void main(String[] args) throws IOException {
        try {

            //File file = new File("C:\\Users\\Judete\\Desktop\\Judete.txt");
            File file = new File("Judete.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            String[] judete = content.toString().split("\n");
            Arrays.sort(judete);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti judetul cautat : ");
            ;
            String judet = scanner.nextLine();

            int pozitie = Arrays.binarySearch(judete, judet);

            if (pozitie > 0) {
                System.out.println("Judetul" + judet + "se afla pe pozitia " + pozitie);
            } else {
                System.out.println("Judetul " + judet + " nu a fost gasit");
            }
        }catch(IOException e){
            System.out.println("Eroare la citirea fisierului : " + e.getMessage());
        }
    }
}
