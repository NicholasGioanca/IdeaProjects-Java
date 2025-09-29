package com.example.demo.repository;

import com.example.demo.model.Masina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasinaRepository extends CrudRepository<Masina, Integer> {
    List<Masina> findByMarca(String marca);
    Masina findByNrInmatriculare(String nrInmatriculare);
    long countByMarca(String marca);
    List<Masina> findByKilometriLessThan(int km);
    List<Masina> findByAnFabricatieGreaterThanEqual(int anMinim);
}
