package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Masina {
    @Id
    private Integer id;
    private String nrInmatriculare;
    private String marca;
    private int anFabricatie;
    private String culoare;
    private int kilometri;
}
