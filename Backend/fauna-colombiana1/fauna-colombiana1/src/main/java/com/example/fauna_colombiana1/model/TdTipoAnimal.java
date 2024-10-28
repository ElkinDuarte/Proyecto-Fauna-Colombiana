package com.example.fauna_colombiana1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tdtipoanimal")
public class TdTipoAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTipo_Animal")
    private Integer idTipoAnimal;

    @Column(name = "descrip")
    private String descripcion;
}
