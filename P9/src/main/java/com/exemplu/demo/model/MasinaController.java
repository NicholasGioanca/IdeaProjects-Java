package com.example.demo.controller;

import com.example.demo.model.Masina;
import com.example.demo.service.MasinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masini")
public class MasinaController {
    private final MasinaService masinaService;
    private static final Logger logger = LoggerFactory.getLogger(MasinaController.class);

    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }

    @PostMapping
    public Masina adaugaMasina(@RequestBody Masina masina) {
        logger.info("Adăugare mașină: " + masina);
        return masinaService.adaugaMasina(masina);
    }

    @DeleteMapping("/{nrInmatriculare}")
    public void stergeMasina(@PathVariable String nrInmatriculare) {
        logger.info("Ștergere mașină cu numărul: " + nrInmatriculare);
        masinaService.stergeMasina(nrInmatriculare);
    }

    @GetMapping("/{nrInmatriculare}")
    public Masina cautaMasina(@PathVariable String nrInmatriculare) {
        logger.info("Căutare mașină cu numărul: " + nrInmatriculare);
        return masinaService.cautaMasina(nrInmatriculare);
    }

    @GetMapping
    public List<Masina> getToateMasinile() {
        logger.info("Afișare toate mașinile");
        return masinaService.getToateMasinile();
    }

    @GetMapping("/marca/{marca}")
    public long numarMasiniCuMarca(@PathVariable String marca) {
        logger.info("Număr mașini cu marca: " + marca);
        return masinaService.numarMasiniCuMarca(marca);
    }

    @GetMapping("/km")
    public List<Masina> masiniCuKilometriSub(@RequestParam int km) {
        logger.info("Afișare mașini cu kilometri sub: " + km);
        return masinaService.masiniCuKilometriSub(km);
    }

    @GetMapping("/noi")
    public List<Masina> masiniMaiNoiDe5Ani() {
        logger.info("Afișare mașini mai noi de 5 ani");
        return masinaService.masiniMaiNoiDe5Ani();
    }
}
