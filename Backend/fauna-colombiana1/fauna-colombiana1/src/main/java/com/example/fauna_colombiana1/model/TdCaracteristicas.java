package com.example.fauna_colombiana1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tdcaracteristicas")
public class TdCaracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCaracteristica")
    private Integer idCaracteristica;
        
    @Column(name = "Tamaño")
    private String tamano;

    @Column(name = "Peso")
    private String peso;

    @Column(name = "Coloracion")
    private String coloracion;

    @ManyToOne
    @JoinColumn(name = "FKHabitat")
    private TmHabitat habitat;

    @Column(name = "Dieta")
    private String dieta;

    @Column(name = "Comportamiento")
    private String comportamiento;

    @Column(name = "Conservacion")
    private String conservacion; 
    
    @ManyToOne
    @JoinColumn(name = "FKTipo_Animal")
    private TdTipoAnimal tipoAnimal;  
}
