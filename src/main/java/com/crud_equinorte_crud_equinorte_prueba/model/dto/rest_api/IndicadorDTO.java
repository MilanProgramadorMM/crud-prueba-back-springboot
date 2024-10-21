package com.crud_equinorte_crud_equinorte_prueba.model.dto.rest_api;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class IndicadorDTO {

    private Long id;

    @NotNull(message = "El nombre del indicador es necesario")
    @NotEmpty(message = "El nombre del indicador es necesario")
    private String nombre;

    @NotNull(message = "El valor minimo no debe ser nulo")
    private double valorMinimo;

    @NotNull(message = "El valor esperado no debe ser nulo")
    private double valorEsperado;

    @NotNull(message = "El valor maximo no debe ser nulo")
    private double valorMaximo;

}
