package com.example;

import com.example.entity.Carte;
import com.example.service.CarteService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@Controller
@Transactional
public class CarteWebController {
    @Autowired
    CarteService carteService;

    private Logger logger = Logger.getLogger(CarteWebController.class.getName());


    @GetMapping("/lista-carti")
    public String getListaCarti(Model model) {
        String str = "Lista cartilor din repository";
        model.addAttribute("str", str);
        model.addAttribute("lista", carteService.findAll());

        return "carti";
    }

    //Operatie ADAUGARE
    @RequestMapping(value = "/operatii", params = "adauga", method = RequestMethod.POST)
    public String operatieAdaugare(@ModelAttribute Carte carte, Model model) {
        if(carte.getIsbn().isBlank() || carte.getTitlu().isBlank() || carte.getAutor().isBlank()) {
            model.addAttribute("str",
                    "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!");
            model.addAttribute("lista", carteService.findAll());
            return "carti";
        }
        if(carteService.findByIsbn(carte.getIsbn()) != null) {
            model.addAttribute("str",
                    "Cartea cu ISBN-ul " + carte.getIsbn() + " exista deja in repository!");
            model.addAttribute("lista", carteService.findAll());
            return "carti";
        }

        carteService.save(carte);
        model.addAttribute("str", "Adaugare realizata cu succes!");
        model.addAttribute("lista", carteService.findAll());
        logger.info("\nCartea a fost adaugata cu succes " + carte.toString());
        return "carti";
    }

    //Operatie MODIFICARE
    @RequestMapping(value = "/operatii", params = "modifica", method = RequestMethod.POST)
    public String operatieModificare(@ModelAttribute Carte carte, Model model) {
        if(carteService.findByIsbn(carte.getIsbn())==null) {
            model.addAttribute("str", "Nu se gaseste nicio carte cu ISBN-ul introdus");
            model.addAttribute("lista", carteService.findAll());
            return "carti";
        };
        if(carte.getTitlu().isBlank() || carte.getAutor().isBlank()) {
            model.addAttribute("str",
                    "Modificarea nu se realizeaza daca nu completati toate caracteristicile!");
            model.addAttribute("lista", carteService.findAll());
            return "carti";
        }

        carteService.update(carte);


        model.addAttribute("str", "Cartea cu ISBN-ul " + carte.getIsbn() +
                " a fost modificata cu succes!");
        model.addAttribute("lista", carteService.findAll());
        logger.info("\nCartea a fost modificata cu succes" + carte.toString());
        return "carti";
    }


    //Operatie STERGERE
    @RequestMapping(value = "/operatii", params = "sterge", method = RequestMethod.POST)
    public String operatieStergere(@ModelAttribute Carte carte, Model model) {
        if(carteService.findByIsbn(carte.getIsbn())==null) {
            model.addAttribute("str", "Nu se gaseste nicio carte cu ISBN-ul introdus");
            model.addAttribute("lista", carteService.findAll());
            return "carti";
        }

        carteService.deleteByIsbn(carte.getIsbn());
        model.addAttribute("str", "Stergerea cartii cu ISBN-ul " + carte.getIsbn()
                + " a fost realizata cu succes!");
        model.addAttribute("lista", carteService.findAll());
        logger.info("\nCartea cu ISBN-ul " + carte.getIsbn() + " a fost realizata cu succes");
        return "carti";
    }

    //OPERATIE FILTRARE_DUPA_AUTOR
    @RequestMapping(value = "/operatii", params = "filtreazaDupaAutor", method = RequestMethod.POST)
    public String operatieFiltrareDupaAutor(@ModelAttribute Carte carte , Model model) {
        if(carte.getAutor().isBlank()) {
            model.addAttribute("str", "Lista cartillor din repository");
            model.addAttribute("lista", carteService.findAll());
            return "carti";
        }

        model.addAttribute("str", "Lista cartilor cu autorul " + carte.getAutor());
        model.addAttribute("lista", carteService.findByAutor(carte.getAutor()));
        return "carti";
    }



}
