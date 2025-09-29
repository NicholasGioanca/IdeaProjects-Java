package InstrumenteMuzicale;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) throws IOException {
        // 1) Crearea colecției de instrumente muzicale
        Set<InstrumentMuzical> instrumente = new HashSet<>();

        // Adăugarea a 3 chitări
        instrumente.add(new Chitara("Fender", 1500, Chitara.TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Yamaha", 1200, Chitara.TipChitara.ACUSTICA, 6));
        instrumente.add(new Chitara("Cordoba", 1000, Chitara.TipChitara.CLASICA, 6));

        // Adăugarea a 3 seturi de tobe
        instrumente.add(new SetTobe("Roland", 2500, SetTobe.TipTobe.ELECTRONICE, 5, 2));
        instrumente.add(new SetTobe("Pearl", 3500, SetTobe.TipTobe.ACUSTICE, 5, 2));
        instrumente.add(new SetTobe("Tama", 3000, SetTobe.TipTobe.ACUSTICE, 6, 3));

        // 2) Salvarea colecției în fișierul JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        mapper.writeValue(new File("instrumente.json"), instrumente);
        System.out.println("Colecția a fost salvată în fișierul 'instrumente.json'");

        // 3) Citirea datelor din fișierul JSON
        Set<InstrumentMuzical> instrumenteDinFisier = mapper.readValue(new File("instrumente.json"), HashSet.class);

        // 4) Afișarea implementării utilizate pentru interfața Set de către ObjectMapper
        System.out.println("\nTipul colecției Set citit din JSON:");
        System.out.println(instrumenteDinFisier.getClass());

        // 5) Verificarea dacă Set permite duplicate
        InstrumentMuzical chitaraNoua = new Chitara("Fender", 1500, Chitara.TipChitara.ELECTRICA, 6);
        if (instrumente.contains(chitaraNoua)) {
            System.out.println("\nInstrumentul cu aceleași caracteristici există deja în colecție!");
        } else {
            instrumente.add(chitaraNoua);
        }

        // 6) Ștergerea instrumentelor cu prețul mai mare de 3000 RON
        instrumente.removeIf(instrument -> instrument.getPret() > 3000);
        System.out.println("\nInstrumentele rămase după ștergerea celor cu prețul mai mare de 3000 RON:");
        instrumente.forEach(instrument -> System.out.println(instrument.detalii()));

        // 7) Afișarea datelor chitărilor utilizând Stream API și operatorul instanceof
        System.out.println("\nDatele chitărilor:");
        instrumente.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .forEach(instrument -> System.out.println(instrument.detalii()));

        // 8) Afișarea datelor tobelor utilizând Stream API și metoda getClass()
        System.out.println("\nDatele tobelor:");
        instrumente.stream()
                .filter(instrument -> instrument.getClass().equals(SetTobe.class))
                .forEach(instrument -> System.out.println(instrument.detalii()));

        // 9) Afișarea datelor chitării cu cele mai multe corzi utilizând Stream API și Optional
        Optional<Chitara> chitaraMaxCorzi = instrumente.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .map(instrument -> (Chitara) instrument)
                .max((chitara1, chitara2) -> Integer.compare(chitara1.getNrCorzi(), chitara2.getNrCorzi()));

        chitaraMaxCorzi.ifPresent(chitara -> System.out.println("\nChitara cu cele mai multe corzi: " + chitara.detalii()));

        // 10) Afișarea tobelor acustice ordonate după numărul de tobe
        System.out.println("\nTobe acustice ordonate după numărul de tobe:");
        instrumente.stream()
                .filter(instrument -> instrument instanceof SetTobe)
                .map(instrument -> (SetTobe) instrument)
                .filter(setTobe -> setTobe.getTipTobe() == SetTobe.TipTobe.ACUSTICE)
                .sorted((set1, set2) -> Integer.compare(set1.getNrTobe(), set2.getNrTobe()))
                .forEach(setTobe -> System.out.println(setTobe.detalii()));
    }
}
