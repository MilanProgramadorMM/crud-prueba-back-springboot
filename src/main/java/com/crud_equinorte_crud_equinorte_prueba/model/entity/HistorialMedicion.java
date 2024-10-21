package com.crud_equinorte_crud_equinorte_prueba.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "historial_medicion")
public class HistorialMedicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_indicador")
    private Long indicadorId;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "valor_medido")
    private double valorMedido;

    @Column(name = "descripcion")
    private String descripcion;

}
