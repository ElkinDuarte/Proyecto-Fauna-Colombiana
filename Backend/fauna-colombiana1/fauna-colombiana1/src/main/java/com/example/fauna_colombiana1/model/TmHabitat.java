package com.example.fauna_colombiana1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tmhabitat")
public class TmHabitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDHabitat")
    private Integer idHabitat;

    @Column(name = "nom_Habitat")
    private String nomHabitat;

    @Column(name = "des_Habitat")
    private String desHabitat;
}