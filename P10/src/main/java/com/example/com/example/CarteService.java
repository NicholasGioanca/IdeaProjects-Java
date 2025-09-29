package com.example.com.example;


import com.example.entity.Carte;
import com.example.repo.CarteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteService {
    @Autowired
    CarteRepo repository;

    public List<Carte> findAll() {
        return repository.findAll();
    }

    public Carte findByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    public Carte save(Carte carte) {
        return repository.save(carte);
    }

    public Carte update(Carte carte) {
        return repository.save(carte);
    }

    public void deleteByIsbn(String isbn) {
        repository.deleteByIsbn(isbn);
    }

    public List<Carte> findByAutor(String autor) {
        return repository.findByAutor(autor);
    }

}