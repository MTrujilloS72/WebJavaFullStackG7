package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "direccion")
@Getter
@Setter
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avenida", length = 100)
    private String avenida;

    @Column(name = "numero")
    private int numero;

    @Column(name = "distrito", length = 50)
    private String distrito;

    @Column(name = "provincia", length = 50)
    private String provincia;

    @Column(name = "departamento", length = 50)
    private String departamento;
}
