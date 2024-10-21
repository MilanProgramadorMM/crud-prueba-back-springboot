package com.crud_equinorte_crud_equinorte_prueba.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "indicador")
public class Indicador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "valor_minimo")
    private double valorMinimo;

    @Column(name = "valor_esperado")
    private double valorEsperado;

    @Column(name = "valor_maximo")
    private double valorMaximo;


}
