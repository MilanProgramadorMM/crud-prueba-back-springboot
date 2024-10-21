package com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class HistorialMedicionDTO {

    @NotNull
    private Long id;

    @NotNull(message = "El id del indicador no debe ser nulo")
    private Long indicadorId;

    @NotNull
    @NotNull(message = "La fecha de medicion no puese ser nula")
    private LocalDate fecha;

    @NotNull(message = "El valor de medicion no debe ser nulo")
    private double valorMedido;

    @NotNull(message = "El nombre del indicador es necesario")
    @NotEmpty(message = "El nombre del indicador es necesario")
    private String descripcion;
}
