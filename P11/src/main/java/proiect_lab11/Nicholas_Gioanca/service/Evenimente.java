package proiect_lab11.Nicholas_Gioanca.service;

import proiect_lab11.Nicholas_Gioanca.models.EvenimenteEntity;

import java.util.Date;
import java.util.List;

public interface Evenimente {

    List<EvenimenteEntity> getEvenimente();

    EvenimenteEntity addEveniment(EvenimenteEntity eveniment);

    List<EvenimenteEntity> getEventsByDate(Date data);

    List<EvenimenteEntity> getEvenimenteByLoc(String loc);

    EvenimenteEntity updateEveniment(Integer id, EvenimenteEntity eveniment);

    void deleteEveniment(Integer id);

}
