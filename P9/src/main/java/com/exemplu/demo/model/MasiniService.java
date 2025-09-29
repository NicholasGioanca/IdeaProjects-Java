package com.example.demo.service;

import com.example.demo.model.Masina;
import com.example.demo.repository.MasinaRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class MasinaService {
    private final MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public Masina adaugaMasina(Masina masina) {
        return masinaRepository.save(masina);
    }

    public void stergeMasina(String nrInmatriculare) {
        Masina masina = masinaRepository.findByNrInmatriculare(nrInmatriculare);
        if (masina != null) {
            masinaRepository.delete(masina);
        }
    }

    public Masina cautaMasina(String nrInmatriculare) {
        return masinaRepository.findByNrInmatriculare(nrInmatriculare);
    }

    public List<Masina> getToateMasinile() {
        return (List<Masina>) masinaRepository.findAll();
    }

    public long numarMasiniCuMarca(String marca) {
        return masinaRepository.countByMarca(marca);
    }

    public List<Masina> masiniCuKilometriSub(int km) {
        return masinaRepository.findByKilometriLessThan(km);
    }

    public List<Masina> masiniMaiNoiDe5Ani() {
        int anCurent = Year.now().getValue();
        return masinaRepository.findByAnFabricatieGreaterThanEqual(anCurent - 5);
    }
}
