package Angajati;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        FisierAngajati Fisier = new FisierAngajati();

        //citim angajatii JSON
        try{
            Fisier.citesteAngajatiDinFisier("src/main/resources/angajati.json");
    }catch (Exception e){
        System.out.println("Eroare la citirea din fisier " + e.getMessage());
        return;
        }

        List<Angajat> angajati = Fisier.getAngajati();

        //1.Afisarea listei de angajati folosind referinte la metode
        System.out.println("Lista de angajati: ");
        angajati.forEach(System.out::println);

        //2.Afisarea angajatilor care au salariul peste 2500 RON
        System.out.println("Angajatii ce au salariul mai mare de 2500 de RON: ");
        angajati.stream()
                .filter(angajat -> angajat.getSalariu() > 2500)
                .forEach(System.out::println);

        //3.Crearea unei liste cu angajati din luna aprilie, anul trecut, cu functie de conducere
        int anulTrecut = LocalDate.now().getYear() - 1;
        List <Angajat> angajatiConducereAprilie = (List<Angajat>) angajati.stream()
                .filter(angajat -> angajat.getDataAngajarii().getYear() == anulTrecut)
                .filter(angajat -> angajat.getDataAngajarii().getMonth() == Month.APRIL)
                .filter(angajat ->angajat.getPost().toLowerCase().contains("sef") ||
                        angajat.getPost().toLowerCase().contains("director"))
                .collect(Collectors.toList());
        System.out.println("Angajatii din luna aprilie anul trecut cu fcuntie de conducerer sunt: ");
        angajatiConducereAprilie.forEach(System.out::println);

        //4.Afisarea angajatilor fara functie de conducere, ordonati descrescator dupa salariu
        System.out.println("Lista de angajati fara functie de conducere, ordonati descrescator dupa salariu: ");
        angajati.stream()
                .filter(angajat -> !angajat.getPost().toLowerCase().contains("sef") &&
                        !angajat.getPost().toLowerCase().contains("director"))
                .sorted(Comparator.comparing(Angajat::getSalariu).reversed())
                .forEach(System.out::println);

        //5.Lista cu numele angajatilor scrise cu majuscule
        System.out.println("Lista angajatilor cu majuscule : ");
        List <String> numeAngajatiMajuscule = (List<String>) angajati.stream()
                .map(angajat -> angajat.getNume().toUpperCase())
                .collect(Collectors.toList());
        numeAngajatiMajuscule.forEach(System.out::println);

        //6.Afisarea salariilor mai mici de 3000 RON
        System.out.println("Angajatii cu salarii mai mici de 3000 RON: ");
        angajati.stream()
                .map(Angajat::getSalariu)
                .filter(salariu -> salariu < 3000)
                .forEach(System.out::println);

        // 7. Afișarea datelor primului angajat al firmei
        System.out.println("\nPrimul angajat al firmei:");
        Optional<Angajat> primulAngajat = angajati.stream()
                .min(Comparator.comparing(Angajat::getDataAngajarii));
        primulAngajat.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Nu există angajați.")
        );

        //8.Statistici despre salarii
        System.out.println("\nStatistici despre salarii: ");
        DoubleStream salariiStream = angajati.stream().mapToDouble(Angajat::getSalariu);
        angajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariu)).getAverage();
        System.out.printf("Salariul mediu: %.2f\n", salariiStream.average().orElse(0));
        System.out.printf("Salariul minim: %.2f\n", salariiStream.min().orElse(0));
        System.out.printf("Salariul maxim: %.2f\n", salariiStream.max().orElse(0));

        //9.Verificarea existentei unui angajat numit Ion
        System.out.println("\nVerificarea angajatilor pe nume Ion: ");
        angajati.stream()
                .map(Angajat::getNume)
                .filter(nume -> nume.equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse(
                        nume -> System.out.println("Firma are cel putin un Ion angajat."),
                        () -> System.out.println("Firma nu are niciun Ion angajat.")
                );

        // 10. Numărul de persoane angajate vara anului precedent
        System.out.println("\nNumăr angajați angajați vara anului precedent:");
        long numarAngajatiVara = angajati.stream()
                .filter(angajat -> angajat.getDataAngajarii().getYear() == anulTrecut)
                .filter(angajat -> angajat.getDataAngajarii().getMonth().getValue() >= 6 &&
                        angajat.getDataAngajarii().getMonth().getValue() <= 8)
                .count();
        System.out.println("Numărul de persoane angajate vara anului precedent: " + numarAngajatiVara);
    }
}












