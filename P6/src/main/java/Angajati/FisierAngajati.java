package Angajati;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
public class FisierAngajati {
    private List<Angajat> angajati;
    private final ObjectMapper mapper;

    public FisierAngajati() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    public void citesteAngajatiDinFisier(String fisier) throws IOException{
        angajati = mapper.readValue(new File(fisier), new TypeReference<List<Angajat>>() {});
    }
    public void scrieAngajatiInFisier(String fisier) throws IOException{
        mapper.writeValue(new File(fisier), angajati);
    }
    public List<Angajat> getAngajati() {
        return angajati;
    }
    public void setAngajati(List<Angajat> angajati) {
        this.angajati = angajati;
    }
}
