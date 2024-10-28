package com.example.fauna_colombiana1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tmanimal")
public class TmAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAnimal")
    private Integer idAnimal;

    @Column(name = "img_Fondo")
    private String imgFondo;

    @Column(name = "nom_Com")
    private String nomCom;

    @Column(name = "nom_Cie")
    private String nomCie;

    @Column(name = "des_General")
    private String desGeneral;

    @OneToOne
    @JoinColumn(name = "FKCaracteristicas")
    private TdCaracteristicas caracteristicas;

    @Column(name = "Curiosidades")
    private String curiosidades;

    @ManyToOne
    @JoinColumn(name = "FKHabitat")
    private TmHabitat habitat;

    @Column(name = "regiones")
    private String regiones;

    @Column(name = "img_Slide")
    private String imgSlide;
}